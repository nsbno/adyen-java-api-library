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

import java.util.Objects;

import com.adyen.v13.model.checkout.PaymentMethodDetails;
import com.adyen.v13.model.checkout.SubscriptionDetails;
import com.google.gson.annotations.SerializedName;

/**
 * PayUUpiDetails
 */

public class PayUUpiDetails implements PaymentMethodDetails {
    /**
     * Possible types
     */
    public static final String PAYUINUPI = "payu_IN_upi";

    @SerializedName("shopperNotificationReference")
    private String shopperNotificationReference = null;

    @SerializedName("storedPaymentMethodId")
    private String storedPaymentMethodId = null;

    @SerializedName("subscriptionDetails")
    private SubscriptionDetails subscriptionDetails = null;

    @SerializedName("type")
    private String type = PAYUINUPI;

    @SerializedName("virtualPaymentAddress")
    private String virtualPaymentAddress = null;

    public PayUUpiDetails shopperNotificationReference(String shopperNotificationReference) {
        this.shopperNotificationReference = shopperNotificationReference;
        return this;
    }

    /**
     * The &#x60;shopperNotificationReference&#x60; returned in the response when you requested to notify the shopper. Used for recurring payment only.
     *
     * @return shopperNotificationReference
     **/
    public String getShopperNotificationReference() {
        return shopperNotificationReference;
    }

    public void setShopperNotificationReference(String shopperNotificationReference) {
        this.shopperNotificationReference = shopperNotificationReference;
    }

    public PayUUpiDetails storedPaymentMethodId(String storedPaymentMethodId) {
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

    public PayUUpiDetails subscriptionDetails(SubscriptionDetails subscriptionDetails) {
        this.subscriptionDetails = subscriptionDetails;
        return this;
    }

    /**
     * Get subscriptionDetails
     *
     * @return subscriptionDetails
     **/
    public SubscriptionDetails getSubscriptionDetails() {
        return subscriptionDetails;
    }

    public void setSubscriptionDetails(SubscriptionDetails subscriptionDetails) {
        this.subscriptionDetails = subscriptionDetails;
    }

    public PayUUpiDetails type(String type) {
        this.type = type;
        return this;
    }

    /**
     * **payu_IN_upi**
     *
     * @return type
     **/
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public PayUUpiDetails virtualPaymentAddress(String virtualPaymentAddress) {
        this.virtualPaymentAddress = virtualPaymentAddress;
        return this;
    }

    /**
     * The virtual payment address for UPI.
     *
     * @return virtualPaymentAddress
     **/
    public String getVirtualPaymentAddress() {
        return virtualPaymentAddress;
    }

    public void setVirtualPaymentAddress(String virtualPaymentAddress) {
        this.virtualPaymentAddress = virtualPaymentAddress;
    }


    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PayUUpiDetails payUUpiDetails = (PayUUpiDetails) o;
        return Objects.equals(this.shopperNotificationReference, payUUpiDetails.shopperNotificationReference) &&
                Objects.equals(this.storedPaymentMethodId, payUUpiDetails.storedPaymentMethodId) &&
                Objects.equals(this.subscriptionDetails, payUUpiDetails.subscriptionDetails) &&
                Objects.equals(this.type, payUUpiDetails.type) &&
                Objects.equals(this.virtualPaymentAddress, payUUpiDetails.virtualPaymentAddress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(shopperNotificationReference, storedPaymentMethodId, subscriptionDetails, type, virtualPaymentAddress);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class PayUUpiDetails {\n");

        sb.append("    shopperNotificationReference: ").append(toIndentedString(shopperNotificationReference)).append("\n");
        sb.append("    storedPaymentMethodId: ").append(toIndentedString(storedPaymentMethodId)).append("\n");
        sb.append("    subscriptionDetails: ").append(toIndentedString(subscriptionDetails)).append("\n");
        sb.append("    type: ").append(toIndentedString(type)).append("\n");
        sb.append("    virtualPaymentAddress: ").append(toIndentedString(virtualPaymentAddress)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(java.lang.Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }

}
