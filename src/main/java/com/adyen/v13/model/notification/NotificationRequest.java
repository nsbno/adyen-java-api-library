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
package com.adyen.v13.model.notification;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.stream.Collectors;


import static com.adyen.v13.util.Util.toIndentedString;

/**
 * NotificationRequest model class
 */
public class NotificationRequest {
    @SerializedName("live")
    private String live = null;

    @SerializedName("notificationItems")
    @JsonProperty("notificationItems")
    private List<NotificationRequestItemContainer> notificationItemContainers = null;

    public String getLive() {
        return live;
    }

    public NotificationRequest setLive(String live) {
        this.live = live;
        return this;
    }

    public List<NotificationRequestItemContainer> getNotificationItemContainers() {
        return notificationItemContainers;
    }

    public void setNotificationItemContainers(List<NotificationRequestItemContainer> notificationItemContainers) {
        this.notificationItemContainers = notificationItemContainers;
    }

    @JsonIgnore
    public List<NotificationRequestItem> getNotificationItems() {
        if (this.notificationItemContainers == null) {
            return null;
        }
        return notificationItemContainers.stream().map(s -> s.getNotificationItem()).collect(Collectors.toList());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class NotificationRequestItem {\n");

        sb.append("    live: ").append(toIndentedString(live)).append("\n");
        sb.append("    notificationItems: ").append(toIndentedString(notificationItemContainers)).append("\n");
        sb.append("}");
        return sb.toString();
    }
}
