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
import com.fasterxml.jackson.annotation.JsonValue;
import com.adyen.v13.util.MaskUtil;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;


import static com.adyen.v13.util.Util.toIndentedString;

/**
 * ApplePayDetails
 */

public class ApplePayDetails implements PaymentMethodDetails {
    /**
     * Possible types
     */
    public static final String APPLEPAY = "applepay";

    @SerializedName("applePayToken")
    private String applePayToken = null;

    /**
     * Gets or Sets fundingSource
     */
    @JsonAdapter(FundingSourceEnum.Adapter.class)
    public enum FundingSourceEnum {
        CREDIT("credit"),
        DEBIT("debit");

        @JsonValue
        private String value;

        FundingSourceEnum(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }

        public static FundingSourceEnum fromValue(String text) {
            return Arrays.stream(values()).
                    filter(s -> s.value.equals(text)).
                    findFirst().orElse(null);
        }

        public static class Adapter extends TypeAdapter<FundingSourceEnum> {
            @Override
            public void write(final JsonWriter jsonWriter, final FundingSourceEnum enumeration) throws IOException {
                jsonWriter.value(enumeration.getValue());
            }

            @Override
            public FundingSourceEnum read(final JsonReader jsonReader) throws IOException {
                String value = jsonReader.nextString();
                return FundingSourceEnum.fromValue(String.valueOf(value));
            }
        }
    }

    @SerializedName("fundingSource")
    private FundingSourceEnum fundingSource = null;

    @SerializedName("storedPaymentMethodId")
    private String storedPaymentMethodId = null;

    @SerializedName("type")
    private String type = APPLEPAY;

    public ApplePayDetails applePayToken(String applePayToken) {
        this.applePayToken = applePayToken;
        return this;
    }

    /**
     * Get applePayToken
     *
     * @return applePayToken
     **/
    public String getApplePayToken() {
        return applePayToken;
    }

    public void setApplePayToken(String applePayToken) {
        this.applePayToken = applePayToken;
    }

    public ApplePayDetails fundingSource(FundingSourceEnum fundingSource) {
        this.fundingSource = fundingSource;
        return this;
    }

    /**
     * Get fundingSource
     *
     * @return fundingSource
     **/
    public FundingSourceEnum getFundingSource() {
        return fundingSource;
    }

    public void setFundingSource(FundingSourceEnum fundingSource) {
        this.fundingSource = fundingSource;
    }

    public ApplePayDetails type(String type) {
        this.type = type;
        return this;
    }

    public ApplePayDetails storedPaymentMethodId(String storedPaymentMethodId) {
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

    /**
     * **applepay**
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
        ApplePayDetails applePayDetails = (ApplePayDetails) o;
        return Objects.equals(this.applePayToken, applePayDetails.applePayToken) &&
                Objects.equals(this.fundingSource, applePayDetails.fundingSource) &&
                Objects.equals(this.storedPaymentMethodId, applePayDetails.storedPaymentMethodId) &&
                Objects.equals(this.type, applePayDetails.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(applePayToken, fundingSource, storedPaymentMethodId, type);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ApplePayDetails {\n");

        sb.append("    applePayToken: ").append(toIndentedString(MaskUtil.mask(applePayToken))).append("\n");
        sb.append("    fundingSource: ").append(toIndentedString(fundingSource)).append("\n");
        sb.append("    storedPaymentMethodId: ").append(toIndentedString(storedPaymentMethodId)).append("\n");
        sb.append("    type: ").append(toIndentedString(type)).append("\n");
        sb.append("}");
        return sb.toString();
    }

}
