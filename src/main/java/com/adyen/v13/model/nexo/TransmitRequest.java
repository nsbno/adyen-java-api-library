package com.adyen.v13.model.nexo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.math.BigInteger;


/**
 * Definition: Content of the Transmit Request messageType. -- Usage: It contains a messageType to transmit.
 *
 * <p>Java class for TransmitRequest complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="TransmitRequest"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Message" type="{}Message"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="WaitResponseFlag" type="{}WaitResponseFlag" default="false" /&gt;
 *       &lt;attribute name="MaximumTransmitTime" use="required" type="{}MaximumTransmitTime" /&gt;
 *       &lt;attribute name="DestinationAddress" use="required" type="{}DestinationAddress" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TransmitRequest", propOrder = {
        "message"
})
public class TransmitRequest {

    /**
     * The Message.
     */
    @XmlElement(name = "Message", required = true)
    protected byte[] message;
    /**
     * The Wait response flag.
     */
    @XmlAttribute(name = "WaitResponseFlag")
    protected Boolean waitResponseFlag;
    /**
     * The Maximum transmit time.
     */
    @XmlAttribute(name = "MaximumTransmitTime", required = true)
    protected BigInteger maximumTransmitTime;
    /**
     * The Destination address.
     */
    @XmlAttribute(name = "DestinationAddress", required = true)
    protected String destinationAddress;

    /**
     * Gets the value of the messageType property.
     *
     * @return possible      object is     byte[]
     */
    public byte[] getMessage() {
        return message;
    }

    /**
     * Sets the value of the messageType property.
     *
     * @param value allowed object is     byte[]
     */
    public void setMessage(byte[] value) {
        this.message = value;
    }

    /**
     * Gets the value of the waitResponseFlag property.
     *
     * @return possible      object is     {@link Boolean }
     */
    public boolean isWaitResponseFlag() {
        if (waitResponseFlag == null) {
            return false;
        } else {
            return waitResponseFlag;
        }
    }

    /**
     * Sets the value of the waitResponseFlag property.
     *
     * @param value allowed object is     {@link Boolean }
     */
    public void setWaitResponseFlag(Boolean value) {
        this.waitResponseFlag = value;
    }

    /**
     * Gets the value of the maximumTransmitTime property.
     *
     * @return possible      object is     {@link BigInteger }
     */
    public BigInteger getMaximumTransmitTime() {
        return maximumTransmitTime;
    }

    /**
     * Sets the value of the maximumTransmitTime property.
     *
     * @param value allowed object is     {@link BigInteger }
     */
    public void setMaximumTransmitTime(BigInteger value) {
        this.maximumTransmitTime = value;
    }

    /**
     * Gets the value of the destinationAddress property.
     *
     * @return possible      object is     {@link String }
     */
    public String getDestinationAddress() {
        return destinationAddress;
    }

    /**
     * Sets the value of the destinationAddress property.
     *
     * @param value allowed object is     {@link String }
     */
    public void setDestinationAddress(String value) {
        this.destinationAddress = value;
    }

}
