package com.adyen.v13.model.nexo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Definition: Information related to the mobile for the payment transaction. -- Usage: Mobile phone is used as a payment instrument for the transaction.
 *
 * <p>Java class for MobileData complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="MobileData"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="MobileCountryCode" type="{}MobileCountryCode" minOccurs="0"/&gt;
 *         &lt;element name="Geolocation" type="{}Geolocation" minOccurs="0"/&gt;
 *         &lt;element name="ProtectedMobileData" type="{}ContentInformation" minOccurs="0"/&gt;
 *         &lt;element name="SensitiveMobileData" type="{}SensitiveMobileData" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="MobileNetworkCode" type="{}MobileNetworkCode" /&gt;
 *       &lt;attribute name="MaskedMSISDN" type="{}MaskedMSISDN" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MobileData", propOrder = {
        "mobileCountryCode",
        "geolocation",
        "protectedMobileData",
        "sensitiveMobileData"
})
public class MobileData {

    /**
     * The Mobile country code.
     */
    @XmlElement(name = "MobileCountryCode")
    protected String mobileCountryCode;
    /**
     * The Geolocation.
     */
    @XmlElement(name = "Geolocation")
    protected Geolocation geolocation;
    /**
     * The Protected mobile data.
     */
    @XmlElement(name = "ProtectedMobileData")
    protected ContentInformation protectedMobileData;
    /**
     * The Sensitive mobile data.
     */
    @XmlElement(name = "SensitiveMobileData")
    protected SensitiveMobileData sensitiveMobileData;
    /**
     * The Mobile network code.
     */
    @XmlAttribute(name = "MobileNetworkCode")
    protected String mobileNetworkCode;
    /**
     * The Masked msisdn.
     */
    @XmlAttribute(name = "MaskedMSISDN")
    protected String maskedMSISDN;

    /**
     * Gets the value of the mobileCountryCode property.
     *
     * @return possible      object is     {@link String }
     */
    public String getMobileCountryCode() {
        return mobileCountryCode;
    }

    /**
     * Sets the value of the mobileCountryCode property.
     *
     * @param value allowed object is     {@link String }
     */
    public void setMobileCountryCode(String value) {
        this.mobileCountryCode = value;
    }

    /**
     * Gets the value of the geolocation property.
     *
     * @return possible      object is     {@link Geolocation }
     */
    public Geolocation getGeolocation() {
        return geolocation;
    }

    /**
     * Sets the value of the geolocation property.
     *
     * @param value allowed object is     {@link Geolocation }
     */
    public void setGeolocation(Geolocation value) {
        this.geolocation = value;
    }

    /**
     * Gets the value of the protectedMobileData property.
     *
     * @return possible      object is     {@link ContentInformation }
     */
    public ContentInformation getProtectedMobileData() {
        return protectedMobileData;
    }

    /**
     * Sets the value of the protectedMobileData property.
     *
     * @param value allowed object is     {@link ContentInformation }
     */
    public void setProtectedMobileData(ContentInformation value) {
        this.protectedMobileData = value;
    }

    /**
     * Gets the value of the sensitiveMobileData property.
     *
     * @return possible      object is     {@link SensitiveMobileData }
     */
    public SensitiveMobileData getSensitiveMobileData() {
        return sensitiveMobileData;
    }

    /**
     * Sets the value of the sensitiveMobileData property.
     *
     * @param value allowed object is     {@link SensitiveMobileData }
     */
    public void setSensitiveMobileData(SensitiveMobileData value) {
        this.sensitiveMobileData = value;
    }

    /**
     * Gets the value of the mobileNetworkCode property.
     *
     * @return possible      object is     {@link String }
     */
    public String getMobileNetworkCode() {
        return mobileNetworkCode;
    }

    /**
     * Sets the value of the mobileNetworkCode property.
     *
     * @param value allowed object is     {@link String }
     */
    public void setMobileNetworkCode(String value) {
        this.mobileNetworkCode = value;
    }

    /**
     * Gets the value of the maskedMSISDN property.
     *
     * @return possible      object is     {@link String }
     */
    public String getMaskedMSISDN() {
        return maskedMSISDN;
    }

    /**
     * Sets the value of the maskedMSISDN property.
     *
     * @param value allowed object is     {@link String }
     */
    public void setMaskedMSISDN(String value) {
        this.maskedMSISDN = value;
    }

}
