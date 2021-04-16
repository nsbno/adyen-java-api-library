package com.adyen.v11.service.resource.notification;

import com.adyen.v11.Client;
import com.adyen.v11.Service;
import com.adyen.v11.service.Resource;

import java.util.Arrays;


public class TestNotificationConfiguration extends Resource {

    public TestNotificationConfiguration(Service service) {
        super(service,
              service.getClient().getConfig().getMarketPayEndpoint() + "/Notification/" + Client.MARKETPAY_NOTIFICATION_API_VERSION + "/testNotificationConfiguration",
              Arrays.asList(
                      "eventTypes",
                      "notificationId"
              )
        );
    }
}
