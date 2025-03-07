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
 * Copyright (c) 2019 Adyen B.V.
 * This file is open source and available under the MIT license.
 * See the LICENSE file for more info.
 */

package com.adyen.v13.model.payout;

import com.adyen.v13.model.Address;
import com.adyen.v13.model.Card;
import com.adyen.v13.model.Name;
import com.google.gson.annotations.SerializedName;

import java.util.Map;
import java.util.Objects;


import static com.adyen.v13.util.Util.toIndentedString;

/**
 * FundSource
 */

public class FundSource {
    @SerializedName("additionalData")
    private Map<String, String> additionalData = null;

    @SerializedName("billingAddress")
    private Address billingAddress = null;

    @SerializedName("card")
    private Card card = null;

    @SerializedName("shopperEmail")
    private String shopperEmail = null;

    @SerializedName("shopperName")
    private Name shopperName = null;

    @SerializedName("telephoneNumber")
    private String telephoneNumber = null;

    public FundSource additionalData(Map<String, String> additionalData) {
        this.additionalData = additionalData;
        return this;
    }

    /**
     * a map of name/value pairs for passing in additional/industry-specific data
     *
     * @return additionalData
     **/
    public Object getAdditionalData() {
        return additionalData;
    }

    public void setAdditionalData(Map<String, String> additionalData) {
        this.additionalData = additionalData;
    }

    public FundSource billingAddress(Address billingAddress) {
        this.billingAddress = billingAddress;
        return this;
    }

    /**
     * Get billingAddress
     *
     * @return billingAddress
     **/
    public Address getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(Address billingAddress) {
        this.billingAddress = billingAddress;
    }

    public FundSource card(Card card) {
        this.card = card;
        return this;
    }

    /**
     * Get card
     *
     * @return card
     **/
    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public FundSource shopperEmail(String shopperEmail) {
        this.shopperEmail = shopperEmail;
        return this;
    }

    /**
     * the email address of the person
     *
     * @return shopperEmail
     **/
    public String getShopperEmail() {
        return shopperEmail;
    }

    public void setShopperEmail(String shopperEmail) {
        this.shopperEmail = shopperEmail;
    }

    public FundSource shopperName(Name shopperName) {
        this.shopperName = shopperName;
        return this;
    }

    /**
     * Get shopperName
     *
     * @return shopperName
     **/
    public Name getShopperName() {
        return shopperName;
    }

    public void setShopperName(Name shopperName) {
        this.shopperName = shopperName;
    }

    public FundSource telephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
        return this;
    }

    /**
     * the telephone number of the person
     *
     * @return telephoneNumber
     **/
    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        FundSource fundSource = (FundSource) o;
        return Objects.equals(this.additionalData, fundSource.additionalData) &&
                Objects.equals(this.billingAddress, fundSource.billingAddress) &&
                Objects.equals(this.card, fundSource.card) &&
                Objects.equals(this.shopperEmail, fundSource.shopperEmail) &&
                Objects.equals(this.shopperName, fundSource.shopperName) &&
                Objects.equals(this.telephoneNumber, fundSource.telephoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(additionalData, billingAddress, card, shopperEmail, shopperName, telephoneNumber);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class FundSource {\n");

        sb.append("    additionalData: ").append(toIndentedString(additionalData)).append("\n");
        sb.append("    billingAddress: ").append(toIndentedString(billingAddress)).append("\n");
        sb.append("    card: ").append(toIndentedString(card)).append("\n");
        sb.append("    shopperEmail: ").append(toIndentedString(shopperEmail)).append("\n");
        sb.append("    shopperName: ").append(toIndentedString(shopperName)).append("\n");
        sb.append("    telephoneNumber: ").append(toIndentedString(telephoneNumber)).append("\n");
        sb.append("}");
        return sb.toString();
    }



}
