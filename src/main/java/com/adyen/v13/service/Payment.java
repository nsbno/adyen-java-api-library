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
import com.adyen.v13.model.AuthenticationResultRequest;
import com.adyen.v13.model.AuthenticationResultResponse;
import com.adyen.v13.model.PaymentRequest;
import com.adyen.v13.model.PaymentRequest3d;
import com.adyen.v13.model.PaymentRequest3ds2;
import com.adyen.v13.model.PaymentResult;
import com.adyen.v13.model.RequestOptions;
import com.adyen.v13.model.ThreeDS2ResultRequest;
import com.adyen.v13.model.ThreeDS2ResultResponse;
import com.adyen.v13.service.exception.ApiException;
import com.adyen.v13.service.resource.payment.Authorise;
import com.adyen.v13.service.resource.payment.Authorise3D;
import com.adyen.v13.service.resource.payment.Authorise3DS2;
import com.adyen.v13.service.resource.payment.GetAuthenticationResult;
import com.adyen.v13.service.resource.payment.Retrieve3DS2Result;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;

public class Payment extends Service {

    private Authorise authorise;
    private Authorise3D authorise3D;
    private Authorise3DS2 authorise3DS2;
    private Retrieve3DS2Result retrieve3DS2Result;
    private GetAuthenticationResult getAuthenticationResult;

    public Payment(Client client) {
        super(client);

        authorise = new Authorise(this);
        authorise3D = new Authorise3D(this);
        authorise3DS2 = new Authorise3DS2(this);
        retrieve3DS2Result = new Retrieve3DS2Result(this);
        getAuthenticationResult = new GetAuthenticationResult(this);
    }

    /**
     * POST /authorise API call
     *
     * @param paymentRequest paymentRequest
     * @return PaymentResult
     * @throws ApiException ApiException
     * @throws IOException  IOException
     */
    public PaymentResult authorise(PaymentRequest paymentRequest) throws ApiException, IOException {
        return authorise(paymentRequest, null);
    }

    public PaymentResult authorise(PaymentRequest paymentRequest, RequestOptions requestOptions) throws ApiException, IOException {
        String jsonRequest = GSON.toJson(paymentRequest);
        String jsonResult = authorise.request(jsonRequest, requestOptions);
        return GSON.fromJson(jsonResult, new TypeToken<PaymentResult>() {
        }.getType());
    }

    /**
     * POST /authorise3d API call
     *
     * @param paymentRequest3d authorise3D
     * @return PaymentResult
     * @throws Exception Exception
     */
    public PaymentResult authorise3D(PaymentRequest3d paymentRequest3d) throws Exception {
        String jsonRequest = GSON.toJson(paymentRequest3d);

        String jsonResult = authorise3D.request(jsonRequest);

        return GSON.fromJson(jsonResult, new TypeToken<PaymentResult>() {
        }.getType());
    }

    /**
     * POST /authorise3ds2 API call
     *
     * @param paymentRequest3ds2 PaymentRequest3ds2
     * @return PaymentResult
     * @throws Exception Exception
     */
    public PaymentResult authorise3DS2(PaymentRequest3ds2 paymentRequest3ds2) throws Exception {
        String jsonRequest = GSON.toJson(paymentRequest3ds2);

        String jsonResult = authorise3DS2.request(jsonRequest);

        return GSON.fromJson(jsonResult, new TypeToken<PaymentResult>() {
        }.getType());
    }

    /**
     * POST /retrieve3ds2Result API call
     *
     * @deprecated Use /getAuthenticationResult instead
     * @param threeDS2ResultRequest PaymentRequest3ds2
     * @return PaymentResult
     * @throws Exception Exception
     */
    @Deprecated
    public ThreeDS2ResultResponse retrieve3ds2Result(ThreeDS2ResultRequest threeDS2ResultRequest) throws Exception {
        String jsonRequest = GSON.toJson(threeDS2ResultRequest);

        String jsonResult = retrieve3DS2Result.request(jsonRequest);

        return GSON.fromJson(jsonResult, new TypeToken<ThreeDS2ResultResponse>() {
        }.getType());
    }

    /**
     * POST /getAuthenticationResult API call
     *
     * @param authenticationResultRequest AuthenticationResultRequest
     * @return AuthenticationResultResponse
     * @throws ApiException ApiException
     * @throws IOException  IOException
     */
    public AuthenticationResultResponse getAuthenticationResult(AuthenticationResultRequest authenticationResultRequest) throws IOException, ApiException {
        String jsonRequest = GSON.toJson(authenticationResultRequest);

        String jsonResult = getAuthenticationResult.request(jsonRequest);

        return GSON.fromJson(jsonResult, new TypeToken<AuthenticationResultResponse>() {
        }.getType());
    }
}
