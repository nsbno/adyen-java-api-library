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
 * Copyright (c) 2020 Adyen B.V.
 * This file is open source and available under the MIT license.
 * See the LICENSE file for more info.
 */

package com.adyen.v13.service;

import com.adyen.v13.ApiKeyAuthenticatedService;
import com.adyen.v13.Client;
import com.adyen.v13.model.posterminalmanagement.AssignTerminalsRequest;
import com.adyen.v13.model.posterminalmanagement.AssignTerminalsResponse;
import com.adyen.v13.model.posterminalmanagement.FindTerminalRequest;
import com.adyen.v13.model.posterminalmanagement.FindTerminalResponse;
import com.adyen.v13.model.posterminalmanagement.GetStoresUnderAccountRequest;
import com.adyen.v13.model.posterminalmanagement.GetStoresUnderAccountResponse;
import com.adyen.v13.model.posterminalmanagement.GetTerminalDetailsRequest;
import com.adyen.v13.model.posterminalmanagement.GetTerminalDetailsResponse;
import com.adyen.v13.model.posterminalmanagement.GetTerminalsUnderAccountRequest;
import com.adyen.v13.model.posterminalmanagement.GetTerminalsUnderAccountResponse;
import com.adyen.v13.service.exception.ApiException;
import com.adyen.v13.service.resource.posterminalmanagement.AssignTerminals;
import com.adyen.v13.service.resource.posterminalmanagement.FindTerminal;
import com.adyen.v13.service.resource.posterminalmanagement.GetStoresUnderAccount;
import com.adyen.v13.service.resource.posterminalmanagement.GetTerminalDetails;
import com.adyen.v13.service.resource.posterminalmanagement.GetTerminalsUnderAccount;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;

public class PosTerminalManagement extends ApiKeyAuthenticatedService {

    private AssignTerminals assignTerminals;
    private FindTerminal findTerminal;
    private GetTerminalsUnderAccount getTerminalsUnderAccount;
    private GetStoresUnderAccount getStoresUnderAccount;
    private GetTerminalDetails getTerminalDetails;

    public PosTerminalManagement(Client client) {

        super(client);
        assignTerminals = new AssignTerminals(this);
        findTerminal = new FindTerminal(this);
        getTerminalsUnderAccount = new GetTerminalsUnderAccount(this);
        getStoresUnderAccount = new GetStoresUnderAccount(this);
        getTerminalDetails = new GetTerminalDetails(this);
    }

    /**
     * POST /assignTerminals API call
     *
     * @param assignTerminalsRequest
     * @return
     * @throws ApiException
     * @throws IOException
     */
    public AssignTerminalsResponse assignTerminals(AssignTerminalsRequest assignTerminalsRequest) throws ApiException, IOException {
        String jsonRequest = GSON.toJson(assignTerminalsRequest);
        String jsonResult = assignTerminals.request(jsonRequest);
        return GSON.fromJson(jsonResult, new TypeToken<AssignTerminalsResponse>() {
        }.getType());
    }

    /**
     * POST /findTerminal API call
     *
     * @param findTerminalRequest
     * @return
     * @throws ApiException
     * @throws IOException
     */
    public FindTerminalResponse findTerminal(FindTerminalRequest findTerminalRequest) throws ApiException, IOException {
        String jsonRequest = GSON.toJson(findTerminalRequest);
        String jsonResult = findTerminal.request(jsonRequest);
        return GSON.fromJson(jsonResult, new TypeToken<FindTerminalResponse>() {
        }.getType());
    }

    /**
     * POST /getTerminalsUnderAccount API call
     *
     * @param getTerminalsUnderAccountRequest
     * @return
     * @throws ApiException
     * @throws IOException
     */
    public GetTerminalsUnderAccountResponse getTerminalsUnderAccount(GetTerminalsUnderAccountRequest getTerminalsUnderAccountRequest) throws ApiException, IOException {
        String jsonRequest = GSON.toJson(getTerminalsUnderAccountRequest);
        String jsonResult = getTerminalsUnderAccount.request(jsonRequest);
        return GSON.fromJson(jsonResult, new TypeToken<GetTerminalsUnderAccountResponse>() {
        }.getType());
    }


    /**
     * POST /getStoresUnderAccount API call
     *
     * @param getStoresUnderAccountRequest
     * @return
     * @throws ApiException
     * @throws IOException
     */
    public GetStoresUnderAccountResponse getStoresUnderAccount(GetStoresUnderAccountRequest getStoresUnderAccountRequest) throws ApiException, IOException {
        String jsonRequest = GSON.toJson(getStoresUnderAccountRequest);
        String jsonResult = getStoresUnderAccount.request(jsonRequest);
        return GSON.fromJson(jsonResult, new TypeToken<GetStoresUnderAccountResponse>() {
        }.getType());
    }

    /**
     * POST /getTerminalDetails API call
     *
     * @param getTerminalDetailsRequest
     * @return
     * @throws ApiException
     * @throws IOException
     */
    public GetTerminalDetailsResponse getTerminalDetails(GetTerminalDetailsRequest getTerminalDetailsRequest) throws ApiException, IOException {
        String jsonRequest = GSON.toJson(getTerminalDetailsRequest);
        String jsonResult = getTerminalDetails.request(jsonRequest);
        return GSON.fromJson(jsonResult, new TypeToken<GetTerminalDetailsResponse>() {
        }.getType());
    }

}
