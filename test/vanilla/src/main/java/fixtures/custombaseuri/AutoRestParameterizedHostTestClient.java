/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 * Changes may cause incorrect behavior and will be lost if the code is
 * regenerated.
 */

package fixtures.custombaseuri;

/**
 * The interface for AutoRestParameterizedHostTestClient class.
 */
public interface AutoRestParameterizedHostTestClient {

    /**
     * Gets A string value that is used as a global part of the parameterized host
     *
     * @return the host value.
     */
    String host();

    /**
     * Sets A string value that is used as a global part of the parameterized host
     *
     * @param host the host value.
     * @return the service client itself
     */
    AutoRestParameterizedHostTestClient withHost(String host);

    /**
     * Gets the Paths object to access its operations.
     * @return the Paths object.
     */
    Paths paths();

}
