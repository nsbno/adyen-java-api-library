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
 * Copyright (c) 2017 Adyen B.V.
 * This file is open source and available under the MIT license.
 * See the LICENSE file for more info.
 */
package com.adyen.v13.service;

import com.adyen.v13.Client;
import com.adyen.v13.Service;
import com.adyen.v13.model.RequestOptions;
import com.adyen.v13.model.payout.ConfirmThirdPartyRequest;
import com.adyen.v13.model.payout.ConfirmThirdPartyResponse;
import com.adyen.v13.model.payout.DeclineThirdPartyRequest;
import com.adyen.v13.model.payout.DeclineThirdPartyResponse;
import com.adyen.v13.model.payout.PayoutRequest;
import com.adyen.v13.model.payout.PayoutResponse;
import com.adyen.v13.model.payout.StoreDetailAndSubmitRequest;
import com.adyen.v13.model.payout.StoreDetailAndSubmitResponse;
import com.adyen.v13.model.payout.StoreDetailRequest;
import com.adyen.v13.model.payout.StoreDetailResponse;
import com.adyen.v13.model.payout.SubmitRequest;
import com.adyen.v13.model.payout.SubmitResponse;
import com.adyen.v13.service.exception.ApiException;
import com.adyen.v13.service.resource.payout.ConfirmThirdParty;
import com.adyen.v13.service.resource.payout.DeclineThirdParty;
import com.adyen.v13.service.resource.payout.StoreDetail;
import com.adyen.v13.service.resource.payout.StoreDetailAndSubmitThirdParty;
import com.adyen.v13.service.resource.payout.SubmitThirdParty;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;

public class Payout extends Service {
    private final StoreDetailAndSubmitThirdParty storeDetailAndSubmitThirdParty;
    private final ConfirmThirdParty confirmThirdParty;
    private final DeclineThirdParty declineThirdParty;
    private final StoreDetail storeDetail;
    private final SubmitThirdParty submitThirdparty;
    private final com.adyen.v13.service.resource.payout.Payout payout;

    public Payout(Client client) {
        super(client);

        storeDetailAndSubmitThirdParty = new StoreDetailAndSubmitThirdParty(this);
        confirmThirdParty = new ConfirmThirdParty(this);
        declineThirdParty = new DeclineThirdParty(this);
        storeDetail = new StoreDetail(this);
        submitThirdparty = new SubmitThirdParty(this);
        payout = new com.adyen.v13.service.resource.payout.Payout(this);
    }

    /**
     * Issues a storeDetailAndSubmitThirdParty API call
     *
     * @param request StoreDetailAndSubmitRequest
     * @return StoreDetailAndSubmitResponse
     * @throws IOException  IOException
     * @throws ApiException ApiException
     */
    public StoreDetailAndSubmitResponse storeDetailAndSubmitThirdParty(StoreDetailAndSubmitRequest request) throws IOException, ApiException {
        String jsonRequest = GSON.toJson(request);

        String jsonResult = storeDetailAndSubmitThirdParty.request(jsonRequest);

        return GSON.fromJson(jsonResult, new TypeToken<StoreDetailAndSubmitResponse>() {
        }.getType());
    }

    /**
     * Issues a ConfirmThirdParty API call
     *
     * @param request ConfirmThirdPartyRequest
     * @return ConfirmThirdPartyResponse
     * @throws IOException  IOException
     * @throws ApiException ApiException
     */
    public ConfirmThirdPartyResponse confirmThirdParty(ConfirmThirdPartyRequest request) throws IOException, ApiException {
        String jsonRequest = GSON.toJson(request);

        String jsonResult = confirmThirdParty.request(jsonRequest);

        return GSON.fromJson(jsonResult, new TypeToken<ConfirmThirdPartyResponse>() {
        }.getType());
    }

    /**
     * Issues a DeclineThirdParty API call
     *
     * @param request DeclineThirdPartyRequest
     * @return DeclineThirdPartyResponse
     * @throws IOException  IOException
     * @throws ApiException ApiException
     */
    public DeclineThirdPartyResponse declineThirdParty(DeclineThirdPartyRequest request) throws IOException, ApiException {
        String jsonRequest = GSON.toJson(request);

        String jsonResult = declineThirdParty.request(jsonRequest);

        return GSON.fromJson(jsonResult, new TypeToken<DeclineThirdPartyResponse>() {
        }.getType());
    }

    /**
     * Issues a storeDetail API call
     *
     * @param request StoreDetailRequest
     * @return StoreDetailResponse
     * @throws IOException  IOException
     * @throws ApiException ApiException
     */
    public StoreDetailResponse storeDetail(StoreDetailRequest request) throws IOException, ApiException {
        String jsonRequest = GSON.toJson(request);

        String jsonResult = storeDetail.request(jsonRequest);

        return GSON.fromJson(jsonResult, new TypeToken<StoreDetailResponse>() {
        }.getType());
    }

    /**
     * Issues a SubmitThirdParty API call
     *
     * @param request SubmitRequest
     * @return submitThirdparty
     * @throws IOException  IOException
     * @throws ApiException ApiException
     */
    public SubmitResponse submitThirdparty(SubmitRequest request) throws IOException, ApiException {
        String jsonRequest = GSON.toJson(request);

        String jsonResult = submitThirdparty.request(jsonRequest);

        return GSON.fromJson(jsonResult, new TypeToken<SubmitResponse>() {
        }.getType());
    }

    /**
     * Issues a payout API call
     *
     * @param request
     * @return
     * @throws IOException
     * @throws ApiException
     */
    public PayoutResponse payout(PayoutRequest request) throws IOException, ApiException {
        return payout(request, null);
    }

    /**
     * Issues a payout API call
     *
     * @param request
     * @param requestOptions
     * @return
     * @throws IOException
     * @throws ApiException
     */
    public PayoutResponse payout(PayoutRequest request, RequestOptions requestOptions) throws IOException, ApiException {
        String jsonRequest = GSON.toJson(request);

        String jsonResult = payout.request(jsonRequest, requestOptions);

        return GSON.fromJson(jsonResult, new TypeToken<PayoutResponse>() {
        }.getType());
    }
}
