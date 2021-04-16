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
 * Copyright (c) 2020 Adyen B.V.
 * This file is open source and available under the MIT license.
 * See the LICENSE file for more info.
 */
package com.adyen.v11.service.resource.recurring;

import com.adyen.v11.Client;
import com.adyen.v11.Service;
import com.adyen.v11.service.Resource;

import java.util.Arrays;

public class ScheduleAccountUpdater extends Resource {
    public ScheduleAccountUpdater(Service service) {
        super(service, service.getClient().getConfig().getEndpoint() + "/pal/servlet/Recurring/" + Client.RECURRING_API_VERSION + "/scheduleAccountUpdater",
                Arrays.asList("card", "card.number", "shopperReference", "reference"));
    }
}
