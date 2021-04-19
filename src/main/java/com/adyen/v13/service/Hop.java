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

import com.adyen.v13.Client;
import com.adyen.v13.Service;
import com.adyen.v13.model.hop.GetOnboardingUrlRequest;
import com.adyen.v13.model.hop.GetOnboardingUrlResponse;
import com.adyen.v13.service.exception.ApiException;
import com.adyen.v13.service.resource.hop.GetOnboardingUrl;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;

public class Hop extends Service {

    private GetOnboardingUrl getOnboardingUrl;

    public Hop(Client client) {
        super(client);
        getOnboardingUrl = new GetOnboardingUrl(this);
    }

    public GetOnboardingUrlResponse getOnboardingUrl(GetOnboardingUrlRequest getOnboardingUrlRequest) throws ApiException, IOException {
        String jsonRequest = GSON.toJson(getOnboardingUrlRequest);

        String jsonResult = getOnboardingUrl.request(jsonRequest);

        return GSON.fromJson(jsonResult, new TypeToken<GetOnboardingUrlResponse>() {
        }.getType());
    }
}