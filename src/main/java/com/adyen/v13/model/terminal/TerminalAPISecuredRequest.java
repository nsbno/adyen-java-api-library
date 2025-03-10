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
package com.adyen.v13.model.terminal;

import com.adyen.v13.model.terminal.security.SaleToPOISecuredMessage;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

import java.util.Objects;

/**
 * Terminal API Secured Request
 */
public class TerminalAPISecuredRequest {
    @SerializedName("SaleToPOIRequest")
    @JsonProperty("SaleToPOIRequest")
    private SaleToPOISecuredMessage saleToPOIRequest;


    /**
     * Gets sale to POI request.
     *
     * @return the sale to POI request
     */
    public SaleToPOISecuredMessage getSaleToPOIRequest() {
        return saleToPOIRequest;
    }

    /**
     * Sets sale to POI request.
     *
     * @param saleToPOIRequest the sale to POI request
     */
    public void setSaleToPOIRequest(SaleToPOISecuredMessage saleToPOIRequest) {
        this.saleToPOIRequest = saleToPOIRequest;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TerminalAPISecuredRequest that = (TerminalAPISecuredRequest) o;
        return saleToPOIRequest.equals(that.saleToPOIRequest);
    }

    @Override
    public int hashCode() {
        return Objects.hash(saleToPOIRequest);
    }

    @Override
    public String toString() {
        return "TerminalAPISecuredRequest{" +
                "saleToPOIRequest=" + saleToPOIRequest +
                '}';
    }
}
