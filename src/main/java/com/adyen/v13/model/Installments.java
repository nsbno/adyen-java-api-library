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
package com.adyen.v13.model;

import com.google.gson.annotations.SerializedName;

import java.util.Objects;


import static com.adyen.v13.util.Util.toIndentedString;

/**
 * Installments
 */
public class Installments {
    @SerializedName("value")
    private Integer value = null;

    public Installments value(Integer value) {
        this.value = value;
        return this;
    }

    /**
     * the number of installments in which the payment will be divided
     *
     * @return value
     **/
    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Installments installments = (Installments) o;
        return Objects.equals(this.value, installments.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Installments {\n");

        sb.append("    value: ").append(toIndentedString(value)).append("\n");
        sb.append("}");
        return sb.toString();
    }
}

