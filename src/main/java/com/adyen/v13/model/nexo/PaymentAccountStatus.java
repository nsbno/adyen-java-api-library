package com.adyen.v13.model.nexo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.math.BigDecimal;


/**
 * Definition: Data related to the result of a Balance Inquiry request.
 *
 * <p>Java class for PaymentAccountStatus complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="PaymentAccountStatus"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="PaymentInstrumentData" type="{}PaymentInstrumentData" minOccurs="0"/&gt;
 *         &lt;element name="PaymentAcquirerData" type="{}PaymentAcquirerData" minOccurs="0"/&gt;
 *         &lt;element name="LoyaltyAccountStatus" type="{}LoyaltyAccountStatus" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="Currency" type="{}ISOCurrency3A" /&gt;
 *       &lt;attribute name="CurrentBalance" type="{}SimpleAmountType" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PaymentAccountStatus", propOrder = {
        "paymentInstrumentData",
        "paymentAcquirerData",
        "loyaltyAccountStatus"
})
public class PaymentAccountStatus {

    /**
     * The Payment instrument data.
     */
    @XmlElement(name = "PaymentInstrumentData")
    protected PaymentInstrumentData paymentInstrumentData;
    /**
     * The Payment acquirer data.
     */
    @XmlElement(name = "PaymentAcquirerData")
    protected PaymentAcquirerData paymentAcquirerData;
    /**
     * The Loyalty account status.
     */
    @XmlElement(name = "LoyaltyAccountStatus")
    protected LoyaltyAccountStatus loyaltyAccountStatus;
    /**
     * The Currency.
     */
    @XmlAttribute(name = "Currency")
    protected String currency;
    /**
     * The Current balance.
     */
    @XmlAttribute(name = "CurrentBalance")
    protected BigDecimal currentBalance;

    /**
     * Gets the value of the paymentInstrumentData property.
     *
     * @return possible      object is     {@link PaymentInstrumentData }
     */
    public PaymentInstrumentData getPaymentInstrumentData() {
        return paymentInstrumentData;
    }

    /**
     * Sets the value of the paymentInstrumentData property.
     *
     * @param value allowed object is     {@link PaymentInstrumentData }
     */
    public void setPaymentInstrumentData(PaymentInstrumentData value) {
        this.paymentInstrumentData = value;
    }

    /**
     * Gets the value of the paymentAcquirerData property.
     *
     * @return possible      object is     {@link PaymentAcquirerData }
     */
    public PaymentAcquirerData getPaymentAcquirerData() {
        return paymentAcquirerData;
    }

    /**
     * Sets the value of the paymentAcquirerData property.
     *
     * @param value allowed object is     {@link PaymentAcquirerData }
     */
    public void setPaymentAcquirerData(PaymentAcquirerData value) {
        this.paymentAcquirerData = value;
    }

    /**
     * Gets the value of the loyaltyAccountStatus property.
     *
     * @return possible      object is     {@link LoyaltyAccountStatus }
     */
    public LoyaltyAccountStatus getLoyaltyAccountStatus() {
        return loyaltyAccountStatus;
    }

    /**
     * Sets the value of the loyaltyAccountStatus property.
     *
     * @param value allowed object is     {@link LoyaltyAccountStatus }
     */
    public void setLoyaltyAccountStatus(LoyaltyAccountStatus value) {
        this.loyaltyAccountStatus = value;
    }

    /**
     * Gets the value of the currency property.
     *
     * @return possible      object is     {@link String }
     */
    public String getCurrency() {
        return currency;
    }

    /**
     * Sets the value of the currency property.
     *
     * @param value allowed object is     {@link String }
     */
    public void setCurrency(String value) {
        this.currency = value;
    }

    /**
     * Gets the value of the currentBalance property.
     *
     * @return possible      object is     {@link BigDecimal }
     */
    public BigDecimal getCurrentBalance() {
        return currentBalance;
    }

    /**
     * Sets the value of the currentBalance property.
     *
     * @param value allowed object is     {@link BigDecimal }
     */
    public void setCurrentBalance(BigDecimal value) {
        this.currentBalance = value;
    }

}
