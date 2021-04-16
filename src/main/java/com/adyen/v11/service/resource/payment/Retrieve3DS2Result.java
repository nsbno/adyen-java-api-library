package com.adyen.v11.service.resource.payment;

import com.adyen.v11.Client;
import com.adyen.v11.Service;
import com.adyen.v11.service.Resource;

public class Retrieve3DS2Result extends Resource {

    public Retrieve3DS2Result(Service service) {
        super(service,
                service.getClient().getConfig().getEndpoint() + "/pal/servlet/Payment/" + Client.API_VERSION + "/retrieve3ds2Result", null);
    }
}
