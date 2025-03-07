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
 * MolPayDetails
 */

public class MolPayDetails implements PaymentMethodDetails {
    /**
     * Possible types
     */
    public static final String EBANKING_FPX_MY = "molpay_ebanking_fpx_MY";
    public static final String EBANKING_TH = "molpay_ebanking_TH";
    public static final String EBANKING_VN = "molpay_ebanking_VN";
    public static final String EBANKING_MY = "molpay_ebanking_MY";
    public static final String EBANKING_DIRECT_MY = "molpay_ebanking_direct_MY";
    public static final String FPX = "molpay_fpx";

    @SerializedName("issuer")
    private String issuer = null;

    @SerializedName("type")
    private String type = null;

    public MolPayDetails issuer(String issuer) {
        this.issuer = issuer;
        return this;
    }

    /**
     * Get issuer
     *
     * @return issuer
     **/
    public String getIssuer() {
        return issuer;
    }

    public void setIssuer(String issuer) {
        this.issuer = issuer;
    }

    public MolPayDetails type(String type) {
        this.type = type;
        return this;
    }

    /**
     * Get type
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
        MolPayDetails molPayDetails = (MolPayDetails) o;
        return Objects.equals(this.issuer, molPayDetails.issuer) &&
                Objects.equals(this.type, molPayDetails.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(issuer, type);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class MolPayDetails {\n");

        sb.append("    issuer: ").append(toIndentedString(issuer)).append("\n");
        sb.append("    type: ").append(toIndentedString(type)).append("\n");
        sb.append("}");
        return sb.toString();
    }

}
