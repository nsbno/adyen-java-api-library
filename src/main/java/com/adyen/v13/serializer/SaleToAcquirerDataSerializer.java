package com.adyen.v13.serializer;

import com.adyen.v13.model.terminal.SaleToAcquirerData;
import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;

public class SaleToAcquirerDataSerializer implements JsonSerializer<SaleToAcquirerData> {

    public JsonElement serialize(SaleToAcquirerData saleToAcquirerData, Type typeOfSrc, JsonSerializationContext context) {
        return new JsonPrimitive(saleToAcquirerData.toBase64());
    }
}
