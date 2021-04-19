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
import com.adyen.v13.model.marketpay.CheckAccountHolderResponse;
import com.adyen.v13.model.marketpay.CloseAccountHolderRequest;
import com.adyen.v13.model.marketpay.CloseAccountHolderResponse;
import com.adyen.v13.model.marketpay.CloseAccountRequest;
import com.adyen.v13.model.marketpay.CloseAccountResponse;
import com.adyen.v13.model.marketpay.CreateAccountHolderRequest;
import com.adyen.v13.model.marketpay.CreateAccountHolderResponse;
import com.adyen.v13.model.marketpay.CreateAccountRequest;
import com.adyen.v13.model.marketpay.CreateAccountResponse;
import com.adyen.v13.model.marketpay.DeleteBankAccountRequest;
import com.adyen.v13.model.marketpay.DeleteBankAccountResponse;
import com.adyen.v13.model.marketpay.DeletePayoutMethodRequest;
import com.adyen.v13.model.marketpay.DeletePayoutMethodResponse;
import com.adyen.v13.model.marketpay.DeleteShareholderRequest;
import com.adyen.v13.model.marketpay.DeleteShareholderResponse;
import com.adyen.v13.model.marketpay.GetAccountHolderRequest;
import com.adyen.v13.model.marketpay.GetAccountHolderResponse;
import com.adyen.v13.model.marketpay.GetUploadedDocumentsRequest;
import com.adyen.v13.model.marketpay.GetUploadedDocumentsResponse;
import com.adyen.v13.model.marketpay.PerformVerificationRequest;
import com.adyen.v13.model.marketpay.SuspendAccountHolderRequest;
import com.adyen.v13.model.marketpay.SuspendAccountHolderResponse;
import com.adyen.v13.model.marketpay.UnSuspendAccountHolderRequest;
import com.adyen.v13.model.marketpay.UnSuspendAccountHolderResponse;
import com.adyen.v13.model.marketpay.UpdateAccountHolderRequest;
import com.adyen.v13.model.marketpay.UpdateAccountHolderResponse;
import com.adyen.v13.model.marketpay.UpdateAccountHolderStateRequest;
import com.adyen.v13.model.marketpay.UpdateAccountHolderStateResponse;
import com.adyen.v13.model.marketpay.UpdateAccountRequest;
import com.adyen.v13.model.marketpay.UpdateAccountResponse;
import com.adyen.v13.model.marketpay.UploadDocumentRequest;
import com.adyen.v13.model.marketpay.UploadDocumentResponse;
import com.adyen.v13.service.exception.ApiException;
import com.adyen.v13.service.resource.account.CheckAccountHolder;
import com.adyen.v13.service.resource.account.CloseAccount;
import com.adyen.v13.service.resource.account.CloseAccountHolder;
import com.adyen.v13.service.resource.account.CreateAccount;
import com.adyen.v13.service.resource.account.CreateAccountHolder;
import com.adyen.v13.service.resource.account.DeleteBankAccount;
import com.adyen.v13.service.resource.account.DeletePayoutMethod;
import com.adyen.v13.service.resource.account.DeleteShareholder;
import com.adyen.v13.service.resource.account.GetAccountHolder;
import com.adyen.v13.service.resource.account.GetUploadedDocuments;
import com.adyen.v13.service.resource.account.SuspendAccountHolder;
import com.adyen.v13.service.resource.account.UnSuspendAccountHolder;
import com.adyen.v13.service.resource.account.UpdateAccount;
import com.adyen.v13.service.resource.account.UpdateAccountHolder;
import com.adyen.v13.service.resource.account.UpdateAccountHolderState;
import com.adyen.v13.service.resource.account.UploadDocument;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;

public class Account extends Service {

    private CreateAccountHolder createAccountHolder;
    private UpdateAccountHolder updateAccountHolder;
    private GetAccountHolder getAccountHolder;
    private UploadDocument uploadDocument;
    private CreateAccount createAccount;
    private DeleteBankAccount deleteBankAccount;
    private DeleteShareholder deleteShareholder;
    private SuspendAccountHolder suspendAccountHolder;
    private UnSuspendAccountHolder unSuspendAccountHolder;
    private UpdateAccountHolderState updateAccountHolderState;
    private CloseAccount closeAccount;
    private CloseAccountHolder closeAccountHolder;
    private UpdateAccount updateAccount;
    private GetUploadedDocuments getUploadedDocuments;
    private CheckAccountHolder checkAccountHolder;
    private DeletePayoutMethod deletePayoutMethod;

    public Account(Client client) {
        super(client);

        createAccountHolder = new CreateAccountHolder(this);
        updateAccountHolder = new UpdateAccountHolder(this);
        getAccountHolder = new GetAccountHolder(this);
        uploadDocument = new UploadDocument(this);
        createAccount = new CreateAccount(this);
        deleteBankAccount = new DeleteBankAccount(this);
        deleteShareholder = new DeleteShareholder(this);
        suspendAccountHolder = new SuspendAccountHolder(this);
        unSuspendAccountHolder = new UnSuspendAccountHolder(this);
        updateAccountHolderState = new UpdateAccountHolderState(this);
        closeAccount = new CloseAccount(this);
        closeAccountHolder = new CloseAccountHolder(this);
        updateAccount = new UpdateAccount(this);
        getUploadedDocuments = new GetUploadedDocuments(this);
        checkAccountHolder = new CheckAccountHolder(this);
        deletePayoutMethod = new DeletePayoutMethod(this);
    }

    public CreateAccountHolderResponse createAccountHolder(CreateAccountHolderRequest accountHolderRequest) throws ApiException, IOException {
        String jsonRequest = GSON.toJson(accountHolderRequest);

        String jsonResult = createAccountHolder.request(jsonRequest);

        return GSON.fromJson(jsonResult, new TypeToken<CreateAccountHolderResponse>() {
        }.getType());
    }

    public UpdateAccountHolderResponse updateAccountHolder(UpdateAccountHolderRequest updateAccountHolderRequest) throws ApiException, IOException {
        String jsonRequest = GSON.toJson(updateAccountHolderRequest);

        String jsonResult = updateAccountHolder.request(jsonRequest);
        return GSON.fromJson(jsonResult, new TypeToken<UpdateAccountHolderResponse>() {
        }.getType());
    }

    public GetAccountHolderResponse getAccountHolder(GetAccountHolderRequest getAccountHolderRequest) throws ApiException, IOException {
        String jsonRequest = GSON.toJson(getAccountHolderRequest);

        String jsonResult = getAccountHolder.request(jsonRequest);
        return GSON.fromJson(jsonResult, new TypeToken<GetAccountHolderResponse>() {
        }.getType());
    }

    public UploadDocumentResponse uploadDocument(UploadDocumentRequest uploadDocumentRequest) throws ApiException, IOException {
        String jsonRequest = GSON.toJson(uploadDocumentRequest);

        String jsonResult = uploadDocument.request(jsonRequest);
        return GSON.fromJson(jsonResult, new TypeToken<UploadDocumentResponse>() {
        }.getType());
    }

    public CreateAccountResponse createAccount(CreateAccountRequest createAccountRequest) throws ApiException, IOException {
        String jsonRequest = GSON.toJson(createAccountRequest);

        String jsonResult = createAccount.request(jsonRequest);
        return GSON.fromJson(jsonResult, new TypeToken<CreateAccountResponse>() {
        }.getType());
    }

    public DeleteBankAccountResponse deleteBankAccount(DeleteBankAccountRequest deleteBankAccountRequest) throws ApiException, IOException {
        String jsonRequest = GSON.toJson(deleteBankAccountRequest);

        String jsonResult = deleteBankAccount.request(jsonRequest);
        return GSON.fromJson(jsonResult, new TypeToken<DeleteBankAccountResponse>() {
        }.getType());
    }

    public DeleteShareholderResponse deleteShareholder(DeleteShareholderRequest deleteShareholderRequest) throws ApiException, IOException {
        String jsonRequest = GSON.toJson(deleteShareholderRequest);

        String jsonResult = deleteShareholder.request(jsonRequest);
        return GSON.fromJson(jsonResult, new TypeToken<DeleteShareholderResponse>() {
        }.getType());
    }

    public SuspendAccountHolderResponse suspendAccountHolder(SuspendAccountHolderRequest suspendAccountHolderRequest) throws ApiException, IOException {
        String jsonRequest = GSON.toJson(suspendAccountHolderRequest);

        String jsonResult = suspendAccountHolder.request(jsonRequest);
        return GSON.fromJson(jsonResult, new TypeToken<SuspendAccountHolderResponse>() {
        }.getType());
    }

    public UnSuspendAccountHolderResponse unSuspendAccountHolder(UnSuspendAccountHolderRequest unSuspendAccountHolderRequest) throws ApiException, IOException {
        String jsonRequest = GSON.toJson(unSuspendAccountHolderRequest);

        String jsonResult = unSuspendAccountHolder.request(jsonRequest);
        return GSON.fromJson(jsonResult, new TypeToken<UnSuspendAccountHolderResponse>() {
        }.getType());
    }

    public UpdateAccountHolderStateResponse updateAccountHolderState(UpdateAccountHolderStateRequest updateAccountHolderStateRequest) throws ApiException, IOException {
        String jsonRequest = GSON.toJson(updateAccountHolderStateRequest);

        String jsonResult = updateAccountHolderState.request(jsonRequest);
        return GSON.fromJson(jsonResult, new TypeToken<UpdateAccountHolderStateResponse>() {
        }.getType());
    }

    public CloseAccountResponse closeAccount(CloseAccountRequest closeAccountRequest) throws ApiException, IOException {
        String jsonRequest = GSON.toJson(closeAccountRequest);

        String jsonResult = closeAccount.request(jsonRequest);
        return GSON.fromJson(jsonResult, new TypeToken<CloseAccountResponse>() {
        }.getType());
    }

    public CloseAccountHolderResponse closeAccountHolder(CloseAccountHolderRequest closeAccountHolderRequest) throws ApiException, IOException {
        String jsonRequest = GSON.toJson(closeAccountHolderRequest);

        String jsonResult = closeAccountHolder.request(jsonRequest);
        return GSON.fromJson(jsonResult, new TypeToken<CloseAccountHolderResponse>() {
        }.getType());
    }

    public UpdateAccountResponse updateAccount(UpdateAccountRequest updateAccountRequest) throws ApiException, IOException {
        String jsonRequest = GSON.toJson(updateAccountRequest);

        String jsonResult = updateAccount.request(jsonRequest);
        return GSON.fromJson(jsonResult, new TypeToken<UpdateAccountResponse>() {
        }.getType());
    }

    public GetUploadedDocumentsResponse getUploadedDocuments(GetUploadedDocumentsRequest getUploadedDocumentsRequest) throws ApiException, IOException {
        String jsonRequest = GSON.toJson(getUploadedDocumentsRequest);

        String jsonResult = getUploadedDocuments.request(jsonRequest);
        return GSON.fromJson(jsonResult, new TypeToken<GetUploadedDocumentsResponse>() {
        }.getType());
    }

    public CheckAccountHolderResponse checkAccountHolder(PerformVerificationRequest performVerificationRequest) throws ApiException, IOException {
        String jsonRequest = GSON.toJson(performVerificationRequest);

        String jsonResult = checkAccountHolder.request(jsonRequest);
        return GSON.fromJson(jsonResult, new TypeToken<CheckAccountHolderResponse>() {
        }.getType());
    }

    public DeletePayoutMethodResponse deletePayoutMethod(DeletePayoutMethodRequest deletePayoutMethodRequest) throws ApiException, IOException {
        String jsonRequest = GSON.toJson(deletePayoutMethodRequest);

        String jsonResult = deletePayoutMethod.request(jsonRequest);
        return GSON.fromJson(jsonResult, new TypeToken<DeletePayoutMethodResponse>() {
        }.getType());
    }
}