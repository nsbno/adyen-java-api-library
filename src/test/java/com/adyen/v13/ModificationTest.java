/**
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
package com.adyen.v13;

import com.adyen.v13.model.modification.VoidPendingRefundRequest;
import org.junit.Test;
import com.adyen.v13.model.modification.CancelOrRefundRequest;
import com.adyen.v13.model.modification.CancelRequest;
import com.adyen.v13.model.modification.CaptureRequest;
import com.adyen.v13.model.modification.DonationRequest;
import com.adyen.v13.model.modification.ModificationResult;
import com.adyen.v13.model.modification.RefundRequest;
import com.adyen.v13.service.Modification;
import com.adyen.v13.service.exception.ApiException;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ModificationTest extends BaseTest {
    /**
     * Test happy flow with capture-received response
     *
     * @throws Exception
     */
    @Test
    public void TestCaptureSuccess() throws Exception {
        Client client = createMockClientFromFile("mocks/capture-success.json");
        Modification modification = new Modification(client);

        CaptureRequest captureRequest = createCaptureRequest();

        ModificationResult modificationResult = modification.capture(captureRequest);
        assertEquals(ModificationResult.ModificationResponse.CAPTURE_RECEIVED, modificationResult.getResponse());
        assertEquals("test", modificationResult.getAdditionalData().get("merchantReference"));
    }

    /**
     * Test error response
     *
     * @throws Exception
     */
    @Test
    public void TestCaptureError167() throws Exception {
        Client client = createMockClientForErrors(422, "mocks/capture-error-167.json");
        Modification modification = new Modification(client);

        CaptureRequest captureRequest = createCaptureRequest();

        try {
            ModificationResult modificationResult = modification.capture(captureRequest);
            assertTrue("Exception expected", false);
        } catch (ApiException e) {
            String errorCode = e.getError().getErrorCode();
            assertEquals("167", errorCode);

            int status = e.getError().getStatus();
            assertEquals(422, status);
        }
    }

    /**
     * Test happy flow with cancelOrRefund-received response
     *
     * @throws Exception
     */
    @Test
    public void TestCancelOrRefundReceived() throws Exception {
        Client client = createMockClientFromFile("mocks/cancelOrRefund-received.json");
        Modification modification = new Modification(client);

        CancelOrRefundRequest cancelOrRefundRequest = createBaseModificationRequest(new CancelOrRefundRequest());

        ModificationResult modificationResult = modification.cancelOrRefund(cancelOrRefundRequest);
        assertEquals(ModificationResult.ModificationResponse.CANCELORREFUND_RECEIVED, modificationResult.getResponse());
    }

    /**
     * Test happy flow with refund-received response
     *
     * @throws Exception
     */
    @Test
    public void TestRefundReceived() throws Exception {
        Client client = createMockClientFromFile("mocks/refund-received.json");
        Modification modification = new Modification(client);

        RefundRequest refundRequest = createRefundRequest();

        ModificationResult modificationResult = modification.refund(refundRequest);
        assertEquals(ModificationResult.ModificationResponse.REFUND_RECEIVED, modificationResult.getResponse());
    }

    /**
     * Test happy flow with cancel-received response
     *
     * @throws Exception
     */
    @Test
    public void TestCancelReceived() throws Exception {
        Client client = createMockClientFromFile("mocks/cancel-received.json");
        Modification modification = new Modification(client);

        CancelRequest cancelRequest = createBaseModificationRequest(new CancelRequest());

        ModificationResult modificationResult = modification.cancel(cancelRequest);
        assertEquals(ModificationResult.ModificationResponse.CANCEL_RECEIVED, modificationResult.getResponse());
    }

    /**
     * Test happy flow with voidPendingRefund-received response
     *
     * @throws Exception
     */
    @Test
    public void TestVoidPendingRefundReceived() throws Exception {
        Client client = createMockClientFromFile("mocks/voidPendingRefund-received.json");
        Modification modification = new Modification(client);

        VoidPendingRefundRequest voidPendingRefundRequest = createVoidPendingRefundRequest();

        ModificationResult modificationResult = modification.voidPendingRefund(voidPendingRefundRequest);
        assertEquals(ModificationResult.ModificationResponse.VOIDPENDINGREFUND_RECEIVED, modificationResult.getResponse());
    }

    /**
     * Test happy flow with donation-received response
     *
     * @throws Exception
     */
    @Test
    public void TestDonateSuccess() throws Exception {
        Client client = createMockClientFromFile("mocks/donate-success.json");
        Modification modification = new Modification(client);

        DonationRequest donationRequest = createDonationRequest();

        ModificationResult modificationResult = modification.donate(donationRequest);
        assertEquals(ModificationResult.ModificationResponse.DONATION_RECEIVED, modificationResult.getResponse());
    }
}
