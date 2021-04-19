package com.adyen.v13.service.resource.notification;

import com.adyen.v13.Client;
import com.adyen.v13.Service;
import com.adyen.v13.service.Resource;

import java.util.Collections;

public class GetNotificationConfiguration extends Resource {

    public GetNotificationConfiguration(Service service) {
        super(service,
              service.getClient().getConfig().getMarketPayEndpoint() + "/Notification/" + Client.MARKETPAY_NOTIFICATION_API_VERSION + "/getNotificationConfiguration",
                Collections.singletonList("notificationId")
        );
    }
}
