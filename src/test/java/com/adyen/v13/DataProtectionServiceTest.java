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
 * Copyright (c) 2020 Adyen B.V.
 * This file is open source and available under the MIT license.
 * See the LICENSE file for more info.
 */
package com.adyen.v13;

import com.adyen.v13.model.SubjectErasureRequest;
import com.adyen.v13.model.SubjectErasureResponse;
import com.adyen.v13.service.DataProtection;
import com.adyen.v13.service.exception.ApiException;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class DataProtectionServiceTest extends BaseTest {
    /**
     * Test success flow for POST /requestSubjectErasure
     */
    @Test
    public void TestRequestSubjectErasureSuccessMocked() throws Exception {
        Client client = createMockClientFromFile("mocks/request-subject-erasure-success.json");
        DataProtection dataProtection = new DataProtection(client);
        SubjectErasureRequest subjectErasureRequest = createSubjectErasureRequest();

        SubjectErasureResponse subjectErasureResponse = dataProtection.requestSubjectErasure(subjectErasureRequest);

        assertEquals(SubjectErasureResponse.ResultEnum.SUCCESS, subjectErasureResponse.getResult());
    }

    protected SubjectErasureRequest createSubjectErasureRequest() {
        SubjectErasureRequest subjectErasureRequest = new SubjectErasureRequest();
        subjectErasureRequest.setForceErasure(false);
        subjectErasureRequest.setMerchantAccount("Test");
        subjectErasureRequest.setPspReference("123456");

        return subjectErasureRequest;
    }

    @Test
    public void TestGetAuthenticationResultErrorNotFound() throws IOException, ApiException {
        Client client = createMockClientFromFile("mocks/request-subject-erasure-not-found.json");
        DataProtection dataProtection = new DataProtection(client);
        SubjectErasureRequest subjectErasureRequest = createSubjectErasureRequest();

        SubjectErasureResponse subjectErasureResponse = dataProtection.requestSubjectErasure(subjectErasureRequest);

        assertEquals(SubjectErasureResponse.ResultEnum.PAYMENT_NOT_FOUND, subjectErasureResponse.getResult());
    }
}
