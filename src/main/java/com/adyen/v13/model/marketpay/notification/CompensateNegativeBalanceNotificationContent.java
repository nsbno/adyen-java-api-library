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
 * Copyright (c) 2021 Adyen B.V.
 * This file is open source and available under the MIT license.
 * See the LICENSE file for more info.
 */

package com.adyen.v13.model.marketpay.notification;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.google.gson.annotations.SerializedName;

import static com.adyen.v13.util.Util.toIndentedString;

public class CompensateNegativeBalanceNotificationContent {
    @SerializedName("records")
    private List<CompensateNegativeBalanceNotificationRecord> records = new ArrayList<CompensateNegativeBalanceNotificationRecord>();

    public CompensateNegativeBalanceNotificationContent records(List<CompensateNegativeBalanceNotificationRecord> records) {
        this.records = records;
        return this;
    }

    public CompensateNegativeBalanceNotificationContent addRecordsItem(CompensateNegativeBalanceNotificationRecord recordsItem) {
        this.records.add(recordsItem);
        return this;
    }

    /**
     * A list of the negative balances compensated.
     *
     * @return records
     **/
    public List<CompensateNegativeBalanceNotificationRecord> getRecords() {
        return records;
    }

    public void setRecords(List<CompensateNegativeBalanceNotificationRecord> records) {
        this.records = records;
    }


    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CompensateNegativeBalanceNotificationContent compensateNegativeBalanceNotificationContent = (CompensateNegativeBalanceNotificationContent) o;
        return Objects.equals(this.records, compensateNegativeBalanceNotificationContent.records);
    }

    @Override
    public int hashCode() {
        return Objects.hash(records);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class CompensateNegativeBalanceNotificationContent {\n");

        sb.append("    records: ").append(toIndentedString(records)).append("\n");
        sb.append("}");
        return sb.toString();
    }

}
