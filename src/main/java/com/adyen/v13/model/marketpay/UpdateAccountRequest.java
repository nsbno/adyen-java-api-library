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

package com.adyen.v13.model.marketpay;

import com.google.gson.annotations.SerializedName;

import java.util.Map;
import java.util.Objects;


import static com.adyen.v13.util.Util.toIndentedString;

/**
 * UpdateAccountRequest
 */
public class UpdateAccountRequest {
    @SerializedName("accountCode")
    private String accountCode = null;

    @SerializedName("description")
    private String description = null;

    @SerializedName("metadata")
    private Map<String, String> metadata = null;

    @SerializedName("payoutSchedule")
    private UpdatePayoutScheduleRequest payoutSchedule = null;

    @SerializedName("bankAccountUUID")
    private String bankAccountUUID = null;

    @SerializedName("payoutMethodCode")
    private String payoutMethodCode = null;

    @SerializedName("payoutSpeed")
    private PayoutSpeedEnum payoutSpeed = null;

    public UpdateAccountRequest accountCode(String accountCode) {
        this.accountCode = accountCode;
        return this;
    }

    /**
     * The code of the account to update.
     *
     * @return accountCode
     **/
    public String getAccountCode() {
        return accountCode;
    }

    public void setAccountCode(String accountCode) {
        this.accountCode = accountCode;
    }

    public UpdateAccountRequest description(String description) {
        this.description = description;
        return this;
    }

    /**
     * A description of the account.
     *
     * @return description
     **/
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public UpdateAccountRequest metadata(Map<String, String> metadata) {
        this.metadata = metadata;
        return this;
    }

    /**
     * A set of key and value pairs for general use by the merchant. The keys do not have specific names and may be used for storing miscellaneous data as desired. &gt; Note that during an update of metadata, the omission of existing key-value pairs will result in the deletion of those key-value pairs.
     *
     * @return metadata
     **/
    public Map<String, String> getMetadata() {
        return metadata;
    }

    public void setMetadata(Map<String, String> metadata) {
        this.metadata = metadata;
    }

    public UpdateAccountRequest payoutSchedule(UpdatePayoutScheduleRequest payoutSchedule) {
        this.payoutSchedule = payoutSchedule;
        return this;
    }

    /**
     * Get payoutSchedule
     *
     * @return payoutSchedule
     **/
    public UpdatePayoutScheduleRequest getPayoutSchedule() {
        return payoutSchedule;
    }

    public void setPayoutSchedule(UpdatePayoutScheduleRequest payoutSchedule) {
        this.payoutSchedule = payoutSchedule;
    }


    public UpdateAccountRequest bankAccountUUID(String bankAccountUUID) {
        this.bankAccountUUID = bankAccountUUID;
        return this;
    }

    public String getBankAccountUUID() {
        return bankAccountUUID;
    }

    public void setBankAccountUUID(String bankAccountUUID) {
        this.bankAccountUUID = bankAccountUUID;
    }

    public UpdateAccountRequest payoutMethodCode(String payoutMethodCode) {
        this.payoutMethodCode = payoutMethodCode;
        return this;
    }

    public String getPayoutMethodCode() {
        return payoutMethodCode;
    }

    public void setPayoutMethodCode(String payoutMethodCode) {
        this.payoutMethodCode = payoutMethodCode;
    }

    public UpdateAccountRequest payoutSpeed(PayoutSpeedEnum payoutSpeed) {
        this.payoutSpeed = payoutSpeed;
        return this;
    }

    public PayoutSpeedEnum getPayoutSpeed() {
        return payoutSpeed;
    }

    public void setPayoutSpeed(PayoutSpeedEnum payoutSpeed) {
        this.payoutSpeed = payoutSpeed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        UpdateAccountRequest updateAccountRequest = (UpdateAccountRequest) o;
        return Objects.equals(this.accountCode, updateAccountRequest.accountCode) &&
                Objects.equals(this.description, updateAccountRequest.description) &&
                Objects.equals(this.metadata, updateAccountRequest.metadata) &&
                Objects.equals(this.payoutSchedule, updateAccountRequest.payoutSchedule) &&
                Objects.equals(this.bankAccountUUID, updateAccountRequest.bankAccountUUID) &&
                Objects.equals(this.payoutMethodCode, updateAccountRequest.payoutMethodCode) &&
                Objects.equals(this.payoutSpeed, updateAccountRequest.payoutSpeed);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountCode, description, metadata, payoutSchedule, bankAccountUUID, payoutMethodCode, payoutSpeed);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class UpdateAccountRequest {\n");

        sb.append("    accountCode: ").append(toIndentedString(accountCode)).append("\n");
        sb.append("    description: ").append(toIndentedString(description)).append("\n");
        sb.append("    metadata: ").append(toIndentedString(metadata)).append("\n");
        sb.append("    payoutSchedule: ").append(toIndentedString(payoutSchedule)).append("\n");
        sb.append("    bankAccountUUID").append(toIndentedString(bankAccountUUID)).append("\n");
        sb.append("    payoutMethodCode").append(toIndentedString(payoutMethodCode)).append("\n");
        sb.append("    payoutSpeed").append(toIndentedString(payoutSpeed)).append("\n");
        sb.append("}");
        return sb.toString();
    }

}
