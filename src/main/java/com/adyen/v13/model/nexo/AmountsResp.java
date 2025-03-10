package com.adyen.v13.model.nexo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import java.math.BigDecimal;


/**
 * Definition: Various amounts related to the payment response from the POI System. -- Usage: Amounts approved by the POI and the Acquirer for the payment and loyalty transaction, containing: The authorised amount to be paid The amount of the rebates The amount of financial fees The cash back part of the requested amount for a
 *
 * <p>Java class for AmountsResp complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="AmountsResp"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;attribute name="Currency" type="{}ISOCurrency3A" /&gt;
 *       &lt;attribute name="AuthorizedAmount" use="required" type="{}SimpleAmountType" /&gt;
 *       &lt;attribute name="TotalRebatesAmount" type="{}SimpleAmountType" /&gt;
 *       &lt;attribute name="TotalFeesAmount" type="{}SimpleAmountType" /&gt;
 *       &lt;attribute name="CashBackAmount" type="{}SimpleAmountType" /&gt;
 *       &lt;attribute name="TipAmount" type="{}SimpleAmountType" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AmountsResp")
public class AmountsResp {

    /**
     * The Currency.
     */
    @XmlAttribute(name = "Currency")
    protected String currency;
    /**
     * The Authorized amount.
     */
    @XmlAttribute(name = "AuthorizedAmount", required = true)
    protected BigDecimal authorizedAmount;
    /**
     * The Total rebates amount.
     */
    @XmlAttribute(name = "TotalRebatesAmount")
    protected BigDecimal totalRebatesAmount;
    /**
     * The Total fees amount.
     */
    @XmlAttribute(name = "TotalFeesAmount")
    protected BigDecimal totalFeesAmount;
    /**
     * The Cash back amount.
     */
    @XmlAttribute(name = "CashBackAmount")
    protected BigDecimal cashBackAmount;
    /**
     * The Tip amount.
     */
    @XmlAttribute(name = "TipAmount")
    protected BigDecimal tipAmount;

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
     * Gets the value of the authorizedAmount property.
     *
     * @return possible      object is     {@link BigDecimal }
     */
    public BigDecimal getAuthorizedAmount() {
        return authorizedAmount;
    }

    /**
     * Sets the value of the authorizedAmount property.
     *
     * @param value allowed object is     {@link BigDecimal }
     */
    public void setAuthorizedAmount(BigDecimal value) {
        this.authorizedAmount = value;
    }

    /**
     * Gets the value of the totalRebatesAmount property.
     *
     * @return possible      object is     {@link BigDecimal }
     */
    public BigDecimal getTotalRebatesAmount() {
        return totalRebatesAmount;
    }

    /**
     * Sets the value of the totalRebatesAmount property.
     *
     * @param value allowed object is     {@link BigDecimal }
     */
    public void setTotalRebatesAmount(BigDecimal value) {
        this.totalRebatesAmount = value;
    }

    /**
     * Gets the value of the totalFeesAmount property.
     *
     * @return possible      object is     {@link BigDecimal }
     */
    public BigDecimal getTotalFeesAmount() {
        return totalFeesAmount;
    }

    /**
     * Sets the value of the totalFeesAmount property.
     *
     * @param value allowed object is     {@link BigDecimal }
     */
    public void setTotalFeesAmount(BigDecimal value) {
        this.totalFeesAmount = value;
    }

    /**
     * Gets the value of the cashBackAmount property.
     *
     * @return possible      object is     {@link BigDecimal }
     */
    public BigDecimal getCashBackAmount() {
        return cashBackAmount;
    }

    /**
     * Sets the value of the cashBackAmount property.
     *
     * @param value allowed object is     {@link BigDecimal }
     */
    public void setCashBackAmount(BigDecimal value) {
        this.cashBackAmount = value;
    }

    /**
     * Gets the value of the tipAmount property.
     *
     * @return possible      object is     {@link BigDecimal }
     */
    public BigDecimal getTipAmount() {
        return tipAmount;
    }

    /**
     * Sets the value of the tipAmount property.
     *
     * @param value allowed object is     {@link BigDecimal }
     */
    public void setTipAmount(BigDecimal value) {
        this.tipAmount = value;
    }

}
