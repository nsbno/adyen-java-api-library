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

import com.adyen.v13.ApiKeyAuthenticatedService;
import com.adyen.v13.Client;
import com.adyen.v13.model.RequestOptions;

import com.adyen.v13.model.checkout.CheckoutCancelOrderRequest;
import com.adyen.v13.model.checkout.CheckoutCancelOrderResponse;
import com.adyen.v13.model.checkout.CheckoutCreateOrderRequest;
import com.adyen.v13.model.checkout.CheckoutCreateOrderResponse;
import com.adyen.v13.model.checkout.CreatePaymentLinkRequest;
import com.adyen.v13.model.checkout.CreatePaymentLinkResponse;
import com.adyen.v13.model.checkout.CreateStoredPaymentMethodRequest;
import com.adyen.v13.model.checkout.PaymentMethodsRequest;
import com.adyen.v13.model.checkout.PaymentMethodsResponse;
import com.adyen.v13.model.checkout.PaymentResultRequest;
import com.adyen.v13.model.checkout.PaymentResultResponse;
import com.adyen.v13.model.checkout.PaymentSessionRequest;
import com.adyen.v13.model.checkout.PaymentSessionResponse;
import com.adyen.v13.model.checkout.PaymentsDetailsRequest;
import com.adyen.v13.model.checkout.PaymentsDetailsResponse;
import com.adyen.v13.model.checkout.PaymentsRequest;
import com.adyen.v13.model.checkout.PaymentsResponse;
import com.adyen.v13.model.checkout.StoredPaymentMethodResource;
import com.adyen.v13.service.exception.ApiException;
import com.adyen.v13.service.resource.checkout.PaymentLinks;
import com.adyen.v13.service.resource.checkout.PaymentMethods;
import com.adyen.v13.service.resource.checkout.PaymentSession;
import com.adyen.v13.service.resource.checkout.Payments;
import com.adyen.v13.service.resource.checkout.PaymentsDetails;
import com.adyen.v13.service.resource.checkout.PaymentsResult;
import com.adyen.v13.service.resource.checkout.Orders;
import com.adyen.v13.service.resource.checkout.OrdersCancel;
import com.adyen.v13.service.resource.checkout.StoredPaymentsMethods;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;

public class Checkout extends ApiKeyAuthenticatedService {

    private Payments payments;
    private PaymentMethods paymentMethods;
    private PaymentsDetails paymentsDetails;
    private PaymentSession paymentSession;
    private PaymentsResult paymentsResult;
    private PaymentLinks paymentLinks;
    private Orders orders;
    private OrdersCancel ordersCancel;
    private StoredPaymentsMethods storedPaymentsMethods;

    public Checkout(Client client) {

        super(client);
        payments = new Payments(this);
        paymentMethods = new PaymentMethods(this);
        paymentsDetails = new PaymentsDetails(this);
        paymentSession = new PaymentSession(this);
        paymentsResult = new PaymentsResult(this);
        paymentLinks = new PaymentLinks(this);
        orders = new Orders(this);
        ordersCancel = new OrdersCancel(this);
        storedPaymentsMethods = new StoredPaymentsMethods(this);

    }

    /**
     * POST /payments API call
     *
     * @param paymentsRequest PaymentsRequest
     * @return paymentsResponse
     * @throws IOException  IOException
     * @throws ApiException ApiException
     */
    public PaymentsResponse payments(PaymentsRequest paymentsRequest) throws ApiException, IOException {
        return payments(paymentsRequest, null);
    }


    public PaymentsResponse payments(PaymentsRequest paymentsRequest, RequestOptions requestOptions) throws ApiException, IOException {
        String jsonRequest = GSON.toJson(paymentsRequest);
        String jsonResult = payments.request(jsonRequest, requestOptions);
        return GSON.fromJson(jsonResult, new TypeToken<PaymentsResponse>() {
        }.getType());
    }

    /**
     * POST /paymentMethods API call
     *
     * @param paymentMethodsRequest PaymentMethodsRequest
     * @return paymentMethodsResponse PaymentMethodsResponse
     * @throws IOException  IOException
     * @throws ApiException ApiException
     */

    public PaymentMethodsResponse paymentMethods(PaymentMethodsRequest paymentMethodsRequest) throws ApiException, IOException {
        String jsonRequest = GSON.toJson(paymentMethodsRequest);
        String jsonResult = paymentMethods.request(jsonRequest);
        return GSON.fromJson(jsonResult, new TypeToken<PaymentMethodsResponse>() {
        }.getType());

    }

    /**
     * POST payments/details API call
     *
     * @param paymentsDetailsRequest paymentsDetailsRequest
     * @return paymentsResponse paymentsResponse
     * @throws IOException  IOException
     * @throws ApiException ApiException
     */
    public PaymentsDetailsResponse paymentsDetails(PaymentsDetailsRequest paymentsDetailsRequest) throws ApiException, IOException {
        return paymentsDetails(paymentsDetailsRequest, null);
    }

    public PaymentsDetailsResponse paymentsDetails(PaymentsDetailsRequest paymentsDetailsRequest, RequestOptions requestOptions) throws ApiException, IOException {
        String jsonRequest = GSON.toJson(paymentsDetailsRequest);
        String jsonResult = paymentsDetails.request(jsonRequest, requestOptions);
        return GSON.fromJson(jsonResult, new TypeToken<PaymentsDetailsResponse>() {
        }.getType());
    }

    /**
     * POST /paymentSession API call
     *
     * @param paymentSessionRequest paymentSessionRequest
     * @return paymentSessionResponse
     * @throws IOException  IOException
     * @throws ApiException ApiException
     */

    public PaymentSessionResponse paymentSession(PaymentSessionRequest paymentSessionRequest) throws ApiException, IOException {
        return paymentSession(paymentSessionRequest, null);
    }

    public PaymentSessionResponse paymentSession(PaymentSessionRequest paymentSessionRequest, RequestOptions requestOptions) throws ApiException, IOException {
        String jsonRequest = GSON.toJson(paymentSessionRequest);
        String jsonResult = paymentSession.request(jsonRequest, requestOptions);
        return GSON.fromJson(jsonResult, new TypeToken<PaymentSessionResponse>() {
        }.getType());
    }

    /**
     * POST payments/result API call
     *
     * @param paymentResultRequest paymentResultRequest
     * @return paymentResultResponse
     * @throws IOException  IOException
     * @throws ApiException ApiException
     */
    public PaymentResultResponse paymentResult(PaymentResultRequest paymentResultRequest) throws ApiException, IOException {
        String jsonRequest = GSON.toJson(paymentResultRequest);
        String jsonResult = paymentsResult.request(jsonRequest);
        return GSON.fromJson(jsonResult, new TypeToken<PaymentResultResponse>() {
        }.getType());
    }

    /**
     * POST /paymentLinks API call
     *
     * @param createPaymentLinkRequest CreatePaymentLinkRequest
     * @return createPaymentLinkResponse
     * @throws IOException  IOException
     * @throws ApiException ApiException
     */
    public CreatePaymentLinkResponse paymentLinks(CreatePaymentLinkRequest createPaymentLinkRequest) throws ApiException, IOException {
        String jsonRequest = GSON.toJson(createPaymentLinkRequest);
        String jsonResult = paymentLinks.request(jsonRequest);
        return GSON.fromJson(jsonResult, new TypeToken<CreatePaymentLinkResponse>() {
        }.getType());
    }

    /**
     * POST /storedPaymentMethods API call
     *
     * @param createStoredPaymentMethodRequest StoredPaymentMethodsRequest
     * @return storedPaymentMethod
     * @throws IOException  IOException
     * @throws ApiException ApiException
     */
    public StoredPaymentMethodResource storedPaymentMethods(CreateStoredPaymentMethodRequest createStoredPaymentMethodRequest) throws ApiException, IOException {
        String jsonRequest = GSON.toJson(createStoredPaymentMethodRequest);
        String jsonResult = storedPaymentsMethods.request(jsonRequest);
        return GSON.fromJson(jsonResult, new TypeToken<StoredPaymentMethodResource>() {
        }.getType());
    }

    /**
     * POST /orders API call
     *
     * @param checkoutCreateOrderRequest CheckoutCreateOrderRequest
     * @return
     * @throws ApiException
     * @throws IOException
     */
    public CheckoutCreateOrderResponse orders(CheckoutCreateOrderRequest checkoutCreateOrderRequest) throws ApiException, IOException {
        String jsonRequest = GSON.toJson(checkoutCreateOrderRequest);
        String jsonResult = orders.request(jsonRequest);
        return GSON.fromJson(jsonResult, new TypeToken<CheckoutCreateOrderResponse>() {
        }.getType());
    }

    /**
     * POST /orders/cancel API call
     *
     * @param checkoutCancelOrderRequest CheckoutCancelOrderRequest
     * @return
     * @throws ApiException
     * @throws IOException
     */
    public CheckoutCancelOrderResponse ordersCancel(CheckoutCancelOrderRequest checkoutCancelOrderRequest) throws ApiException, IOException {
        String jsonRequest = GSON.toJson(checkoutCancelOrderRequest);
        String jsonResult = ordersCancel.request(jsonRequest);
        return GSON.fromJson(jsonResult, new TypeToken<CheckoutCancelOrderResponse>() {
        }.getType());
    }
}
