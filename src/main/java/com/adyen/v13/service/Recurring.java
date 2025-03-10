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
import com.adyen.v13.model.recurring.DisableRequest;
import com.adyen.v13.model.recurring.DisableResult;
import com.adyen.v13.model.recurring.RecurringDetailsRequest;
import com.adyen.v13.model.recurring.RecurringDetailsResult;
import com.adyen.v13.model.recurring.StoreTokenRequest;
import com.adyen.v13.model.recurring.StoreTokenResult;
import com.adyen.v13.model.recurring.ScheduleAccountUpdaterRequest;
import com.adyen.v13.model.recurring.ScheduleAccountUpdaterResult;
import com.adyen.v13.service.exception.ApiException;
import com.adyen.v13.service.resource.recurring.Disable;
import com.adyen.v13.service.resource.recurring.ListRecurringDetails;
import com.adyen.v13.service.resource.recurring.ScheduleAccountUpdater;
import com.adyen.v13.service.resource.recurring.StoreToken;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;

public class Recurring extends Service {
    private ListRecurringDetails listRecurringDetails;
    private Disable disable;
    private StoreToken storeToken;
    private ScheduleAccountUpdater scheduleAccountUpdater;

    public Recurring(Client client) {
        super(client);

        listRecurringDetails = new ListRecurringDetails(this);
        disable = new Disable(this);
        storeToken = new StoreToken(this);
        scheduleAccountUpdater = new ScheduleAccountUpdater(this);
    }

    /**
     * Issues a listRecurringDetails API call
     *
     * @param request RecurringDetailsResult
     * @return recurring details result
     * @throws IOException  IOException
     * @throws ApiException ApiException
     */
    public RecurringDetailsResult listRecurringDetails(RecurringDetailsRequest request) throws IOException, ApiException {
        String jsonRequest = GSON.toJson(request);
        String jsonResult = listRecurringDetails.request(jsonRequest);
        return GSON.fromJson(jsonResult, new TypeToken<RecurringDetailsResult>() {
        }.getType());
    }

    /**
     * Issues a disable recurring contract API call
     *
     * @param request DisableRequest
     * @return DisableResult
     * @throws IOException IOException
     * @throws ApiException ApiException
     */
    public DisableResult disable(DisableRequest request) throws IOException, ApiException {
        String jsonRequest = GSON.toJson(request);
        String jsonResult = disable.request(jsonRequest);
        return GSON.fromJson(jsonResult, new TypeToken<DisableResult>() {
        }.getType());
    }

    /**
     * Issues a storeToken API call
     *
     * @param request StoreTokenRequest
     * @return StoreTokenResult
     * @throws IOException IOException
     * @throws ApiException ApiException
     */
    public StoreTokenResult storeToken(StoreTokenRequest request) throws IOException, ApiException {
        String jsonRequest = GSON.toJson(request);
        String jsonResult = storeToken.request(jsonRequest);
        return GSON.fromJson(jsonResult, new TypeToken<StoreTokenResult>() {
        }.getType());
    }

    /**
     * Issues a scheduleAccountUpdate API call
     *
     * @param request ScheduleAccountUpdaterRequest
     * @return ScheduleAccountUpdaterResult
     * @throws IOException IOException
     * @throws ApiException ApiException
     */
    public ScheduleAccountUpdaterResult scheduleAccountUpdater(ScheduleAccountUpdaterRequest request) throws IOException, ApiException {
        String jsonRequest = GSON.toJson(request);
        String jsonResult = scheduleAccountUpdater.request(jsonRequest);
        return GSON.fromJson(jsonResult, new TypeToken<ScheduleAccountUpdaterResult>() {
        }.getType());
    }

}
