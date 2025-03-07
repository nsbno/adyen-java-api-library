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

package com.adyen.v13.service.resource.posterminalmanagement;

import com.adyen.v13.Client;
import com.adyen.v13.Service;
import com.adyen.v13.service.Resource;

import java.util.Arrays;

public class FindTerminal extends Resource {

    public FindTerminal(Service service) {
        super(service, service.getClient().getConfig().getPosTerminalManagementApiEndpoint() + "/" + Client.POS_TERMINAL_MANAGEMENT_VERSION + "/findTerminal", Arrays.asList("terminal"));
    }
}
