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

/*
 * Adyen Payout Service
 * A set of API endpoints that allow you to store payout details, confirm, or decline a payout.  For more information, refer to [Third-party payouts](https://docs.adyen.com/features/third-party-payouts).
 *
 * OpenAPI spec version: 30
 * Contact: support@adyen.com
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */

package com.adyen.v13.model.payout;

import com.adyen.v13.model.Amount;
import com.adyen.v13.model.FraudResult;
import com.fasterxml.jackson.annotation.JsonValue;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.util.Arrays;
import java.util.Map;
import java.util.Objects;


import static com.adyen.v13.util.Util.toIndentedString;
/**
 * PayoutResponse
 */

public class PayoutResponse {
  @SerializedName("additionalData")
  private Map<String, String> additionalData = null;

  @SerializedName("authCode")
  private String authCode = null;

  @SerializedName("dccAmount")
  private Amount dccAmount = null;

  @SerializedName("dccSignature")
  private String dccSignature = null;

  @SerializedName("fraudResult")
  private FraudResult fraudResult = null;

  @SerializedName("issuerUrl")
  private String issuerUrl = null;

  @SerializedName("md")
  private String md = null;

  @SerializedName("paRequest")
  private String paRequest = null;

  @SerializedName("pspReference")
  private String pspReference = null;

  @SerializedName("refusalReason")
  private String refusalReason = null;

  /**
   * The result of the payment. Possible values:  * **Authorised** – Indicates the payment authorisation was successfully completed. This state serves as an indicator to proceed with the delivery of goods and services. This is a final state. * **Refused** – Indicates the payment was refused. The reason is given in the &#x60;refusalReason&#x60; field. This is a final state. * **RedirectShopper** – Indicates the shopper should be redirected to an external web page or app to complete the authorisation. * **Received** – Indicates the payment has successfully been received by Adyen, and will be processed. This is the initial state for all payments. * **Cancelled** – Indicates the payment has been cancelled (either by the shopper or the merchant) before processing was completed. This is a final state. * **Pending** – Indicates that it is not possible to obtain the final status of the payment. This can happen if the systems providing final status information for the payment are unavailable, or if the shopper needs to take further action to complete the payment. For more information on handling a pending payment, refer to [Payments with pending status](https://docs.adyen.com/development-resources/payments-with-pending-status). * **Error** – Indicates an error occurred during processing of the payment. The reason is given in the &#x60;refusalReason&#x60; field. This is a final state.
   */
  @JsonAdapter(ResultCodeEnum.Adapter.class)
  public enum ResultCodeEnum {
    AUTHORISED("Authorised"),
    PARTIALLYAUTHORISED("PartiallyAuthorised"),
    REFUSED("Refused"),
    ERROR("Error"),
    CANCELLED("Cancelled"),
    RECEIVED("Received"),
    REDIRECTSHOPPER("RedirectShopper");

    @JsonValue
    private String value;

    ResultCodeEnum(String value) {
      this.value = value;
    }
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }
    public static ResultCodeEnum fromValue(String text) {
      return Arrays.stream(values()).
              filter(s -> s.value.equals(text)).
              findFirst().orElse(null);
    }
    public static class Adapter extends TypeAdapter<ResultCodeEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final ResultCodeEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public ResultCodeEnum read(final JsonReader jsonReader) throws IOException {
        String value = jsonReader.nextString();
        return ResultCodeEnum.fromValue(String.valueOf(value));
      }
    }
  }  @SerializedName("resultCode")
  private ResultCodeEnum resultCode = null;

  public PayoutResponse additionalData(Map<String, String> additionalData) {
    this.additionalData = additionalData;
    return this;
  }

   /**
   * This field contains additional data, which may be required to return in a particular payment response. To choose data fields to be returned, go to **Customer Area** &gt; **Account** &gt; **API URLs**.
   * @return additionalData
  **/
  public Map<String, String> getAdditionalData() {
    return additionalData;
  }

  public void setAdditionalData(Map<String, String> additionalData) {
    this.additionalData = additionalData;
  }

  public PayoutResponse authCode(String authCode) {
    this.authCode = authCode;
    return this;
  }

   /**
   * Authorisation code: * When the payment is authorised successfully, this field holds the authorisation code for the payment. * When the payment is not authorised, this field is empty.
   * @return authCode
  **/
  public String getAuthCode() {
    return authCode;
  }

  public void setAuthCode(String authCode) {
    this.authCode = authCode;
  }

  public PayoutResponse dccAmount(Amount dccAmount) {
    this.dccAmount = dccAmount;
    return this;
  }

   /**
   * Get dccAmount
   * @return dccAmount
  **/
  public Amount getDccAmount() {
    return dccAmount;
  }

  public void setDccAmount(Amount dccAmount) {
    this.dccAmount = dccAmount;
  }

  public PayoutResponse dccSignature(String dccSignature) {
    this.dccSignature = dccSignature;
    return this;
  }

   /**
   * Cryptographic signature used to verify &#x60;dccQuote&#x60;. &gt; This value only applies if you have implemented Dynamic Currency Conversion. For more information, [contact Support](https://support.adyen.com/hc/en-us/requests/new).
   * @return dccSignature
  **/
  public String getDccSignature() {
    return dccSignature;
  }

  public void setDccSignature(String dccSignature) {
    this.dccSignature = dccSignature;
  }

  public PayoutResponse fraudResult(FraudResult fraudResult) {
    this.fraudResult = fraudResult;
    return this;
  }

   /**
   * Get fraudResult
   * @return fraudResult
  **/
  public FraudResult getFraudResult() {
    return fraudResult;
  }

  public void setFraudResult(FraudResult fraudResult) {
    this.fraudResult = fraudResult;
  }

  public PayoutResponse issuerUrl(String issuerUrl) {
    this.issuerUrl = issuerUrl;
    return this;
  }

   /**
   * The URL to direct the shopper to. &gt; In case of SecurePlus, do not redirect a shopper to this URL.
   * @return issuerUrl
  **/
  public String getIssuerUrl() {
    return issuerUrl;
  }

  public void setIssuerUrl(String issuerUrl) {
    this.issuerUrl = issuerUrl;
  }

  public PayoutResponse md(String md) {
    this.md = md;
    return this;
  }

   /**
   * The payment session.
   * @return md
  **/
  public String getMd() {
    return md;
  }

  public void setMd(String md) {
    this.md = md;
  }

  public PayoutResponse paRequest(String paRequest) {
    this.paRequest = paRequest;
    return this;
  }

   /**
   * The 3D request data for the issuer.  If the value is **CUPSecurePlus-CollectSMSVerificationCode**, collect an SMS code from the shopper and pass it in the &#x60;/authorise3D&#x60; request. For more information, see [3D Secure](https://docs.adyen.com/risk-management/3d-secure).
   * @return paRequest
  **/
  public String getPaRequest() {
    return paRequest;
  }

  public void setPaRequest(String paRequest) {
    this.paRequest = paRequest;
  }

  public PayoutResponse pspReference(String pspReference) {
    this.pspReference = pspReference;
    return this;
  }

   /**
   * Adyen&#x27;s 16-character string reference associated with the transaction/request. This value is globally unique; quote it when communicating with us about this request.  &gt; &#x60;pspReference&#x60; is returned only for non-redirect payment methods.
   * @return pspReference
  **/
  public String getPspReference() {
    return pspReference;
  }

  public void setPspReference(String pspReference) {
    this.pspReference = pspReference;
  }

  public PayoutResponse refusalReason(String refusalReason) {
    this.refusalReason = refusalReason;
    return this;
  }

   /**
   * If the payment&#x27;s authorisation is refused or an error occurs during authorisation, this field holds Adyen&#x27;s mapped reason for the refusal or a description of the error.  When a transaction fails, the authorisation response includes &#x60;resultCode&#x60; and &#x60;refusalReason&#x60; values.
   * @return refusalReason
  **/
  public String getRefusalReason() {
    return refusalReason;
  }

  public void setRefusalReason(String refusalReason) {
    this.refusalReason = refusalReason;
  }

  public PayoutResponse resultCode(ResultCodeEnum resultCode) {
    this.resultCode = resultCode;
    return this;
  }

   /**
   * The result of the payment. Possible values:  * **Authorised** – Indicates the payment authorisation was successfully completed. This state serves as an indicator to proceed with the delivery of goods and services. This is a final state. * **Refused** – Indicates the payment was refused. The reason is given in the &#x60;refusalReason&#x60; field. This is a final state. * **RedirectShopper** – Indicates the shopper should be redirected to an external web page or app to complete the authorisation. * **Received** – Indicates the payment has successfully been received by Adyen, and will be processed. This is the initial state for all payments. * **Cancelled** – Indicates the payment has been cancelled (either by the shopper or the merchant) before processing was completed. This is a final state. * **Pending** – Indicates that it is not possible to obtain the final status of the payment. This can happen if the systems providing final status information for the payment are unavailable, or if the shopper needs to take further action to complete the payment. For more information on handling a pending payment, refer to [Payments with pending status](https://docs.adyen.com/development-resources/payments-with-pending-status). * **Error** – Indicates an error occurred during processing of the payment. The reason is given in the &#x60;refusalReason&#x60; field. This is a final state.
   * @return resultCode
  **/
  public ResultCodeEnum getResultCode() {
    return resultCode;
  }

  public void setResultCode(ResultCodeEnum resultCode) {
    this.resultCode = resultCode;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PayoutResponse payoutResponse = (PayoutResponse) o;
    return Objects.equals(this.additionalData, payoutResponse.additionalData) &&
        Objects.equals(this.authCode, payoutResponse.authCode) &&
        Objects.equals(this.dccAmount, payoutResponse.dccAmount) &&
        Objects.equals(this.dccSignature, payoutResponse.dccSignature) &&
        Objects.equals(this.fraudResult, payoutResponse.fraudResult) &&
        Objects.equals(this.issuerUrl, payoutResponse.issuerUrl) &&
        Objects.equals(this.md, payoutResponse.md) &&
        Objects.equals(this.paRequest, payoutResponse.paRequest) &&
        Objects.equals(this.pspReference, payoutResponse.pspReference) &&
        Objects.equals(this.refusalReason, payoutResponse.refusalReason) &&
        Objects.equals(this.resultCode, payoutResponse.resultCode);
  }

  @Override
  public int hashCode() {
    return Objects.hash(additionalData, authCode, dccAmount, dccSignature, fraudResult, issuerUrl, md, paRequest, pspReference, refusalReason, resultCode);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PayoutResponse {\n");

    sb.append("    additionalData: ").append(toIndentedString(additionalData)).append("\n");
    sb.append("    authCode: ").append(toIndentedString(authCode)).append("\n");
    sb.append("    dccAmount: ").append(toIndentedString(dccAmount)).append("\n");
    sb.append("    dccSignature: ").append(toIndentedString(dccSignature)).append("\n");
    sb.append("    fraudResult: ").append(toIndentedString(fraudResult)).append("\n");
    sb.append("    issuerUrl: ").append(toIndentedString(issuerUrl)).append("\n");
    sb.append("    md: ").append(toIndentedString(md)).append("\n");
    sb.append("    paRequest: ").append(toIndentedString(paRequest)).append("\n");
    sb.append("    pspReference: ").append(toIndentedString(pspReference)).append("\n");
    sb.append("    refusalReason: ").append(toIndentedString(refusalReason)).append("\n");
    sb.append("    resultCode: ").append(toIndentedString(resultCode)).append("\n");
    sb.append("}");
    return sb.toString();
  }

}
