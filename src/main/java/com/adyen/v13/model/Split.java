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
package com.adyen.v13.model;

import com.fasterxml.jackson.annotation.JsonValue;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.util.Objects;

import static com.adyen.v13.util.Util.toIndentedString;

/**
 * Split
 */

public class Split {
    @SerializedName("account")
    private String account = null;

    @SerializedName("amount")
    private SplitAmount amount = null;

    @SerializedName("description")
    private String description = null;

    @SerializedName("reference")
    private String reference = null;

    /**
     * The type of this split.  &gt;Permitted values: &#x60;Default&#x60;, &#x60;PaymentFee&#x60;, &#x60;VAT&#x60;, &#x60;Commission&#x60;, &#x60;MarketPlace&#x60;, &#x60;BalanceAccount&#x60;.
     */
    @JsonAdapter(TypeEnum.Adapter.class)
    public enum TypeEnum {
        BALANCEACCOUNT("BalanceAccount"),
        COMMISSION("Commission"),
        DEFAULT("Default"),
        MARKETPLACE("MarketPlace"),
        PAYMENTFEE("PaymentFee"),
        VAT("VAT"),
        VERIFICATION("Verification");

        @JsonValue
        private String value;

        TypeEnum(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }

        public static TypeEnum fromValue(String text) {
            for (TypeEnum b : TypeEnum.values()) {
                if (String.valueOf(b.value).equals(text)) {
                    return b;
                }
            }
            return null;
        }

        public static class Adapter extends TypeAdapter<TypeEnum> {
            @Override
            public void write(final JsonWriter jsonWriter, final TypeEnum enumeration) throws IOException {
                jsonWriter.value(enumeration.getValue());
            }

            @Override
            public TypeEnum read(final JsonReader jsonReader) throws IOException {
                String value = jsonReader.nextString();
                return TypeEnum.fromValue(String.valueOf(value));
            }
        }
    }

    @SerializedName("type")
    private TypeEnum type = null;

    public Split account(String account) {
        this.account = account;
        return this;
    }

    /**
     * The account to which this split applies.  &gt;Required if the type is &#x60;MarketPlace&#x60;.
     *
     * @return account
     **/
    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public Split amount(SplitAmount amount) {
        this.amount = amount;
        return this;
    }

    /**
     * Get amount
     *
     * @return amount
     **/
    public SplitAmount getAmount() {
        return amount;
    }

    public void setAmount(SplitAmount amount) {
        this.amount = amount;
    }

    public Split description(String description) {
        this.description = description;
        return this;
    }

    /**
     * A description of this split.
     *
     * @return description
     **/
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Split reference(String reference) {
        this.reference = reference;
        return this;
    }

    /**
     * The reference of this split. Used to link other operations (e.g. captures and refunds) to this split.  &gt;Required if the type is &#x60;MarketPlace&#x60;.
     *
     * @return reference
     **/
    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public Split type(TypeEnum type) {
        this.type = type;
        return this;
    }

    /**
     * The type of this split.  &gt;Permitted values: &#x60;Default&#x60;, &#x60;PaymentFee&#x60;, &#x60;VAT&#x60;, &#x60;Commission&#x60;, &#x60;MarketPlace&#x60;, &#x60;BalanceAccount&#x60;.
     *
     * @return type
     **/
    public TypeEnum getType() {
        return type;
    }

    public void setType(TypeEnum type) {
        this.type = type;
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Split split = (Split) o;
        return Objects.equals(this.account, split.account) &&
                Objects.equals(this.amount, split.amount) &&
                Objects.equals(this.description, split.description) &&
                Objects.equals(this.reference, split.reference) &&
                Objects.equals(this.type, split.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(account, amount, description, reference, type);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Split {\n");

        sb.append("    account: ").append(toIndentedString(account)).append("\n");
        sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
        sb.append("    description: ").append(toIndentedString(description)).append("\n");
        sb.append("    reference: ").append(toIndentedString(reference)).append("\n");
        sb.append("    type: ").append(toIndentedString(type)).append("\n");
        sb.append("}");
        return sb.toString();
    }
}
