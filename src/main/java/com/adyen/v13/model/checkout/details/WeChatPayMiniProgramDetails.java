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

package com.adyen.v13.model.checkout.details;

import com.adyen.v13.model.checkout.PaymentMethodDetails;
import com.google.gson.annotations.SerializedName;

import java.util.Objects;

import static com.adyen.v13.util.Util.toIndentedString;

/**
 * WeChatPayMiniProgramDetails
 */

public class WeChatPayMiniProgramDetails implements PaymentMethodDetails {
    /**
     * Possible types
     */
    public static final String WECHATPAYMINIPROGRAM = "wechatpayMiniProgram";

    @SerializedName("appId")
    private String appId = null;

    @SerializedName("openid")
    private String openid = null;

    @SerializedName("type")
    private String type = WECHATPAYMINIPROGRAM;

    public WeChatPayMiniProgramDetails appId(String appId) {
        this.appId = appId;
        return this;
    }

    /**
     * Get appId
     *
     * @return appId
     **/
    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public WeChatPayMiniProgramDetails openid(String openid) {
        this.openid = openid;
        return this;
    }

    /**
     * Get openid
     *
     * @return openid
     **/
    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public WeChatPayMiniProgramDetails type(String type) {
        this.type = type;
        return this;
    }

    /**
     * The payment method type.
     *
     * @return type
     **/
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        WeChatPayMiniProgramDetails weChatPayMiniProgramDetails = (WeChatPayMiniProgramDetails) o;
        return Objects.equals(this.appId, weChatPayMiniProgramDetails.appId) &&
                Objects.equals(this.openid, weChatPayMiniProgramDetails.openid) &&
                Objects.equals(this.type, weChatPayMiniProgramDetails.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(appId, openid, type);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class WeChatPayMiniProgramDetails {\n");

        sb.append("    appId: ").append(toIndentedString(appId)).append("\n");
        sb.append("    openid: ").append(toIndentedString(openid)).append("\n");
        sb.append("    type: ").append(toIndentedString(type)).append("\n");
        sb.append("}");
        return sb.toString();
    }
}
