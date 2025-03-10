/**
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

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;


import static com.adyen.v13.util.Util.toIndentedString;

/**
 * Container for FraudCheckResult
 */
public class FraudCheckResultContainer {

    @SerializedName("FraudCheckResult")
    @JsonProperty("FraudCheckResult")
    private FraudCheckResult fraudCheckResult;

    public FraudCheckResult getFraudCheckResult() {
        return fraudCheckResult;
    }

    public void setFraudCheckResult(FraudCheckResult fraudCheckResult) {
        this.fraudCheckResult = fraudCheckResult;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class FraudCheckResultContainer {\n");

        sb.append("    fraudCheckResult: ").append(toIndentedString(fraudCheckResult)).append("\n");
        sb.append("}");
        return sb.toString();
    }
}
