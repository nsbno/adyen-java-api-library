package com.adyen.v11.service;

import com.adyen.v11.ApiKeyAuthenticatedService;
import com.adyen.v11.Client;
import com.adyen.v11.model.binlookup.CostEstimateRequest;
import com.adyen.v11.model.binlookup.CostEstimateResponse;
import com.adyen.v11.model.binlookup.ThreeDSAvailabilityRequest;
import com.adyen.v11.model.binlookup.ThreeDSAvailabilityResponse;
import com.adyen.v11.service.resource.binlookup.Get3dsAvailability;
import com.adyen.v11.service.resource.binlookup.GetCostEstimate;
import com.google.gson.reflect.TypeToken;

public class BinLookup extends ApiKeyAuthenticatedService {

    private Get3dsAvailability get3dsAvailability;
    private GetCostEstimate getCostEstimate;

    public BinLookup(Client client) {
        super(client);
        get3dsAvailability = new Get3dsAvailability(this);
        getCostEstimate = new GetCostEstimate(this);
    }


    public ThreeDSAvailabilityResponse get3dsAvailability(ThreeDSAvailabilityRequest threeDSAvailabilityRequest) throws Exception {
        String jsonRequest = GSON.toJson(threeDSAvailabilityRequest);

        String jsonResult = get3dsAvailability.request(jsonRequest);

        return GSON.fromJson(jsonResult, new TypeToken<ThreeDSAvailabilityResponse>() {
        }.getType());
    }

    public CostEstimateResponse getCostEstimate(CostEstimateRequest costEstimateRequest) throws Exception {
        String jsonRequest = GSON.toJson(costEstimateRequest);

        String jsonResult = getCostEstimate.request(jsonRequest);

        return GSON.fromJson(jsonResult, new TypeToken<CostEstimateResponse>() {
        }.getType());
    }

}
