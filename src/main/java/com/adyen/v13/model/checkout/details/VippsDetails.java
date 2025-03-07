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
 * VippsDetails
 */

public class VippsDetails implements PaymentMethodDetails {
    /**
     * Possible types
     */
    public static final String VIPPS = "vipps";

    @SerializedName("storedPaymentMethodId")
    private String storedPaymentMethodId = null;

    @SerializedName("telephoneNumber")
    private String telephoneNumber = null;

    @SerializedName("type")
    private String type = VIPPS;

    public VippsDetails storedPaymentMethodId(String storedPaymentMethodId) {
        this.storedPaymentMethodId = storedPaymentMethodId;
        return this;
    }

    /**
     * This is the &#x60;recurringDetailReference&#x60; returned in the response when you created the token.
     *
     * @return storedPaymentMethodId
     **/
    public String getStoredPaymentMethodId() {
        return storedPaymentMethodId;
    }

    public void setStoredPaymentMethodId(String storedPaymentMethodId) {
        this.storedPaymentMethodId = storedPaymentMethodId;
    }

    public VippsDetails telephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
        return this;
    }

    /**
     * Get telephoneNumber
     *
     * @return telephoneNumber
     **/
    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public VippsDetails type(String type) {
        this.type = type;
        return this;
    }

    /**
     * **vipps**
     *
     * @return type
     **/
    @Override
    public String getType() {
        return type;
    }

    @Override
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
        VippsDetails vippsDetails = (VippsDetails) o;
        return Objects.equals(this.storedPaymentMethodId, vippsDetails.storedPaymentMethodId) &&
                Objects.equals(this.telephoneNumber, vippsDetails.telephoneNumber) &&
                Objects.equals(this.type, vippsDetails.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(storedPaymentMethodId, telephoneNumber, type);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class VippsDetails {\n");

        sb.append("    storedPaymentMethodId: ").append(toIndentedString(storedPaymentMethodId)).append("\n");
        sb.append("    telephoneNumber: ").append(toIndentedString(telephoneNumber)).append("\n");
        sb.append("    type: ").append(toIndentedString(type)).append("\n");
        sb.append("}");
        return sb.toString();
    }

}
