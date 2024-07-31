// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.payload.multipart;

import com.azure.core.util.BinaryData;
import com.payload.FileUtils;
import com.payload.multipart.models.Address;
import com.payload.multipart.models.ComplexHttpPartsModelRequest;
import com.payload.multipart.models.FileRequiredMetaDataFileDetails;
import com.payload.multipart.models.PicturesFileDetails;
import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.util.List;

public class MultipartHttpPartTests {

    private final MultiPartClient client = new MultiPartClientBuilder()
            .buildClient();

    private static final Path FILE = FileUtils.getJpgFile();

    private static final Path PNG_FILE = FileUtils.getPngFile();

    @Test
    public void testComplex() {
        client.complexWithHttpPart(new ComplexHttpPartsModelRequest(
                "123",
                new Address("X"),
                new FileRequiredMetaDataFileDetails(BinaryData.fromFile(FILE), "profileImage", "application/octet-stream"),
                List.of(new Address("Y"), new Address("Z")),
                List.of(new FileRequiredMetaDataFileDetails(BinaryData.fromFile(PNG_FILE), "picture1", "application/octet-stream"), new FileRequiredMetaDataFileDetails(BinaryData.fromFile(PNG_FILE), "picture2", "application/octet-stream"))));
    }
}
