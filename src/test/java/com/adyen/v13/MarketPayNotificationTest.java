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
 * Copyright (c) 2020 Adyen B.V.
 * This file is open source and available under the MIT license.
 * See the LICENSE file for more info.
 */
package com.adyen.v13;

import com.adyen.v13.model.marketpay.ErrorFieldType;
import com.adyen.v13.model.marketpay.FieldType;
import com.adyen.v13.model.marketpay.PayoutScheduleResponse;
import com.adyen.v13.model.marketpay.*;
import com.adyen.v13.model.marketpay.notification.*;
import com.adyen.v13.notification.NotificationHandler;
import com.adyen.v13.service.Notification;
import org.junit.Assert;
import org.junit.Test;

import static com.adyen.v13.model.marketpay.CreateAccountResponse.StatusEnum.ACTIVE;
import static com.adyen.v13.model.marketpay.KYCCheckStatusData.CheckStatusEnum.DATA_PROVIDED;
import static com.adyen.v13.model.marketpay.KYCCheckStatusData.CheckTypeEnum.COMPANY_VERIFICATION;
import static com.adyen.v13.model.marketpay.KYCCheckStatusData.CheckTypeEnum.IDENTITY_VERIFICATION;
import static com.adyen.v13.model.marketpay.PayoutScheduleResponse.ScheduleEnum.DAILY;
import static com.adyen.v13.model.marketpay.Transaction.TransactionStatusEnum.PENDINGCREDIT;
import static com.adyen.v13.model.marketpay.notification.NotificationEventConfiguration.EventTypeEnum.ACCOUNT_HOLDER_STATUS_CHANGE;
import static com.adyen.v13.model.marketpay.notification.NotificationEventConfiguration.IncludeModeEnum.INCLUDE;
import static java.time.ZonedDateTime.parse;
import static org.junit.Assert.*;

public class MarketPayNotificationTest extends BaseTest {

    @Test
    public void TestCreateNotificationConfiguration() throws Exception {
        Client client = createMockClientFromFile("mocks/marketpay/notification/create-notification-configuration-success.json");
        Notification notification = new Notification(client);

        CreateNotificationConfigurationRequest createNotificationConfigurationRequest = new CreateNotificationConfigurationRequest();
        CreateNotificationConfigurationResponse getNotificationConfigurationResponse = notification.createNotificationConfiguration(createNotificationConfigurationRequest);

        Assert.assertEquals(getNotificationConfigurationResponse.getConfigurationDetails().getEventConfigs().get(0).getEventType(), ACCOUNT_HOLDER_STATUS_CHANGE);
    }

    @Test
    public void TestGetNotificationConfiguration() throws Exception {
        Client client = createMockClientFromFile("mocks/marketpay/notification/get-notification-configuration-success.json");
        Notification notification = new Notification(client);

        GetNotificationConfigurationRequest getNotificationConfigurationRequest = new GetNotificationConfigurationRequest();
        GetNotificationConfigurationResponse getNotificationConfigurationResponse = notification.getNotificationConfiguration(getNotificationConfigurationRequest);

        Assert.assertEquals(getNotificationConfigurationResponse.getConfigurationDetails().getEventConfigs().get(0).getEventType(), ACCOUNT_HOLDER_STATUS_CHANGE);
        Assert.assertEquals(getNotificationConfigurationResponse.getConfigurationDetails().getEventConfigs().get(0).getIncludeMode(), INCLUDE);
    }

    @Test
    public void TestGetNotificationConfigurationList() throws Exception {
        Client client = createMockClientFromFile("mocks/marketpay/notification/get-notification-configuration-list-success.json");
        Notification notification = new Notification(client);
        GetNotificationConfigurationListResponse getNotificationConfigurationListResponse = notification.getNotificationConfigurationList();

        Assert.assertEquals(getNotificationConfigurationListResponse.getConfigurations().get(0).getNotificationId(), new Long(157));
        Assert.assertEquals(getNotificationConfigurationListResponse.getConfigurations().get(0).getEventConfigs().get(0).getIncludeMode(), INCLUDE);
        Assert.assertEquals(getNotificationConfigurationListResponse.getConfigurations().get(0).getEventConfigs().get(0).getEventType(), ACCOUNT_HOLDER_STATUS_CHANGE);


        Assert.assertEquals(getNotificationConfigurationListResponse.getConfigurations().get(1).getNotificationId(), new Long(161));
        Assert.assertEquals(getNotificationConfigurationListResponse.getConfigurations().get(1).getEventConfigs().get(0).getIncludeMode(), INCLUDE);
        Assert.assertEquals(getNotificationConfigurationListResponse.getConfigurations().get(1).getEventConfigs().get(0).getEventType(), ACCOUNT_HOLDER_STATUS_CHANGE);
    }

    @Test
    public void TestUpdateNotificationConfiguration() throws Exception {
        Client client = createMockClientFromFile("mocks/marketpay/notification/update-notification-configuration-success.json");
        Notification notification = new Notification(client);

        UpdateNotificationConfigurationRequest updateNotificationConfigurationRequest = new UpdateNotificationConfigurationRequest();
        UpdateNotificationConfigurationResponse getNotificationConfigurationResponse = notification.updateNotificationConfiguration(updateNotificationConfigurationRequest);

        Assert.assertEquals(getNotificationConfigurationResponse.getConfigurationDetails().getEventConfigs().get(0).getEventType(), NotificationEventConfiguration.EventTypeEnum.ACCOUNT_CREATED);
        Assert.assertEquals(getNotificationConfigurationResponse.getConfigurationDetails().getEventConfigs().get(0).getIncludeMode(), NotificationEventConfiguration.IncludeModeEnum.INCLUDE);


        Assert.assertEquals(getNotificationConfigurationResponse.getConfigurationDetails().getEventConfigs().get(1).getEventType(),
                            NotificationEventConfiguration.EventTypeEnum.ACCOUNT_HOLDER_CREATED);
        Assert.assertEquals(getNotificationConfigurationResponse.getConfigurationDetails().getEventConfigs().get(1).getIncludeMode(), NotificationEventConfiguration.IncludeModeEnum.EXCLUDE);
    }

    @Test
    public void TestDeleteNotificationConfiguration() throws Exception {
        Client client = createMockClientFromFile("mocks/marketpay/notification/delete-notification-configurations-success.json");
        Notification notification = new Notification(client);

        DeleteNotificationConfigurationRequest deleteNotificationConfigurationRequest = new DeleteNotificationConfigurationRequest();
        DeleteNotificationConfigurationResponse getNotificationConfigurationResponse = notification.deleteNotificationConfiguration(deleteNotificationConfigurationRequest);

        Assert.assertEquals(getNotificationConfigurationResponse.getPspReference(), "8515078085249090");
        Assert.assertEquals(getNotificationConfigurationResponse.getSubmittedAsync(), false);
    }

    @Test
    public void TestNotificationConfiguration() throws Exception {
        Client client = createMockClientFromFile("mocks/marketpay/notification/test-notification-configuration-success.json");
        Notification notification = new Notification(client);

        TestNotificationConfigurationRequest testNotificationConfigurationRequest = new TestNotificationConfigurationRequest();
        TestNotificationConfigurationResponse testNotificationConfigurationResponse = notification.testNotificationConfiguration(testNotificationConfigurationRequest);


        assertEquals("Number", testNotificationConfigurationResponse.getExchangeMessages().get(0).getMessageCode());
        assertEquals("1", testNotificationConfigurationResponse.getExchangeMessages().get(0).getMessageDescription());

        assertEquals("Title", testNotificationConfigurationResponse.getExchangeMessages().get(1).getMessageCode());
        assertEquals("Test 1: Test_ACCOUNT_CREATED", testNotificationConfigurationResponse.getExchangeMessages().get(1).getMessageDescription());
    }

    @Test
    public void testMarketPayAccountCreatedNotification() {
        String json = getFileContents("mocks/marketpay/notification/account-created-success.json");
        NotificationHandler notificationHandler = new NotificationHandler();

        GenericNotification notificationMessage = notificationHandler.handleMarketpayNotificationJson(json);

        assertEquals(GenericNotification.EventTypeEnum.ACCOUNT_CREATED, notificationMessage.getEventType());
        AccountCreateNotification accountCreateNotificationMessage = (AccountCreateNotification) notificationMessage;

        assertEquals("000", accountCreateNotificationMessage.getError().getErrorCode());
        assertEquals("test error message", accountCreateNotificationMessage.getError().getMessage());
        assertNotNull(accountCreateNotificationMessage.getContent());

        final CreateAccountResponse content = accountCreateNotificationMessage.getContent();
        assertEquals("TestAccountHolder", content.getAccountHolderCode());
        assertEquals("AC0000000001", content.getAccountCode());
        assertEquals("account description", content.getDescription());
        assertEquals("MetaValue", content.getMetadata().get("MetaKey"));
        assertEquals(ACTIVE, content.getStatus());
        
        final PayoutScheduleResponse payoutSchedule = content.getPayoutSchedule();
        assertEquals(DAILY, payoutSchedule.getSchedule());
        assertEquals(parse("1970-01-02T01:00:00+01:00").toInstant(), payoutSchedule.getNextScheduledPayout().toInstant());
        
        assertEquals(1, content.getInvalidFields().size());
        final ErrorFieldType errorFieldType = content.getInvalidFields().get(0);
        assertEquals(1, (long) errorFieldType.getErrorCode());
        assertEquals("Field is missing", errorFieldType.getErrorDescription());
        assertEquals("AccountHolderDetails.BusinessDetails.Shareholders.unknown", errorFieldType.getFieldType().getField());
        assertEquals(FieldType.FieldNameEnum.UNKNOWN, errorFieldType.getFieldType().getFieldName());
        assertEquals("SH00001", errorFieldType.getFieldType().getShareholderCode());
    }

    @Test
    public void testMarketPayAccountHolderCreatedNotification() {
        String json = getFileContents("mocks/marketpay/notification/account-holder-created-success.json");
        NotificationHandler notificationHandler = new NotificationHandler();

        GenericNotification notificationMessage = notificationHandler.handleMarketpayNotificationJson(json);

        assertEquals(GenericNotification.EventTypeEnum.ACCOUNT_HOLDER_CREATED, notificationMessage.getEventType());
        AccountHolderCreateNotification accountHolderCreateNotificationMessage = (AccountHolderCreateNotification) notificationMessage;
        assertNotNull(accountHolderCreateNotificationMessage.getContent());
        assertEquals("AHC00000001", accountHolderCreateNotificationMessage.getContent().getAccountHolderCode());
        assertEquals("TSTPSPR0001", accountHolderCreateNotificationMessage.getContent().getPspReference());
        assertEquals("executing-user-key", accountHolderCreateNotificationMessage.getExecutingUserKey());
    }

    @Test
    public void testMarketPayAccountHolderVerificationNotification() {
        String json = getFileContents("mocks/marketpay/notification/account-holder-verification.json");
        NotificationHandler notificationHandler = new NotificationHandler();

        GenericNotification notificationMessage = notificationHandler.handleMarketpayNotificationJson(json);

        assertEquals(GenericNotification.EventTypeEnum.ACCOUNT_HOLDER_VERIFICATION, notificationMessage.getEventType());
        AccountHolderVerificationNotification notification = (AccountHolderVerificationNotification) notificationMessage;
        assertNotNull(notification.getContent());
        assertEquals("AH0000001", notification.getContent().getAccountHolderCode());
    }

    @Test
    public void testMarketPayAccountHolderStatusChangeNotification() {
        String json = getFileContents("mocks/marketpay/notification/account-holder-status-change.json");
        NotificationHandler notificationHandler = new NotificationHandler();

        GenericNotification notificationMessage = notificationHandler.handleMarketpayNotificationJson(json);

        assertEquals(GenericNotification.EventTypeEnum.ACCOUNT_HOLDER_STATUS_CHANGE, notificationMessage.getEventType());
        AccountHolderStatusChangeNotification notification = (AccountHolderStatusChangeNotification) notificationMessage;
        assertNotNull(notification.getContent());

        assertEquals("ah689", notification.getContent().getAccountHolderCode());
        assertNull(notification.getContent().getOldStatus().getProcessingState().getProcessedTo());
        assertEquals("GBP", notification.getContent().getNewStatus().getProcessingState().getProcessedTo().getCurrency());
    }

    @Test
    public void testMarketPayAccountHolderPayoutFailNotification() {
        String json = getFileContents("mocks/marketpay/notification/account-holder-payout-fail.json");
        NotificationHandler notificationHandler = new NotificationHandler();

        GenericNotification notificationMessage = notificationHandler.handleMarketpayNotificationJson(json);

        assertEquals(GenericNotification.EventTypeEnum.ACCOUNT_HOLDER_PAYOUT, notificationMessage.getEventType());
        AccountHolderPayoutNotification notification = (AccountHolderPayoutNotification) notificationMessage;
        assertNotNull(notification.getContent());

        assertEquals("AC00000001", notification.getContent().getAccountCode());
        assertEquals(1, notification.getContent().getAmounts().size());
        assertEquals(10L, notification.getContent().getAmounts().get(0).getValue().longValue());
        assertEquals("10_069", notification.getContent().getStatus().getMessage().getCode());
    }

    @Test
    public void testMarketPayAccountHolderUpdatedNotification() {
        String json = getFileContents("mocks/marketpay/notification/account-holder-updated.json");
        NotificationHandler notificationHandler = new NotificationHandler();

        GenericNotification notificationMessage = notificationHandler.handleMarketpayNotificationJson(json);

        assertEquals(GenericNotification.EventTypeEnum.ACCOUNT_HOLDER_UPDATED, notificationMessage.getEventType());
        AccountHolderUpdateNotification notification = (AccountHolderUpdateNotification) notificationMessage;

        assertNotNull(notification.getContent());

        assertEquals("accountHolderCode", notification.getContent().getAccountHolderCode());
        assertEquals(AccountHolderStatus.StatusEnum.ACTIVE, notification.getContent().getAccountHolderStatus().getStatus());
        assertEquals(COMPANY_VERIFICATION, notification.getContent().getVerificationResult().getAccountHolder().getChecks().get(0).getCheckType());
        assertEquals(DATA_PROVIDED, notification.getContent().getVerificationResult().getAccountHolder().getChecks().get(0).getCheckStatus());
        assertEquals(DATA_PROVIDED, notification.getContent().getVerificationResult().getShareholders().get(0).getChecks().get(0).getCheckStatus());
    }

    @Test
    public void testMarketPayBeneficiarySetupNotification() {
        String json = getFileContents("mocks/marketpay/notification/beneficiary-setup.json");
        NotificationHandler notificationHandler = new NotificationHandler();

        GenericNotification notificationMessage = notificationHandler.handleMarketpayNotificationJson(json);

        assertEquals(GenericNotification.EventTypeEnum.BENEFICIARY_SETUP, notificationMessage.getEventType());
        BeneficiarySetupNotification notification = (BeneficiarySetupNotification) notificationMessage;
        assertNotNull(notification.getContent());

        assertEquals("136058999", notification.getContent().getSourceAccountCode());
        assertEquals("117001608", notification.getContent().getDestinationAccountCode());
    }

    @Test
    public void testMarketPayScheduledRefundsNotification() {
        String json = getFileContents("mocks/marketpay/notification/scheduled-refunds-test.json");
        NotificationHandler notificationHandler = new NotificationHandler();

        GenericNotification notificationMessage = notificationHandler.handleMarketpayNotificationJson(json);

        assertEquals(GenericNotification.EventTypeEnum.SCHEDULED_REFUNDS, notificationMessage.getEventType());
        ScheduledRefundsNotification notification = (ScheduledRefundsNotification) notificationMessage;
        assertNotNull(notification.getContent());

        assertEquals("1234567890", notification.getContent().getAccountCode());
        assertEquals(5000L, notification.getContent().getLastPayout().getAmount().getValue().longValue());
        assertEquals(PENDINGCREDIT, notification.getContent().getRefundResults().get(0).getRefundResult().getOriginalTransaction().getTransactionStatus());
    }

    @Test
    public void testMarketPayCompensateNegativeBalanceNotification() {
        String json = getFileContents("mocks/marketpay/notification/compensate-negative-balance-test.json");
        NotificationHandler notificationHandler = new NotificationHandler();

        GenericNotification notificationMessage = notificationHandler.handleMarketpayNotificationJson(json);

        assertEquals(GenericNotification.EventTypeEnum.COMPENSATE_NEGATIVE_BALANCE, notificationMessage.getEventType());
        CompensateNegativeBalanceNotification notification = (CompensateNegativeBalanceNotification) notificationMessage;
        assertNotNull(notification.getContent());

        assertEquals("AC000001", notification.getContent().getRecords().get(0).getAccountCode());
        assertEquals(10L, notification.getContent().getRecords().get(0).getAmount().getValue().longValue());
    }

    @Test
    public void testMarketPayPaymentFailureNotification() {
        String json = getFileContents("mocks/marketpay/notification/payment-failure-test.json");
        NotificationHandler notificationHandler = new NotificationHandler();

        GenericNotification notificationMessage = notificationHandler.handleMarketpayNotificationJson(json);

        assertEquals(GenericNotification.EventTypeEnum.PAYMENT_FAILURE, notificationMessage.getEventType());
        PaymentFailureNotification notification = (PaymentFailureNotification) notificationMessage;
        assertNotNull(notification.getContent());

        assertEquals(1L, notification.getContent().getErrorFieldList().get(0).getErrorCode().longValue());
        assertEquals("10_062", notification.getContent().getErrorMessage().getCode());
    }

    @Test
    public void testMarketPayReportAvailableNotification() {
        String json = getFileContents("mocks/marketpay/notification/report-available-test.json");
        NotificationHandler notificationHandler = new NotificationHandler();

        GenericNotification notificationMessage = notificationHandler.handleMarketpayNotificationJson(json);

        assertEquals(GenericNotification.EventTypeEnum.REPORT_AVAILABLE, notificationMessage.getEventType());
        ReportAvailableNotification notification = (ReportAvailableNotification) notificationMessage;
        assertNotNull(notification.getContent());

        assertNotNull(notification.getContent().getRemoteAccessUrl());
    }

    @Test
    public void testMarketPayTransferFundsNotification() {
        String json = getFileContents("mocks/marketpay/notification/transfer-funds-test.json");
        NotificationHandler notificationHandler = new NotificationHandler();

        GenericNotification notificationMessage = notificationHandler.handleMarketpayNotificationJson(json);

        assertEquals(GenericNotification.EventTypeEnum.TRANSFER_FUNDS, notificationMessage.getEventType());
        TransferFundsNotification notification = (TransferFundsNotification) notificationMessage;
        assertNotNull(notification.getContent());
        assertEquals(1000L, notification.getContent().getAmount().getValue().longValue());
        assertEquals("testTransferCode", notification.getContent().getTransferCode());

        assertNotNull(notification.getError());
        assertEquals("000", notification.getError().getErrorCode());
        assertEquals("test error message", notification.getError().getMessage());

        assertNotNull(notification.getContent().getInvalidFields());
        assertEquals(1, notification.getContent().getInvalidFields().size());
    }

    @Test
    public void testMarketPayAccountClosedNotification() {
        String json = getFileContents("mocks/marketpay/notification/account-closed-test.json");
        NotificationHandler notificationHandler = new NotificationHandler();

        GenericNotification notificationMessage = notificationHandler.handleMarketpayNotificationJson(json);

        assertEquals(GenericNotification.EventTypeEnum.ACCOUNT_CLOSED, notificationMessage.getEventType());
        AccountCloseNotification notification = (AccountCloseNotification) notificationMessage;
        assertNotNull(notification.getContent());
        assertEquals(1, notification.getContent().getInvalidFields().size());
    }

    @Test
    public void testMarketPayAccountUpdatedNotification() {
        String json = getFileContents("mocks/marketpay/notification/account-updated-test.json");
        NotificationHandler notificationHandler = new NotificationHandler();

        GenericNotification notificationMessage = notificationHandler.handleMarketpayNotificationJson(json);

        assertEquals(GenericNotification.EventTypeEnum.ACCOUNT_UPDATED, notificationMessage.getEventType());
        AccountUpdateNotification notification = (AccountUpdateNotification) notificationMessage;
        assertNotNull(notification.getContent());
        assertEquals(1, notification.getContent().getInvalidFields().size());
    }

    @Test
    public void testMarketPayAccountFundsBelowThreshold() {
        String json = getFileContents("mocks/marketpay/notification/account-funds-below-thresold-test.json");
        NotificationHandler notificationHandler = new NotificationHandler();

        GenericNotification notificationMessage = notificationHandler.handleMarketpayNotificationJson(json);

        assertEquals(GenericNotification.EventTypeEnum.ACCOUNT_FUNDS_BELOW_THRESHOLD, notificationMessage.getEventType());
        AccountFundsBelowThresholdNotification notification = (AccountFundsBelowThresholdNotification) notificationMessage;
        assertNotNull(notification.getContent());
        assertEquals("TestAccountHolder", notification.getContent().getAccountCode());
        assertEquals(Long.valueOf(100), notification.getContent().getFundThreshold().getValue());
        assertEquals(Long.valueOf(96), notification.getContent().getCurrentFunds().getValue());
    }

    @Test
    public void testMarketPayAccountHolderStoreStatusChange() {
        String json = getFileContents("mocks/marketpay/notification/account-holder-store-status-change-test.json");
        NotificationHandler notificationHandler = new NotificationHandler();

        GenericNotification notificationMessage = notificationHandler.handleMarketpayNotificationJson(json);

        assertEquals(GenericNotification.EventTypeEnum.ACCOUNT_HOLDER_STORE_STATUS_CHANGE, notificationMessage.getEventType());
        AccountHolderStoreStatusChangeNotification notification = (AccountHolderStoreStatusChangeNotification) notificationMessage;
        assertNotNull(notification.getContent());
        assertEquals("AH000001", notification.getContent().getAccountHolderCode());
        assertEquals("x00x00x00-xx00-0xx0-x000-00xx00xx000000", notification.getContent().getStore());
    }

    @Test
    public void testMarketPayAccountHolderUpcomingDeadline() {
        String json = getFileContents("mocks/marketpay/notification/account-holder-upcoming-deadline-test.json");
        NotificationHandler notificationHandler = new NotificationHandler();

        GenericNotification notificationMessage = notificationHandler.handleMarketpayNotificationJson(json);

        assertEquals(GenericNotification.EventTypeEnum.ACCOUNT_HOLDER_UPCOMING_DEADLINE, notificationMessage.getEventType());
        AccountHolderUpcomingDeadlineNotification notification = (AccountHolderUpcomingDeadlineNotification) notificationMessage;
        assertNotNull(notification.getContent());
        assertEquals("testD47", notification.getContent().getAccountHolderCode());
        assertEquals(AccountHolderUpcomingDeadlineNotificationContent.EventEnum.INACTIVATEACCOUNT, notification.getContent().getEvent());
    }

    @Test
    public void testMarketPayDirectDebitInitiated() {
        String json = getFileContents("mocks/marketpay/notification/direct-debit-initiated-test.json");
        NotificationHandler notificationHandler = new NotificationHandler();

        GenericNotification notificationMessage = notificationHandler.handleMarketpayNotificationJson(json);

        assertEquals(GenericNotification.EventTypeEnum.DIRECT_DEBIT_INITIATED, notificationMessage.getEventType());
        DirectDebitInitiatedNotification notification = (DirectDebitInitiatedNotification) notificationMessage;
        assertNotNull(notification.getContent());
        assertEquals("100000000", notification.getContent().getAccountCode());
        assertEquals("TestMarketPlaceMerchant", notification.getContent().getMerchantAccountCode());
    }

    @Test
    public void testMarketPayPayoutConfirmed() {
        String json = getFileContents("mocks/marketpay/notification/payout-confirmed-test.json");
        NotificationHandler notificationHandler = new NotificationHandler();

        GenericNotification notificationMessage = notificationHandler.handleMarketpayNotificationJson(json);

        assertEquals(GenericNotification.EventTypeEnum.PAYOUT_CONFIRMED, notificationMessage.getEventType());
        AccountHolderPayoutNotification notification = (AccountHolderPayoutNotification) notificationMessage;
        assertNotNull(notification.getContent());
        assertEquals("100000000", notification.getContent().getAccountCode());
        assertEquals("TestMarketPlaceMerchant", notification.getContent().getMerchantReference());
        assertFalse(notification.getContent().getAmounts().isEmpty());
    }

    @Test
    public void testMarketPayRefundFundsTransfer() {
        String json = getFileContents("mocks/marketpay/notification/refund-funds-transfer-test.json");
        NotificationHandler notificationHandler = new NotificationHandler();

        GenericNotification notificationMessage = notificationHandler.handleMarketpayNotificationJson(json);

        assertEquals(GenericNotification.EventTypeEnum.REFUND_FUNDS_TRANSFER, notificationMessage.getEventType());
        RefundFundsTransferNotification notification = (RefundFundsTransferNotification) notificationMessage;
        assertNotNull(notification.getContent());
        assertEquals("MRef#000001", notification.getContent().getMerchantReference());
        assertEquals("TSTPSPR0000000PT", notification.getContent().getOriginalReference());
        assertFalse(notification.getContent().getInvalidFields().isEmpty());
    }

}
