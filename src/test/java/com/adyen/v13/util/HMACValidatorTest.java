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
 * Copyright (c) 2019 Adyen B.V.
 * This file is open source and available under the MIT license.
 * See the LICENSE file for more info.
 */

package com.adyen.v13.util;

import com.adyen.v13.model.notification.NotificationRequestItem;
import com.google.gson.Gson;
import org.junit.Test;

import java.security.SignatureException;

import static org.junit.Assert.assertTrue;

public class HMACValidatorTest {

    public static final String HMAC_KEY = "9064450A8892A093D9E97EFCC9639DE31B74F3A7803135555A3C96F5A57915D6";

    @Test
    public void testValidateHMAC() throws SignatureException {
        String notificationJson = "{\n" +
                "    \"additionalData\": {\n" +
                "        \"hmacSignature\": \"NuEkADFmlCC6VgX+wcoPAegIWxVPNBPCuKlM4Hzo5qc=\"\n" +
                "    },\n" +
                "    \"amount\": {\n" +
                "        \"currency\": \"EUR\",\n" +
                "        \"value\": \"0\"\n" +
                "    },\n" +
                "    \"eventCode\": \"REPORT_AVAILABLE\",\n" +
                "    \"eventDate\": \"2019-11-20T14:35:36+01:00\",\n" +
                "    \"merchantAccountCode\": \"Magento2Rik\",\n" +
                "    \"merchantReference\": \"testMerchantRef1\",\n" +
                "    \"pspReference\": \"test_REPORT_AVAILABLE\",\n" +
                "    \"reason\": \"will contain the url to the report\",\n" +
                "    \"success\": \"true\"\n" +
                "}";

        NotificationRequestItem notificationRequest = new Gson().fromJson(notificationJson, NotificationRequestItem.class);
        boolean result = new HMACValidator().validateHMAC(notificationRequest, HMAC_KEY);
        assertTrue(result);
    }
}
