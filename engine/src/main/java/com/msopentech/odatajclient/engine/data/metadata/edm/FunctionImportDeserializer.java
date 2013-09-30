/**
 * Copyright © Microsoft Open Technologies, Inc.
 *
 * All Rights Reserved
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * THIS CODE IS PROVIDED *AS IS* BASIS, WITHOUT WARRANTIES OR CONDITIONS
 * OF ANY KIND, EITHER EXPRESS OR IMPLIED, INCLUDING WITHOUT LIMITATION
 * ANY IMPLIED WARRANTIES OR CONDITIONS OF TITLE, FITNESS FOR A
 * PARTICULAR PURPOSE, MERCHANTABILITY OR NON-INFRINGEMENT.
 *
 * See the Apache License, Version 2.0 for the specific language
 * governing permissions and limitations under the License.
 */
package com.msopentech.odatajclient.engine.data.metadata.edm;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import java.io.IOException;

public class FunctionImportDeserializer extends JsonDeserializer<FunctionImport> {

    @Override
    public FunctionImport deserialize(final JsonParser jp, final DeserializationContext ctxt)
            throws IOException, JsonProcessingException {

        final FunctionImport funcImp = new FunctionImport();

        for (; jp.getCurrentToken() != JsonToken.END_OBJECT; jp.nextToken()) {
            final JsonToken token = jp.getCurrentToken();
            if (token == JsonToken.FIELD_NAME) {
                if ("Name".equals(jp.getCurrentName())) {
                    funcImp.setName(jp.nextTextValue());
                } else if ("ReturnType".equals(jp.getCurrentName())) {
                    funcImp.setReturnType(jp.nextTextValue());
                } else if ("EntitySet".equals(jp.getCurrentName())) {
                    funcImp.setEntitySet(jp.nextTextValue());
                } else if ("EntitySetPath".equals(jp.getCurrentName())) {
                    funcImp.setEntitySetPath(jp.nextTextValue());
                } else if ("IsComposable".equals(jp.getCurrentName())) {
                    funcImp.setComposable(Boolean.valueOf(jp.nextTextValue()));
                } else if ("IsSideEffecting".equals(jp.getCurrentName())) {
                    funcImp.setSideEffecting(Boolean.valueOf(jp.nextTextValue()));
                } else if ("IsBindable".equals(jp.getCurrentName())) {
                    funcImp.setBindable(Boolean.valueOf(jp.nextTextValue()));
                } else if ("IsAlwaysBindable".equals(jp.getCurrentName())) {
                    funcImp.setAlwaysBindable(Boolean.valueOf(jp.nextTextValue()));
                } else if ("HttpMethod".equals(jp.getCurrentName())) {
                    funcImp.setHttpMethod(jp.nextTextValue());
                } else if ("Parameter".equals(jp.getCurrentName())) {
                    jp.nextToken();
                    funcImp.getParameters().add(jp.getCodec().readValue(jp, Parameter.class));
                }
            }
        }

        return funcImp;
    }
}
