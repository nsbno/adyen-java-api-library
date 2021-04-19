package com.adyen.v13.service.resource.notification;

import com.adyen.v13.Client;
import com.adyen.v13.Service;
import com.adyen.v13.service.Resource;

import java.util.Collections;


public class DeleteNotificationConfigurations extends Resource {

    public DeleteNotificationConfigurations(Service service) {
        super(service,
              service.getClient().getConfig().getMarketPayEndpoint() + "/Notification/" + Client.MARKETPAY_NOTIFICATION_API_VERSION + "/deleteNotificationConfigurations",
                Collections.singletonList("notificationIds")
        );
    }
}
