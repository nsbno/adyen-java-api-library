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
package com.adyen.v13.model.binlookup;

import com.adyen.v13.model.Amount;
import com.google.gson.annotations.SerializedName;

import java.util.Objects;


import static com.adyen.v13.util.Util.toIndentedString;

/**
 * CostEstimateResponse
 */

public class CostEstimateResponse {

    @SerializedName("cardBin")
    private CardBin cardBin = null;

    @SerializedName("costEstimateAmount")
    private Amount costEstimateAmount = null;

    @SerializedName("resultCode")
    private String resultCode = null;

    @SerializedName("surchargeType")
    private String surchargeType = null;

    public CostEstimateResponse cardBin(CardBin cardBin) {
        this.cardBin = cardBin;
        return this;
    }


    /**
     * Get cardBin
     *
     * @return cardBin
     **/
    public CardBin getCardBin() {
        return cardBin;
    }

    public void setCardBin(CardBin cardBin) {
        this.cardBin = cardBin;
    }

    public CostEstimateResponse costEstimateAmount(Amount costEstimateAmount) {
        this.costEstimateAmount = costEstimateAmount;
        return this;
    }


    /**
     * Get costEstimateAmount
     *
     * @return costEstimateAmount
     **/
    public Amount getCostEstimateAmount() {
        return costEstimateAmount;
    }

    public void setCostEstimateAmount(Amount costEstimateAmount) {
        this.costEstimateAmount = costEstimateAmount;
    }

    public CostEstimateResponse resultCode(String resultCode) {
        this.resultCode = resultCode;
        return this;
    }


    /**
     * The result of the cost estimation.
     *
     * @return resultCode
     **/
    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public CostEstimateResponse surchargeType(String surchargeType) {
        this.surchargeType = surchargeType;
        return this;
    }


    /**
     * Indicates the way the charges can be passed on to the cardholder. The following values are possible: * &#x60;ZERO&#x60; - the charges are not allowed to pass on * &#x60;PASSTHROUGH&#x60; - the
     * charges can be passed on * &#x60;UNLIMITED&#x60; - there is no limit on how much surcharge is passed on
     *
     * @return surchargeType
     **/
    public String getSurchargeType() {
        return surchargeType;
    }

    public void setSurchargeType(String surchargeType) {
        this.surchargeType = surchargeType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CostEstimateResponse costEstimateResponse = (CostEstimateResponse) o;
        return Objects.equals(this.cardBin, costEstimateResponse.cardBin)
                && Objects.equals(this.costEstimateAmount, costEstimateResponse.costEstimateAmount)
                && Objects.equals(this.resultCode,
                                  costEstimateResponse.resultCode)
                && Objects.equals(this.surchargeType, costEstimateResponse.surchargeType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cardBin, costEstimateAmount, resultCode, surchargeType);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class CostEstimateResponse {\n");

        sb.append("    cardBin: ").append(toIndentedString(cardBin)).append("\n");
        sb.append("    costEstimateAmount: ").append(toIndentedString(costEstimateAmount)).append("\n");
        sb.append("    resultCode: ").append(toIndentedString(resultCode)).append("\n");
        sb.append("    surchargeType: ").append(toIndentedString(surchargeType)).append("\n");
        sb.append("}");
        return sb.toString();
    }



}
