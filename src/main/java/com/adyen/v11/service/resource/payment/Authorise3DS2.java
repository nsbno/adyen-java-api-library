package com.adyen.v11.service.resource.payment;

import com.adyen.v11.Client;
import com.adyen.v11.Service;
import com.adyen.v11.service.Resource;

public class Authorise3DS2 extends Resource {

    public Authorise3DS2(Service service) {
        super(service,
                service.getClient().getConfig().getEndpoint() + "/pal/servlet/Payment/" + Client.API_VERSION + "/authorise3ds2", null);
    }
}