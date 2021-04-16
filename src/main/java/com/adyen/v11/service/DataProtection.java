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
package com.adyen.v11.service;

import com.adyen.v11.Client;
import com.adyen.v11.Service;
import com.adyen.v11.model.RequestOptions;
import com.adyen.v11.model.SubjectErasureRequest;
import com.adyen.v11.model.SubjectErasureResponse;
import com.adyen.v11.service.exception.ApiException;
import com.adyen.v11.service.resource.dataprotection.RequestSubjectErasure;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;

public class DataProtection extends Service {

    private RequestSubjectErasure requestSubjectErasure;

    public DataProtection(Client client) {
        super(client);
        requestSubjectErasure = new RequestSubjectErasure(this);
    }

    /**
     * POST /requestSubjectErasure API call
     *
     * @param subjectErasureRequest subjectErasureRequest
     * @return subjectErasureResponse
     * @throws ApiException ApiException
     * @throws IOException  IOException
     */
    public SubjectErasureResponse requestSubjectErasure(SubjectErasureRequest subjectErasureRequest) throws ApiException, IOException {
        return requestSubjectErasure(subjectErasureRequest, null);
    }

    public SubjectErasureResponse requestSubjectErasure(SubjectErasureRequest subjectErasureRequest, RequestOptions requestOptions) throws ApiException, IOException {
        String jsonRequest = GSON.toJson(subjectErasureRequest);
        String jsonResult = requestSubjectErasure.request(jsonRequest, requestOptions);
        return GSON.fromJson(jsonResult, new TypeToken<SubjectErasureResponse>() {
        }.getType());
    }

}
