// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.enums.extensible.generated;

import com.azure.core.http.HttpClient;
import com.azure.core.http.policy.HttpLogDetailLevel;
import com.azure.core.http.policy.HttpLogOptions;
import com.azure.core.test.TestBase;
import com.azure.core.test.TestMode;
import com.enums.extensible.ExtensibleClient;
import com.enums.extensible.ExtensibleClientBuilder;

class ExtensibleClientTestBase extends TestBase {
    protected ExtensibleClient extensibleClient;

    @Override
    protected void beforeTest() {
        ExtensibleClientBuilder extensibleClientbuilder =
                new ExtensibleClientBuilder()
                        .httpClient(HttpClient.createDefault())
                        .httpLogOptions(new HttpLogOptions().setLogLevel(HttpLogDetailLevel.BASIC));
        if (getTestMode() == TestMode.PLAYBACK) {
            extensibleClientbuilder.httpClient(interceptorManager.getPlaybackClient());
        } else if (getTestMode() == TestMode.RECORD) {
            extensibleClientbuilder.addPolicy(interceptorManager.getRecordPolicy());
        }
        extensibleClient = extensibleClientbuilder.buildClient();
    }
}