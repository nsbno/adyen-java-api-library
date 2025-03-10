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
package com.adyen.v13.service;

import com.adyen.v13.ApiKeyAuthenticatedService;
import com.adyen.v13.Client;
import com.adyen.v13.model.terminal.ConnectedTerminalsRequest;
import com.adyen.v13.model.terminal.ConnectedTerminalsResponse;
import com.adyen.v13.service.exception.ApiException;
import com.adyen.v13.service.resource.terminal.cloud.ConnectedTerminals;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;

public class PosPayment extends ApiKeyAuthenticatedService {

    private ConnectedTerminals connectedTerminals;

    public PosPayment(Client client) {
        super(client);
        connectedTerminals = new ConnectedTerminals(this);
    }

    /**
     * POST /connectedTerminals API call
     *
     * @param connectedTerminalsRequest ConnectedTerminalsRequest
     * @return ConnectedTerminalsResponse
     * @throws IOException  IOException
     * @throws ApiException ApiException
     */
    public ConnectedTerminalsResponse connectedTerminals(ConnectedTerminalsRequest connectedTerminalsRequest) throws IOException, ApiException {
        String jsonRequest = GSON.toJson(connectedTerminalsRequest);
        String jsonResult = connectedTerminals.request(jsonRequest);
        return GSON.fromJson(jsonResult, new TypeToken<ConnectedTerminalsResponse>() {
        }.getType());
    }
}
