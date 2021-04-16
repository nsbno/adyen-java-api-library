package com.adyen.v11.service.resource.binlookup;

import java.util.Arrays;
import com.adyen.v11.Client;
import com.adyen.v11.Service;
import com.adyen.v11.service.Resource;

public class Get3dsAvailability extends Resource {

    public Get3dsAvailability(Service service) {
        super(service,
                service.getClient().getConfig().getEndpoint() + Client.BIN_LOOKUP_PAL_SUFFIX + Client.BIN_LOOKUP_API_VERSION + "/get3dsAvailability",
              Arrays.asList("merchantAccount", "cardNumber"));
    }
}
