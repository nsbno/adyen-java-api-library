package com.adyen.v13.model.nexo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Definition: Information related to the result the output (display, print, input). -- Usage: In the messageType response, it contains the result of the output, if required in the messageType request.
 *
 * <p>Java class for OutputResult complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="OutputResult"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Response" type="{}Response"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="Device" use="required" type="{}DeviceType" /&gt;
 *       &lt;attribute name="InfoQualify" use="required" type="{}InfoQualifyType" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OutputResult", propOrder = {
        "response"
})
public class OutputResult {

    /**
     * The Response.
     */
    @XmlElement(name = "Response", required = true)
    protected Response response;
    /**
     * The Device.
     */
    @XmlAttribute(name = "Device", required = true)
    protected DeviceType device;
    /**
     * The Info qualify.
     */
    @XmlAttribute(name = "InfoQualify", required = true)
    protected InfoQualifyType infoQualify;

    /**
     * Gets the value of the response property.
     *
     * @return possible      object is     {@link Response }
     */
    public Response getResponse() {
        return response;
    }

    /**
     * Sets the value of the response property.
     *
     * @param value allowed object is     {@link Response }
     */
    public void setResponse(Response value) {
        this.response = value;
    }

    /**
     * Gets the value of the device property.
     *
     * @return possible      object is     {@link DeviceType }
     */
    public DeviceType getDevice() {
        return device;
    }

    /**
     * Sets the value of the device property.
     *
     * @param value allowed object is     {@link DeviceType }
     */
    public void setDevice(DeviceType value) {
        this.device = value;
    }

    /**
     * Gets the value of the infoQualify property.
     *
     * @return possible      object is     {@link InfoQualifyType }
     */
    public InfoQualifyType getInfoQualify() {
        return infoQualify;
    }

    /**
     * Sets the value of the infoQualify property.
     *
     * @param value allowed object is     {@link InfoQualifyType }
     */
    public void setInfoQualify(InfoQualifyType value) {
        this.infoQualify = value;
    }

}
