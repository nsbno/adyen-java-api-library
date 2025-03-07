
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

package com.adyen.v13.service;

import com.adyen.v13.Client;
import com.adyen.v13.Service;
import com.adyen.v13.model.marketpay.AccountHolderBalanceRequest;
import com.adyen.v13.model.marketpay.AccountHolderBalanceResponse;
import com.adyen.v13.model.marketpay.AccountHolderTransactionListRequest;
import com.adyen.v13.model.marketpay.AccountHolderTransactionListResponse;
import com.adyen.v13.model.marketpay.PayoutAccountHolderRequest;
import com.adyen.v13.model.marketpay.PayoutAccountHolderResponse;
import com.adyen.v13.model.marketpay.RefundFundsTransferRequest;
import com.adyen.v13.model.marketpay.RefundFundsTransferResponse;
import com.adyen.v13.model.marketpay.RefundNotPaidOutTransfersRequest;
import com.adyen.v13.model.marketpay.RefundNotPaidOutTransfersResponse;
import com.adyen.v13.model.marketpay.SetupBeneficiaryRequest;
import com.adyen.v13.model.marketpay.SetupBeneficiaryResponse;
import com.adyen.v13.model.marketpay.TransferFundsRequest;
import com.adyen.v13.model.marketpay.TransferFundsResponse;
import com.adyen.v13.service.exception.ApiException;
import com.adyen.v13.service.resource.fund.AccountHolderBalance;
import com.adyen.v13.service.resource.fund.AccountHolderTransactionList;
import com.adyen.v13.service.resource.fund.PayoutAccountHolder;
import com.adyen.v13.service.resource.fund.RefundFundsTransfer;
import com.adyen.v13.service.resource.fund.RefundNotPaidOutTransfers;
import com.adyen.v13.service.resource.fund.SetupBeneficiary;
import com.adyen.v13.service.resource.fund.TransferFunds;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;

public class Fund extends Service {

    private AccountHolderBalance accountHolderBalance;
    private TransferFunds transferFunds;
    private PayoutAccountHolder payoutAccountHolder;
    private AccountHolderTransactionList accountHolderTransactionList;
    private RefundNotPaidOutTransfers refundNotPaidOutTransfers;
    private SetupBeneficiary setupBeneficiary;
    private RefundFundsTransfer refundFundsTransfer;

    public Fund(Client client) {
        super(client);
        accountHolderBalance = new AccountHolderBalance(this);
        transferFunds = new TransferFunds(this);
        payoutAccountHolder = new PayoutAccountHolder(this);
        accountHolderTransactionList = new AccountHolderTransactionList(this);
        refundNotPaidOutTransfers = new RefundNotPaidOutTransfers(this);
        setupBeneficiary = new SetupBeneficiary(this);
        refundFundsTransfer = new RefundFundsTransfer(this);
    }

    public AccountHolderBalanceResponse accountHolderBalance(AccountHolderBalanceRequest accountHolderBalanceRequest) throws ApiException, IOException {
        String jsonRequest = GSON.toJson(accountHolderBalanceRequest);

        String jsonResult = accountHolderBalance.request(jsonRequest);

        return GSON.fromJson(jsonResult, new TypeToken<AccountHolderBalanceResponse>() {
        }.getType());
    }

    public TransferFundsResponse transferFunds(TransferFundsRequest transferFundsRequest) throws ApiException, IOException {
        String jsonRequest = GSON.toJson(transferFundsRequest);

        String jsonResult = transferFunds.request(jsonRequest);

        return GSON.fromJson(jsonResult, new TypeToken<TransferFundsResponse>() {
        }.getType());
    }

    public PayoutAccountHolderResponse payoutAccountHolder(PayoutAccountHolderRequest payoutAccountHolderRequest) throws ApiException, IOException {
        String jsonRequest = GSON.toJson(payoutAccountHolderRequest);

        String jsonResult = payoutAccountHolder.request(jsonRequest);

        return GSON.fromJson(jsonResult, new TypeToken<PayoutAccountHolderResponse>() {
        }.getType());
    }

    public AccountHolderTransactionListResponse accountHolderTransactionList(AccountHolderTransactionListRequest accountHolderTransactionListRequest) throws ApiException, IOException {
        String jsonRequest = GSON.toJson(accountHolderTransactionListRequest);

        String jsonResult = accountHolderTransactionList.request(jsonRequest);

        return GSON.fromJson(jsonResult, new TypeToken<AccountHolderTransactionListResponse>() {
        }.getType());
    }

    public RefundNotPaidOutTransfersResponse refundNotPaidOutTransfers(RefundNotPaidOutTransfersRequest refundNotPaidOutTransfersRequest) throws ApiException, IOException {
        String jsonRequest = GSON.toJson(refundNotPaidOutTransfersRequest);

        String jsonResult = refundNotPaidOutTransfers.request(jsonRequest);

        return GSON.fromJson(jsonResult, new TypeToken<RefundNotPaidOutTransfersResponse>() {
        }.getType());
    }

    public SetupBeneficiaryResponse setupBeneficiary(SetupBeneficiaryRequest setupBeneficiaryRequest) throws ApiException, IOException {
        String jsonRequest = GSON.toJson(setupBeneficiaryRequest);

        String jsonResult = setupBeneficiary.request(jsonRequest);

        return GSON.fromJson(jsonResult, new TypeToken<SetupBeneficiaryResponse>() {
        }.getType());
    }

    public RefundFundsTransferResponse refundFundsTransfer(RefundFundsTransferRequest refundFundsTransferRequest) throws ApiException, IOException {
        String jsonRequest = GSON.toJson(refundFundsTransferRequest);

        String jsonResult = refundFundsTransfer.request(jsonRequest);

        return GSON.fromJson(jsonResult, new TypeToken<RefundFundsTransferResponse>() {
        }.getType());
    }
}