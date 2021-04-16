/*
 *                       ######
 *                       ######
 * ############    ####( ######  #####. ######  ############   ############
 * #############  #####( ######  #####. ######  #############  #############
 *        ######  #####( ######  #####. ######  #####  ######  #####  ######
 * ###### ######  #####( ######  #####. ######  #####  #####   #####  ######
 * ###### ######  #####( ######  #####. ######  #####          #####  ######
 * #############  #############  #############  #############  #####  ######
 *  ############   ############  #############   ############  #####  ######
 *                                      ######
 *                               #############
 *                               ############
 *
 * Adyen Java API Library
 *
 * Copyright (c) 2019 Adyen B.V.
 * This file is open source and available under the MIT license.
 * See the LICENSE file for more info.
 */
package com.adyen.v11.service;

import com.adyen.v11.ApiKeyAuthenticatedService;
import com.adyen.v11.Client;
import com.adyen.v11.model.terminal.TerminalAPIRequest;
import com.adyen.v11.model.terminal.TerminalAPIResponse;
import com.adyen.v11.service.exception.ApiException;
import com.adyen.v11.service.resource.terminal.cloud.Async;
import com.adyen.v11.service.resource.terminal.cloud.Sync;
import com.adyen.v11.terminal.serialization.TerminalAPIGsonBuilder;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;

public class TerminalCloudAPI extends ApiKeyAuthenticatedService {

    private Async terminalApiAsync;
    private Sync terminalApiSync;

    private Gson terminalApiGson;

    public TerminalCloudAPI(Client client) {
        super(client);
        terminalApiAsync = new Async(this);
        terminalApiSync = new Sync(this);
        terminalApiGson = TerminalAPIGsonBuilder.create();
    }

    /**
     * POST /async API call
     *
     * @param terminalAPIRequest TerminalAPIRequest
     * @return String string
     * @throws IOException  IOException
     * @throws ApiException ApiException
     */
    public String async(TerminalAPIRequest terminalAPIRequest) throws IOException, ApiException {
        String jsonRequest = terminalApiGson.toJson(terminalAPIRequest);

        return terminalApiAsync.request(jsonRequest);
    }

    /**
     * POST /sync API call
     *
     * @param terminalAPIRequest TerminalAPIRequest
     * @return TerminalAPIResponse
     * @throws IOException  IOException
     * @throws ApiException ApiException
     */
    public TerminalAPIResponse sync(TerminalAPIRequest terminalAPIRequest) throws IOException, ApiException {
        String jsonRequest = terminalApiGson.toJson(terminalAPIRequest);

        String jsonResponse = terminalApiSync.request(jsonRequest);

        if (jsonResponse == null || jsonResponse.isEmpty() || "ok".equals(jsonResponse)) {
            return null;
        }

        return terminalApiGson.fromJson(jsonResponse, new TypeToken<TerminalAPIResponse>() {
        }.getType());
    }
}
