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
import com.adyen.v13.Config;
import com.adyen.v13.Service;
import com.adyen.v13.httpclient.ClientInterface;
import com.adyen.v13.httpclient.HTTPClientException;
import com.adyen.v13.model.hpp.DirectoryLookupRequest;
import com.adyen.v13.model.hpp.DirectoryLookupResult;
import com.adyen.v13.model.hpp.PaymentMethod;
import com.adyen.v13.util.HMACValidator;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.security.SignatureException;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

import static com.adyen.v13.constants.HPPConstants.Fields.COUNTRY_CODE;
import static com.adyen.v13.constants.HPPConstants.Fields.CURRENCY_CODE;
import static com.adyen.v13.constants.HPPConstants.Fields.MERCHANT_ACCOUNT;
import static com.adyen.v13.constants.HPPConstants.Fields.MERCHANT_REFERENCE;
import static com.adyen.v13.constants.HPPConstants.Fields.MERCHANT_SIG;
import static com.adyen.v13.constants.HPPConstants.Fields.PAYMENT_AMOUNT;
import static com.adyen.v13.constants.HPPConstants.Fields.SESSION_VALIDITY;
import static com.adyen.v13.constants.HPPConstants.Fields.SKIN_CODE;
import static com.adyen.v13.constants.HPPConstants.Response.SHOPPER_LOCALE;

public class HostedPaymentPages extends Service {
    public HostedPaymentPages(Client client) {
        super(client);
    }

    public String directoryLookup(Map<String, String> postParameters) throws HTTPClientException, IOException {
        String endpoint = getClient().getConfig().getHppEndpoint() + "/directory.shtml";
        ClientInterface httpClient = getClient().getHttpClient();
        Config config = getClient().getConfig();

        return httpClient.post(endpoint, postParameters, config);
    }

    public SortedMap<String, String> getPostParametersFromDLRequest(DirectoryLookupRequest request) throws SignatureException {
        Config config = getClient().getConfig();

        // Set HTTP Post variables
        SortedMap<String, String> postParameters = new TreeMap<>();
        postParameters.put(CURRENCY_CODE, request.getCurrencyCode());

        if (request.getMerchantAccount() != null) {
            postParameters.put(MERCHANT_ACCOUNT, request.getMerchantAccount());
        } else {
            postParameters.put(MERCHANT_ACCOUNT, config.getMerchantAccount());
        }

        postParameters.put(PAYMENT_AMOUNT, request.getPaymentAmount());

        if (request.getSkinCode() != null) {
            postParameters.put(SKIN_CODE, request.getSkinCode());
        } else {
            postParameters.put(SKIN_CODE, config.getSkinCode());
        }

        postParameters.put(MERCHANT_REFERENCE, request.getMerchantReference());
        postParameters.put(SESSION_VALIDITY, request.getSessionValidity());
        postParameters.put(COUNTRY_CODE, request.getCountryCode());

        if (request.getShopperLocale() != null) {
            postParameters.put(SHOPPER_LOCALE, request.getShopperLocale());
        }

        HMACValidator hmacValidator = new HMACValidator();

        String dataToSign = hmacValidator.getDataToSign(postParameters);

        String hmacKey;
        if (request.getHmacKey() != null) {
            hmacKey = request.getHmacKey();
        } else {
            hmacKey = config.getHmacKey();
        }

        String merchantSig = hmacValidator.calculateHMAC(dataToSign, hmacKey);
        postParameters.put(MERCHANT_SIG, merchantSig);

        return postParameters;
    }

    public List<PaymentMethod> getPaymentMethods(DirectoryLookupRequest request) throws SignatureException, IOException, HTTPClientException {
        SortedMap<String, String> postParameters = getPostParametersFromDLRequest(request);

        String jsonResult = directoryLookup(postParameters);

        try {
            DirectoryLookupResult directoryLookupResult = GSON.fromJson(jsonResult, new TypeToken<DirectoryLookupResult>() {
            }.getType());

            return directoryLookupResult.getPaymentMethods();
        } catch (JsonSyntaxException e) {
            throw new HTTPClientException(200, "Invalid response or invalid skin code/HMAC key", null, jsonResult);
        }
    }
}