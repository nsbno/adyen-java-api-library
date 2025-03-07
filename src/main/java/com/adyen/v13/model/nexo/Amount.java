package com.adyen.v13.model.nexo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;
import java.math.BigDecimal;


/**
 * Definition: Common amount definition with currency -- Usage: Decimal unsigned amount with currency and amount before conversion.
 *
 * <p>Java class for Amount complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="Amount"&gt;
 *   &lt;simpleContent&gt;
 *     &lt;extension base="Decimal"&gt;
 *       &lt;attribute name="Currency" type="{}ISOCurrency3A" /&gt;
 *     &lt;/extension&gt;
 *   &lt;/simpleContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Amount", propOrder = {
        "value"
})
public class Amount {

    /**
     * The Value.
     */
    @XmlValue
    protected BigDecimal value;
    /**
     * The Currency.
     */
    @XmlAttribute(name = "Currency")
    protected String currency;

    /**
     * Gets the value of the value property.
     *
     * @return possible      object is     {@link BigDecimal }
     */
    public BigDecimal getValue() {
        return value;
    }

    /**
     * Sets the value of the value property.
     *
     * @param value allowed object is     {@link BigDecimal }
     */
    public void setValue(BigDecimal value) {
        this.value = value;
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

}
