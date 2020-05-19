package com.adyen.model.nexo;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;
import java.util.Arrays;


/**
 * <p>Java class for InfoQualifyType.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;simpleType name="InfoQualifyType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="Status"/&gt;
 *     &lt;enumeration value="Error"/&gt;
 *     &lt;enumeration value="Display"/&gt;
 *     &lt;enumeration value="Sound"/&gt;
 *     &lt;enumeration value="Input"/&gt;
 *     &lt;enumeration value="POIReplication"/&gt;
 *     &lt;enumeration value="CustomerAssistance"/&gt;
 *     &lt;enumeration value="Receipt"/&gt;
 *     &lt;enumeration value="Document"/&gt;
 *     &lt;enumeration value="Voucher"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 */
@XmlType(name = "InfoQualifyType")
@XmlEnum
public enum InfoQualifyType {


    /**
     * The information is a new state on which the messageType sender is entering. For instance, during a payment, the POI could display to the Cashier that POI request
     */
    @XmlEnumValue("Status")
    STATUS("Status"),

    /**
     * The information is related to an error situation occurring on the messageType sender.
     */
    @XmlEnumValue("Error")
    ERROR("Error"),

    /**
     * Standard display interface.
     */
    @XmlEnumValue("Display")
    DISPLAY("Display"),

    /**
     * Standard sound interface.
     */
    @XmlEnumValue("Sound")
    SOUND("Sound"),

    /**
     * Answer to a question or information to be entered by the Cashier or the Customer, at the request of the POI Terminal or the Sale Terminal.
     */
    @XmlEnumValue("Input")
    INPUT("Input"),

    /**
     * Information displayed on the Cardholder POI interface, replicated on the Cashier interface.
     */
    @XmlEnumValue("POIReplication")
    POI_REPLICATION("POIReplication"),

    /**
     * Input of the Cardholder POI interface which can be entered by the Cashier to assist the Customer.
     */
    @XmlEnumValue("CustomerAssistance")
    CUSTOMER_ASSISTANCE("CustomerAssistance"),

    /**
     * Where you print the Payment receipt that could be located on the Sale Terminal or in some cases a restricted Sale ticket on the POI Terminal.
     */
    @XmlEnumValue("Receipt")
    RECEIPT("Receipt"),

    /**
     * When the POI System wants to print specific document (check, dynamic currency conversion ...).  Used by the Sale System when the printer is not located on the
     */
    @XmlEnumValue("Document")
    DOCUMENT("Document"),

    /**
     * Coupons, voucher or special ticket generated by the POI or the Sale System and to be printed.
     */
    @XmlEnumValue("Voucher")
    VOUCHER("Voucher");
    private final String value;

    InfoQualifyType(String v) {
        value = v;
    }

    /**
     * Value string.
     *
     * @return the string
     */
    public String value() {
        return value;
    }

    /**
     * From value info qualify type.
     *
     * @param v the v
     * @return the info qualify type
     */
    public static InfoQualifyType fromValue(String v) {
        return Arrays.stream(values()).
                filter(s -> s.value.equals(v)).
                findFirst().orElseThrow(() -> new IllegalArgumentException(v));
    }

}
