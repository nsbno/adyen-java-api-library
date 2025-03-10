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

package com.adyen.v13.service.resource.recurring;

import java.util.Arrays;

import com.adyen.v13.Client;
import com.adyen.v13.Service;
import com.adyen.v13.service.Resource;

public class StoreToken extends Resource {

    public StoreToken(Service service) {
        super(service, service.getClient().getConfig().getEndpoint() + "/pal/servlet/Recurring/" + Client.RECURRING_API_VERSION + "/storeToken",
                Arrays.asList("merchantAccount", "recurring.contract", "shopperReference"));
    }

}
