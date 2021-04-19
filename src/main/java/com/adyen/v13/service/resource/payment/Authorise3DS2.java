package com.adyen.v13.service.resource.payment;

import com.adyen.v13.Client;
import com.adyen.v13.Service;
import com.adyen.v13.service.Resource;

public class Authorise3DS2 extends Resource {

    public Authorise3DS2(Service service) {
        super(service,
                service.getClient().getConfig().getEndpoint() + "/pal/servlet/Payment/" + Client.API_VERSION + "/authorise3ds2", null);
    }
}