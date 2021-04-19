package com.adyen.v13.service.resource.notification;

import com.adyen.v13.Client;
import com.adyen.v13.Service;
import com.adyen.v13.service.Resource;

import java.util.Collections;

public class CreateNotificationConfiguration extends Resource {

    public CreateNotificationConfiguration(Service service) {
        super(service,
              service.getClient().getConfig().getMarketPayEndpoint() + "/Notification/" + Client.MARKETPAY_NOTIFICATION_API_VERSION + "/createNotificationConfiguration",
                Collections.singletonList("configurationDetails")
        );
    }
}
