#!/usr/bin/env python3

#  Copyright (c) Microsoft Corporation. All rights reserved.
#  Licensed under the MIT License.

import os
import sys
import logging
import argparse
import subprocess
import glob
import json
import shutil
from typing import List

sdk_root: str


def parse_args() -> argparse.Namespace:
    parser = argparse.ArgumentParser()
    parser.add_argument(
        '--sdk-root',
        required=True,
        help='azure-sdk-for-java repository root.',
    )
    return parser.parse_args()


def update_sdks():
    for pom_file in glob.glob(os.path.join(sdk_root, 'sdk/*/azure-*/pom.xml')):
        module_path = os.path.dirname(pom_file)
        artifact = os.path.basename(module_path)
        if not artifact.startswith('azure-resourcemanager-') and not artifact.startswith('azure-sdk-'):
            count = 0
            for java_file in glob.glob(os.path.join(module_path, 'src/**/*.java'), recursive=True):
                with open(java_file, "r", encoding='utf-8') as f:
                    content = f.read()
                    if '@Generated' in content:
                        count += 1
            if count > 0:
                print(f"{artifact}, count {count}")


def main():
    global sdk_root

    args = vars(parse_args())
    sdk_root = args['sdk_root']

    update_sdks()


if __name__ == '__main__':
    logging.basicConfig(
        stream=sys.stdout,
        level=logging.INFO,
        format='%(asctime)s %(levelname)s %(message)s',
        datefmt='%Y-%m-%d %X',
    )
    main()
