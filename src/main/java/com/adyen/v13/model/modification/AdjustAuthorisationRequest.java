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
 *
 */

package com.adyen.v13.model.modification;

import com.adyen.v13.model.Amount;
import com.adyen.v13.util.Util;
import com.google.gson.annotations.SerializedName;

import java.util.Objects;


import static com.adyen.v13.util.Util.toIndentedString;

public class AdjustAuthorisationRequest extends AbstractModificationRequest<AdjustAuthorisationRequest> {
    @SerializedName("modificationAmount")
    private Amount modificationAmount = null;

    public AdjustAuthorisationRequest modificationAmount(Amount modificationAmount) {
        this.modificationAmount = modificationAmount;
        return this;
    }

    public Amount getModificationAmount() {
        return modificationAmount;
    }

    public void setModificationAmount(Amount modificationAmount) {
        this.modificationAmount = modificationAmount;
    }

    public AdjustAuthorisationRequest fillAmount(String amount, String currency) {
        Amount amountData = Util.createAmount(amount, currency);

        this.setModificationAmount(amountData);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AdjustAuthorisationRequest adjustAuthorisationRequest = (AdjustAuthorisationRequest) o;
        return super.equals(adjustAuthorisationRequest) &&
                Objects.equals(this.modificationAmount, adjustAuthorisationRequest.modificationAmount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(modificationAmount, super.hashCode());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class AdjustAuthorisationRequest {\n");

        sb.append(super.toString());
        sb.append("    modificationAmount: ").append(toIndentedString(modificationAmount)).append("\n");
        sb.append("}");
        return sb.toString();
    }


}