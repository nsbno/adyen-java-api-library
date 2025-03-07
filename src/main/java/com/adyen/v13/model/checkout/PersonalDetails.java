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
 * Copyright (c) 2017 Adyen B.V.
 * This file is open source and available under the MIT license.
 * See the LICENSE file for more info.
 */
package com.adyen.v13.model.checkout;

import com.adyen.v13.enums.Gender;
import com.google.gson.annotations.SerializedName;

public class PersonalDetails {
    @SerializedName("firstName")
    private String firstName;
    @SerializedName("infix")
    private String infix;
    @SerializedName("lastName")
    private String lastName;
    @SerializedName("dateOfBirth")
    private String dateOfBirth;
    @SerializedName("gender")
    private Gender gender;
    @SerializedName("telephoneNumber")
    private String telephoneNumber;
    @SerializedName("socialSecurityNumber")
    private String socialSecurityNumber;
    @SerializedName("shopperEmail")
    private String shopperEmail;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public PersonalDetails firstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getInfix() {
        return infix;
    }

    public void setInfix(String infix) {
        this.infix = infix;
    }

    public PersonalDetails infix(String infix) {
        this.infix = infix;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public PersonalDetails lastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public PersonalDetails dateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
        return this;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public PersonalDetails telephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
        return this;
    }

    public String getSocialSecurityNumber() {
        return socialSecurityNumber;
    }

    public void setSocialSecurityNumber(String socialSecurityNumber) {
        this.socialSecurityNumber = socialSecurityNumber;
    }

    public PersonalDetails socialSecurityNumber(String socialSecurityNumber) {
        this.socialSecurityNumber = socialSecurityNumber;
        return this;
    }

    public String getShopperEmail() {
        return shopperEmail;
    }

    public void setShopperEmail(String shopperEmail) {
        this.shopperEmail = shopperEmail;
    }

    public PersonalDetails shopperEmail(String shopperEmail) {
        this.shopperEmail = shopperEmail;
        return this;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public PersonalDetails gender(Gender gender) {
        this.gender = gender;
        return this;
    }

    @Override
    public String toString() {
        return "PersonalDetails{"
                + "firstName='"
                + firstName
                + '\''
                + ", infix='"
                + infix
                + '\''
                + ", lastName='"
                + lastName
                + '\''
                + ", dateOfBirth='"
                + dateOfBirth
                + '\''
                + ", telephoneNumber='"
                + telephoneNumber
                + '\''
                + ", socialSecurityNumber='"
                + socialSecurityNumber
                + '\''
                + ", shopperEmail='"
                + shopperEmail
                + '\''
                + ", gender='"
                + gender
                + '\''
                + '}';
    }
}
