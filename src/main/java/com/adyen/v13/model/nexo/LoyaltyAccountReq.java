package com.adyen.v13.model.nexo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Definition: Data related to a requested Loyalty program or account. -- Usage: In the Balance Inquiry Request messageType, the Sale Terminal sends the identification of the loyalty account to request the balance.
 *
 * <p>Java class for LoyaltyAccountReq complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="LoyaltyAccountReq"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="CardAcquisitionReference" type="{}TransactionIdentification" minOccurs="0"/&gt;
 *         &lt;element name="LoyaltyAccountID" type="{}LoyaltyAccountID" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LoyaltyAccountReq", propOrder = {
        "cardAcquisitionReference",
        "loyaltyAccountID"
})
public class LoyaltyAccountReq {

    /**
     * The Card acquisition reference.
     */
    @XmlElement(name = "CardAcquisitionReference")
    protected TransactionIdentification cardAcquisitionReference;
    /**
     * The Loyalty account id.
     */
    @XmlElement(name = "LoyaltyAccountID")
    protected LoyaltyAccountID loyaltyAccountID;

    /**
     * Gets the value of the cardAcquisitionReference property.
     *
     * @return possible      object is     {@link TransactionIdentification }
     */
    public TransactionIdentification getCardAcquisitionReference() {
        return cardAcquisitionReference;
    }

    /**
     * Sets the value of the cardAcquisitionReference property.
     *
     * @param value allowed object is     {@link TransactionIdentification }
     */
    public void setCardAcquisitionReference(TransactionIdentification value) {
        this.cardAcquisitionReference = value;
    }

    /**
     * Gets the value of the loyaltyAccountID property.
     *
     * @return possible      object is     {@link LoyaltyAccountID }
     */
    public LoyaltyAccountID getLoyaltyAccountID() {
        return loyaltyAccountID;
    }

    /**
     * Sets the value of the loyaltyAccountID property.
     *
     * @param value allowed object is     {@link LoyaltyAccountID }
     */
    public void setLoyaltyAccountID(LoyaltyAccountID value) {
        this.loyaltyAccountID = value;
    }

}
