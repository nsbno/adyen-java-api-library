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
 * Copyright (c) 2017 Adyen B.V.
 * This file is open source and available under the MIT license.
 * See the LICENSE file for more info.
 */
package com.adyen.v11;

import java.io.IOException;
import java.security.SignatureException;
import java.util.List;
import java.util.SortedMap;
import org.junit.Test;
import com.adyen.v11.httpclient.HTTPClientException;
import com.adyen.v11.model.hpp.DirectoryLookupRequest;
import com.adyen.v11.model.hpp.Issuer;
import com.adyen.v11.model.hpp.PaymentMethod;
import com.adyen.v11.service.HostedPaymentPages;
import static com.adyen.v11.constants.BrandCodes.IDEAL;
import static com.adyen.v11.constants.BrandCodes.VISA;
import static com.adyen.v11.constants.HPPConstants.Fields.CURRENCY_CODE;
import static com.adyen.v11.constants.HPPConstants.Fields.MERCHANT_SIG;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

/**
 * Tests notification messages
 */
public class DirectoryLookupTest extends BaseTest {
    private DirectoryLookupRequest createDirectoryLookupRequest() {
        DirectoryLookupRequest directoryLookupRequest = new DirectoryLookupRequest().setCountryCode("NL")
                                                                                    .setMerchantReference("test:\\'test")
                                                                                    .setPaymentAmount("1000")
                                                                                    .setCurrencyCode("EUR")
                                                                                    .setShopperLocale("en_GB");
        return directoryLookupRequest;
    }

    @Test
    public void testGetPostParameters() throws SignatureException {
        Client client = createMockClientFromResponse("");

        HostedPaymentPages hostedPaymentPages = new HostedPaymentPages(client);
        DirectoryLookupRequest directoryLookupRequest = createDirectoryLookupRequest();

        SortedMap<String, String> postParameters = hostedPaymentPages.getPostParametersFromDLRequest(directoryLookupRequest);
        assertEquals("EUR", postParameters.get(CURRENCY_CODE));
        assertEquals(44, postParameters.get(MERCHANT_SIG).length());
    }

    @Test
    public void testGetPaymentMethods() throws HTTPClientException, SignatureException, IOException {
        Client client = createMockClientFromFile("mocks/hpp/directoryLookup-success.json");

        HostedPaymentPages hostedPaymentPages = new HostedPaymentPages(client);
        DirectoryLookupRequest directoryLookupRequest = createDirectoryLookupRequest();

        List<PaymentMethod> paymentMethods = hostedPaymentPages.getPaymentMethods(directoryLookupRequest);

        assertEquals(8, paymentMethods.size());

        PaymentMethod ideal = paymentMethods.get(0);
        assertEquals(IDEAL, ideal.getBrandCode());
        assertEquals("iDEAL", ideal.getName());
        assertFalse(ideal.isCard());

        assertEquals(3, ideal.getIssuers().size());
        Issuer issuer1 = ideal.getIssuers().get(0);

        assertEquals("1121", issuer1.getIssuerId());
        assertEquals("Test Issuer", issuer1.getName());

        PaymentMethod visa = paymentMethods.get(1);
        assertEquals(VISA, visa.getBrandCode());
        assertTrue(visa.isCard());
    }

    @Test
    public void testGetPaymentMethodsError() throws HTTPClientException, SignatureException, IOException {
        Client client = createMockClientFromFile("mocks/hpp/directoryLookup-error.htm");

        HostedPaymentPages hostedPaymentPages = new HostedPaymentPages(client);
        DirectoryLookupRequest directoryLookupRequest = createDirectoryLookupRequest();

        try {
            List<PaymentMethod> paymentMethods = hostedPaymentPages.getPaymentMethods(directoryLookupRequest);
            fail("Expected Exception");
        } catch (HTTPClientException e) {
        }
    }
}
