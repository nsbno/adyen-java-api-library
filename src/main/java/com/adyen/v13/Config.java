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
 * Copyright (c) 2018 Adyen B.V.
 * This file is open source and available under the MIT license.
 * See the LICENSE file for more info.
 */
package com.adyen.v13;

import com.adyen.v13.enums.Environment;
import com.adyen.v13.util.CertificateUtil;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;

public class Config {
    protected String username;
    protected String password;
    protected String merchantAccount;
    protected Environment environment;
    protected String endpoint;
    protected String marketPayEndpoint;
    /**
     * Application name: used as HTTP client User-Agent
     */
    protected String applicationName;
    protected String apiKey;
    protected int connectionTimeoutMillis;
    protected int readTimeoutMillis;

    //HPP specific
    protected String hppEndpoint;
    protected String skinCode;
    protected String hmacKey;

    //Checkout Specific
    protected String checkoutEndpoint;

    //Terminal API Specific
    protected String terminalApiCloudEndpoint;
    protected String terminalApiLocalEndpoint;
    protected Certificate terminalCertificate;

    //Terminal Management API specific
    protected String posTerminalManagementApiEndpoint;

    protected String dataProtectionEndpoint;

    public Config() {
        // do nothing
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMerchantAccount() {
        return merchantAccount;
    }

    public void setMerchantAccount(String merchantAccount) {
        this.merchantAccount = merchantAccount;
    }

    public Environment getEnvironment() {
        return environment;
    }

    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }

    public String getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    public String getMarketPayEndpoint() {
        return marketPayEndpoint;
    }

    public void setMarketPayEndpoint(String marketPayEndpoint) {
        this.marketPayEndpoint = marketPayEndpoint;
    }

    public String getApplicationName() {
        return applicationName;
    }

    public void setApplicationName(String applicationName) {
        this.applicationName = applicationName;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public String getHppEndpoint() {
        return hppEndpoint;
    }

    public void setHppEndpoint(String hppEndpoint) {
        this.hppEndpoint = hppEndpoint;
    }

    public String getSkinCode() {
        return skinCode;
    }

    public void setSkinCode(String skinCode) {
        this.skinCode = skinCode;
    }

    public String getHmacKey() {
        return hmacKey;
    }

    public void setHmacKey(String hmacKey) {
        this.hmacKey = hmacKey;
    }

    public String getCheckoutEndpoint() {
        if (checkoutEndpoint == null || checkoutEndpoint.isEmpty()) {
            String message = "Please provide your unique live url prefix on the setEnvironment() call on the Client or provide checkoutEndpoint in your config object.";
            throw new IllegalArgumentException(message);
        }
        return checkoutEndpoint;
    }

    public void setCheckoutEndpoint(String checkoutEndpoint) {
        this.checkoutEndpoint = checkoutEndpoint;
    }

    public String getTerminalApiCloudEndpoint() {
        return terminalApiCloudEndpoint;
    }

    public void setTerminalApiCloudEndpoint(String terminalApiCloudEndpoint) {
        this.terminalApiCloudEndpoint = terminalApiCloudEndpoint;
    }

    public String getTerminalApiLocalEndpoint() {
        return terminalApiLocalEndpoint;
    }

    public void setTerminalApiLocalEndpoint(String terminalApiLocalEndpoint) {
        this.terminalApiLocalEndpoint = terminalApiLocalEndpoint;
    }

    public int getConnectionTimeoutMillis() {
        return connectionTimeoutMillis;
    }

    public void setConnectionTimeoutMillis(int connectionTimeoutMillis) {
        this.connectionTimeoutMillis = connectionTimeoutMillis;
    }

    public int getReadTimeoutMillis() {
        return readTimeoutMillis;
    }

    public void setReadTimeoutMillis(int readTimeoutMillis) {
        this.readTimeoutMillis = readTimeoutMillis;
    }

    public String getPosTerminalManagementApiEndpoint() {
        return posTerminalManagementApiEndpoint;
    }

    public void setPosTerminalManagementApiEndpoint(String posTerminalManagementApiEndpoint) {
        this.posTerminalManagementApiEndpoint = posTerminalManagementApiEndpoint;
    }

    public Certificate getTerminalCertificate() {
        return terminalCertificate;
    }

    public void setTerminalCertificate(Certificate terminalCertificate) {
        this.terminalCertificate = terminalCertificate;
    }

    public void setTerminalCertificate(String terminalCertificatePath) throws FileNotFoundException, CertificateException {
        this.terminalCertificate = CertificateUtil.loadCertificate(terminalCertificatePath);
    }

    public void setTerminalCertificate(InputStream terminalCertificateStream) throws CertificateException {
        this.terminalCertificate = CertificateUtil.loadCertificate(terminalCertificateStream);
    }

    public String getDataProtectionEndpoint() {
        return dataProtectionEndpoint;
    }

    public void setDataProtectionEndpoint(String dataProtectionEndpoint) {
        this.dataProtectionEndpoint = dataProtectionEndpoint;
    }

}
