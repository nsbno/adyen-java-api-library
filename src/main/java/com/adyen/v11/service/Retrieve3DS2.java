
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
 *
 */

package com.adyen.v11.service;

import com.adyen.v11.Client;
import com.adyen.v11.Service;
import com.adyen.v11.model.ThreeDS2ResultRequest;
import com.adyen.v11.model.ThreeDS2ResultResponse;
import com.adyen.v11.service.exception.ApiException;
import com.adyen.v11.service.resource.payment.Retrieve3DS2Result;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;

public class Retrieve3DS2 extends Service {

    private Retrieve3DS2Result retrieve3DS2Result;

    public Retrieve3DS2(Client client) {
        super(client);

        retrieve3DS2Result = new Retrieve3DS2Result(this);
    }

    /**
     * POST /threeDS2Resul" API call
     *
     * @param threeDS2ResultRequest threeDS2ResultRequest
     * @return ThreeDS2ResultResponse
     * @throws  ApiException ApiException
     * @throws  IOException IOException
     */

    public ThreeDS2ResultResponse authorise(ThreeDS2ResultRequest threeDS2ResultRequest) throws ApiException, IOException {
        String jsonRequest = GSON.toJson(threeDS2ResultRequest);
        String jsonResult = retrieve3DS2Result.request(jsonRequest);
        return GSON.fromJson(jsonResult, new TypeToken<ThreeDS2ResultResponse>() {
        }.getType());
    }
}
