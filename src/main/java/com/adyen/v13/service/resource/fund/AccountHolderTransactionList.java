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
package com.adyen.v13.service.resource.fund;

import com.adyen.v13.Client;
import com.adyen.v13.Service;
import com.adyen.v13.service.Resource;

public class AccountHolderTransactionList extends Resource {

    public AccountHolderTransactionList(Service service) {
        super(service, service.getClient().getConfig().getMarketPayEndpoint() + "/Fund/" + Client.MARKETPAY_FUND_API_VERSION + "/accountHolderTransactionList", null);
    }

}
