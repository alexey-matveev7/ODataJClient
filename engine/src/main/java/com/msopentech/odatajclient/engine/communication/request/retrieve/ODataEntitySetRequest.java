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
package com.msopentech.odatajclient.engine.communication.request.retrieve;

import com.msopentech.odatajclient.engine.communication.response.ODataRetrieveResponse;
import com.msopentech.odatajclient.engine.data.ODataEntitySet;
import com.msopentech.odatajclient.engine.data.ODataReader;
import com.msopentech.odatajclient.engine.format.ODataPubFormat;
import java.net.URI;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;

/**
 * This class implements an OData EntitySet query request.
 * Get instance by using ODataRetrieveRequestFactory.
 *
 * @see ODataRetrieveRequestFactory#getEntitySetRequest(java.net.URI)
 */
public class ODataEntitySetRequest extends ODataRetrieveRequest<ODataEntitySet, ODataPubFormat> {

    private ODataEntitySet feed = null;

    /**
     * Private constructor.
     *
     * @param query query to be executed.
     */
    ODataEntitySetRequest(final URI query) {
        super(ODataPubFormat.class, query);
    }

    /**
     * {@inheritDoc }
     */
    @Override
    public ODataRetrieveResponse<ODataEntitySet> execute() {
        final HttpResponse res = doExecute();
        return new ODataEntitySetResponseImpl(client, res);
    }

    /**
     * Response class about an ODataEntitySetRequest.
     */
    protected class ODataEntitySetResponseImpl extends ODataRetrieveResponseImpl {

        /**
         * Constructor.
         * <p>
         * Just to create response templates to be initialized from batch.
         */
        private ODataEntitySetResponseImpl() {
        }

        /**
         * Constructor.
         *
         * @param client HTTP client.
         * @param res HTTP response.
         */
        private ODataEntitySetResponseImpl(final HttpClient client, final HttpResponse res) {
            super(client, res);
        }

        /**
         * {@inheritDoc }
         */
        @Override
        @SuppressWarnings("unchecked")
        public ODataEntitySet getBody() {
            if (feed == null) {
                try {
                    feed = ODataReader.readEntitySet(getRawResponse(), ODataPubFormat.fromString(getContentType()));
                } finally {
                    this.close();
                }
            }
            return feed;
        }
    }
}
