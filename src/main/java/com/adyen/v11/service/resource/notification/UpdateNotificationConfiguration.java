package com.adyen.v11.service.resource.notification;

import com.adyen.v11.Client;
import com.adyen.v11.Service;
import com.adyen.v11.service.Resource;

import java.util.Collections;

public class UpdateNotificationConfiguration extends Resource {

    public UpdateNotificationConfiguration(Service service) {
        super(service,
              service.getClient().getConfig().getMarketPayEndpoint() + "/Notification/" + Client.MARKETPAY_NOTIFICATION_API_VERSION + "/updateNotificationConfiguration",
                Collections.singletonList("configurationDetails")
        );
    }
}
