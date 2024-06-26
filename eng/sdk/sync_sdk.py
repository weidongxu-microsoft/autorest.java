#!/usr/bin/env python3

#  Copyright (c) Microsoft Corporation. All rights reserved.
#  Licensed under the MIT License.

import os
import sys
import logging
import argparse
import subprocess
import glob
import shutil
from typing import List

sdk_root: str

skip_artifacts: List[str] = [
    'azure-ai-anomalydetector',         # deprecated
    'azure-ai-vision-imageanalysis',    # temporary disabled for modification on Javadoc
    'azure-analytics-defender-easm'     # https://github.com/Azure/azure-sdk-for-java/issues/39862
]


def parse_args() -> argparse.Namespace:
    parser = argparse.ArgumentParser()
    parser.add_argument(
        '--sdk-root',
        required=True,
        help='azure-sdk-for-java repository root.',
    )
    parser.add_argument(
        '--package-json-path',
        required=True,
        help='path to package.json of typespec-java.',
    )
    return parser.parse_args()


def update_emitter(package_json_path: str):
    logging.info('Update emitter-package.json')
    subprocess.check_call([
        'pwsh',
        './eng/common/scripts/typespec/New-EmitterPackageJson.ps1',
        '-PackageJsonPath',
        package_json_path,
        '-OutputDirectory',
        'eng'],
        cwd=sdk_root)

    logging.info('Update emitter-package-lock.json')
    subprocess.check_call(['tsp-client', '--generate-lock-file'], cwd=sdk_root)


def get_generated_folder_from_artifact(module_path: str, artifact: str, type: str) -> str:
    path = os.path.join(module_path, 'src', type, 'java', 'com')
    for seg in artifact.split('-'):
        path = os.path.join(path, seg)
    path = os.path.join(path, 'generated')
    return path


def update_sdks():
    for tsp_location_file in glob.glob(os.path.join(sdk_root, 'sdk/*/*/tsp-location.yaml')):
        module_path = os.path.dirname(tsp_location_file)
        artifact = os.path.basename(module_path)

        if artifact in skip_artifacts:
            continue

        generated_samples_path = os.path.join(
            module_path, get_generated_folder_from_artifact(module_path, artifact, 'samples'))
        generated_test_path = os.path.join(
            module_path, get_generated_folder_from_artifact(module_path, artifact, 'test'))
        generated_samples_exists = os.path.isdir(generated_samples_path)
        generated_test_exists = os.path.isdir(generated_test_path)

        logging.info('Generate for module %s', artifact)
        subprocess.check_call(['tsp-client', 'update'], cwd=module_path)

        if not generated_samples_exists:
            shutil.rmtree(generated_samples_path, ignore_errors=True)
        if not generated_test_exists:
            shutil.rmtree(generated_test_path, ignore_errors=True)

    cmd = ['git', 'add', '.']
    subprocess.check_call(cmd, cwd=sdk_root)


def main():
    global sdk_root

    args = vars(parse_args())
    sdk_root = args['sdk_root']

    update_emitter(args['package_json_path'])

    update_sdks()


if __name__ == '__main__':
    logging.basicConfig(
        stream=sys.stdout,
        level=logging.INFO,
        format='%(asctime)s %(levelname)s %(message)s',
        datefmt='%Y-%m-%d %X',
    )
    main()
