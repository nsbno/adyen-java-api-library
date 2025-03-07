package com.adyen.v13.model.nexo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;
import java.math.BigDecimal;


/**
 * Definition: Customer order attached to a card, recorded in the POI system. -- Usage: Allows the management of customer orders by the POI, for instance in a multi-channel or a click and collect sale transaction.
 *
 * <p>Java class for CustomerOrder complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="CustomerOrder"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="AdditionalInformation" type="{}AdditionalInformation" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="CustomerOrderID" use="required" type="{}CustomerOrderID" /&gt;
 *       &lt;attribute name="OpenOrderState" type="{}OpenOrderState" default="false" /&gt;
 *       &lt;attribute name="StartDate" use="required" type="{}StartDate" /&gt;
 *       &lt;attribute name="EndDate" type="{}EndDate" /&gt;
 *       &lt;attribute name="ForecastedAmount" use="required" type="{}SimpleAmountType" /&gt;
 *       &lt;attribute name="CurrentAmount" use="required" type="{}SimpleAmountType" /&gt;
 *       &lt;attribute name="Currency" type="{}ISOCurrency3A" /&gt;
 *       &lt;attribute name="AccessedBy" type="{}AccessedBy" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CustomerOrder", propOrder = {
        "additionalInformation"
})
public class CustomerOrder {

    /**
     * The Additional information.
     */
    @XmlElement(name = "AdditionalInformation")
    protected String additionalInformation;
    /**
     * The Customer order id.
     */
    @XmlAttribute(name = "CustomerOrderID", required = true)
    protected String customerOrderID;
    /**
     * The Open order state.
     */
    @XmlAttribute(name = "OpenOrderState")
    protected Boolean openOrderState;
    /**
     * The Start date.
     */
    @XmlAttribute(name = "StartDate", required = true)
    protected XMLGregorianCalendar startDate;
    /**
     * The End date.
     */
    @XmlAttribute(name = "EndDate")
    protected XMLGregorianCalendar endDate;
    /**
     * The Forecasted amount.
     */
    @XmlAttribute(name = "ForecastedAmount", required = true)
    protected BigDecimal forecastedAmount;
    /**
     * The Current amount.
     */
    @XmlAttribute(name = "CurrentAmount", required = true)
    protected BigDecimal currentAmount;
    /**
     * The Currency.
     */
    @XmlAttribute(name = "Currency")
    protected String currency;
    /**
     * The Accessed by.
     */
    @XmlAttribute(name = "AccessedBy")
    protected String accessedBy;

    /**
     * Gets the value of the additionalInformation property.
     *
     * @return possible      object is     {@link String }
     */
    public String getAdditionalInformation() {
        return additionalInformation;
    }

    /**
     * Sets the value of the additionalInformation property.
     *
     * @param value allowed object is     {@link String }
     */
    public void setAdditionalInformation(String value) {
        this.additionalInformation = value;
    }

    /**
     * Gets the value of the customerOrderID property.
     *
     * @return possible      object is     {@link String }
     */
    public String getCustomerOrderID() {
        return customerOrderID;
    }

    /**
     * Sets the value of the customerOrderID property.
     *
     * @param value allowed object is     {@link String }
     */
    public void setCustomerOrderID(String value) {
        this.customerOrderID = value;
    }

    /**
     * Gets the value of the openOrderState property.
     *
     * @return possible      object is     {@link Boolean }
     */
    public boolean isOpenOrderState() {
        if (openOrderState == null) {
            return false;
        } else {
            return openOrderState;
        }
    }

    /**
     * Sets the value of the openOrderState property.
     *
     * @param value allowed object is     {@link Boolean }
     */
    public void setOpenOrderState(Boolean value) {
        this.openOrderState = value;
    }

    /**
     * Gets the value of the startDate property.
     *
     * @return possible      object is     {@link XMLGregorianCalendar }
     */
    public XMLGregorianCalendar getStartDate() {
        return startDate;
    }

    /**
     * Sets the value of the startDate property.
     *
     * @param value allowed object is     {@link XMLGregorianCalendar }
     */
    public void setStartDate(XMLGregorianCalendar value) {
        this.startDate = value;
    }

    /**
     * Gets the value of the endDate property.
     *
     * @return possible      object is     {@link XMLGregorianCalendar }
     */
    public XMLGregorianCalendar getEndDate() {
        return endDate;
    }

    /**
     * Sets the value of the endDate property.
     *
     * @param value allowed object is     {@link XMLGregorianCalendar }
     */
    public void setEndDate(XMLGregorianCalendar value) {
        this.endDate = value;
    }

    /**
     * Gets the value of the forecastedAmount property.
     *
     * @return possible      object is     {@link BigDecimal }
     */
    public BigDecimal getForecastedAmount() {
        return forecastedAmount;
    }

    /**
     * Sets the value of the forecastedAmount property.
     *
     * @param value allowed object is     {@link BigDecimal }
     */
    public void setForecastedAmount(BigDecimal value) {
        this.forecastedAmount = value;
    }

    /**
     * Gets the value of the currentAmount property.
     *
     * @return possible      object is     {@link BigDecimal }
     */
    public BigDecimal getCurrentAmount() {
        return currentAmount;
    }

    /**
     * Sets the value of the currentAmount property.
     *
     * @param value allowed object is     {@link BigDecimal }
     */
    public void setCurrentAmount(BigDecimal value) {
        this.currentAmount = value;
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
     * Gets the value of the accessedBy property.
     *
     * @return possible      object is     {@link String }
     */
    public String getAccessedBy() {
        return accessedBy;
    }

    /**
     * Sets the value of the accessedBy property.
     *
     * @param value allowed object is     {@link String }
     */
    public void setAccessedBy(String value) {
        this.accessedBy = value;
    }

}
