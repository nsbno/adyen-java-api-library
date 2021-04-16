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
package com.adyen.v11.service;

import com.adyen.v11.Client;
import com.adyen.v11.Service;
import com.adyen.v11.model.marketpay.notification.CreateNotificationConfigurationRequest;
import com.adyen.v11.model.marketpay.notification.CreateNotificationConfigurationResponse;
import com.adyen.v11.model.marketpay.notification.DeleteNotificationConfigurationRequest;
import com.adyen.v11.model.marketpay.notification.DeleteNotificationConfigurationResponse;
import com.adyen.v11.model.marketpay.notification.GetNotificationConfigurationListResponse;
import com.adyen.v11.model.marketpay.notification.GetNotificationConfigurationRequest;
import com.adyen.v11.model.marketpay.notification.GetNotificationConfigurationResponse;
import com.adyen.v11.model.marketpay.notification.TestNotificationConfigurationRequest;
import com.adyen.v11.model.marketpay.notification.TestNotificationConfigurationResponse;
import com.adyen.v11.model.marketpay.notification.UpdateNotificationConfigurationRequest;
import com.adyen.v11.model.marketpay.notification.UpdateNotificationConfigurationResponse;
import com.adyen.v11.service.resource.notification.CreateNotificationConfiguration;
import com.adyen.v11.service.resource.notification.DeleteNotificationConfigurations;
import com.adyen.v11.service.resource.notification.GetNotificationConfiguration;
import com.adyen.v11.service.resource.notification.GetNotificationConfigurationList;
import com.adyen.v11.service.resource.notification.TestNotificationConfiguration;
import com.adyen.v11.service.resource.notification.UpdateNotificationConfiguration;
import com.google.gson.reflect.TypeToken;

public class Notification extends Service {

    private CreateNotificationConfiguration createNotificationConfiguration;
    private UpdateNotificationConfiguration updateNotificationConfiguration;
    private GetNotificationConfiguration getNotificationConfiguration;
    private DeleteNotificationConfigurations deleteNotificationConfiguration;
    private TestNotificationConfiguration testNotificationConfiguration;
    private GetNotificationConfigurationList getNotificationConfigurationList;


    public Notification(Client client) {
        super(client);
        this.createNotificationConfiguration = new CreateNotificationConfiguration(this);
        this.updateNotificationConfiguration = new UpdateNotificationConfiguration(this);
        this.getNotificationConfiguration = new GetNotificationConfiguration(this);
        this.deleteNotificationConfiguration = new DeleteNotificationConfigurations(this);
        this.testNotificationConfiguration = new TestNotificationConfiguration(this);
        this.getNotificationConfigurationList = new GetNotificationConfigurationList(this);
    }

    public CreateNotificationConfigurationResponse createNotificationConfiguration(CreateNotificationConfigurationRequest createNotificationConfigurationRequest) throws Exception {
        String jsonRequest = GSON.toJson(createNotificationConfigurationRequest);
        String jsonResult = createNotificationConfiguration.request(jsonRequest);
        return GSON.fromJson(jsonResult, new TypeToken<CreateNotificationConfigurationResponse>() {
        }.getType());
    }

    public UpdateNotificationConfigurationResponse updateNotificationConfiguration(UpdateNotificationConfigurationRequest updateNotificationConfigurationRequest) throws Exception {
        String jsonRequest = GSON.toJson(updateNotificationConfigurationRequest);
        String jsonResult = updateNotificationConfiguration.request(jsonRequest);
        return GSON.fromJson(jsonResult, new TypeToken<UpdateNotificationConfigurationResponse>() {
        }.getType());
    }

    public GetNotificationConfigurationResponse getNotificationConfiguration(GetNotificationConfigurationRequest getNotificationConfigurationRequest) throws Exception {
        String jsonRequest = GSON.toJson(getNotificationConfigurationRequest);
        String jsonResult = getNotificationConfiguration.request(jsonRequest);
        return GSON.fromJson(jsonResult, new TypeToken<GetNotificationConfigurationResponse>() {
        }.getType());
    }

    public DeleteNotificationConfigurationResponse deleteNotificationConfiguration(DeleteNotificationConfigurationRequest deleteNotificationConfigurationRequest) throws Exception {
        String jsonRequest = GSON.toJson(deleteNotificationConfigurationRequest);
        String jsonResult = deleteNotificationConfiguration.request(jsonRequest);
        return GSON.fromJson(jsonResult, new TypeToken<DeleteNotificationConfigurationResponse>() {
        }.getType());
    }

    public TestNotificationConfigurationResponse testNotificationConfiguration(TestNotificationConfigurationRequest testNotificationConfigurationRequest) throws Exception {
        String jsonRequest = GSON.toJson(testNotificationConfigurationRequest);
        String jsonResult = testNotificationConfiguration.request(jsonRequest);

        return GSON.fromJson(jsonResult, new TypeToken<TestNotificationConfigurationResponse>() {
        }.getType());
    }

    public GetNotificationConfigurationListResponse getNotificationConfigurationList() throws Exception {
        String jsonResult = getNotificationConfigurationList.request("{}");
        return GSON.fromJson(jsonResult, new TypeToken<GetNotificationConfigurationListResponse>() {
        }.getType());
    }


}