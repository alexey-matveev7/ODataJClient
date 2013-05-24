/*
 * Copyright 2013 MS OpenTech.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.msopentech.odatajclient.engine.communication.request;

/**
 * Changeset wrapper for the corresponding batch item.
 * Get instance by using ODataRequestFactory.
 *
 * @see ODataRequestFactory#getChangesetRequest()
 */
public class ODataChangeset extends ODataBatchRequestItem {

    /**
     * Constructor.
     */
    ODataChangeset() {
    }

    /**
     * Add a create request to the changeset.
     *
     * @param request create request to be added.
     * @return the current updated changeset.
     */
    public ODataChangeset addRequest(final ODataCreateRequest request) {
        requests.add(request);
        return this;
    }

    /**
     * Add an update request to the changeset.
     *
     * @param request update request to be added.
     * @return the current updated changeset.
     */
    public ODataChangeset addRequest(final ODataUpdateRequest request) {
        requests.add(request);
        return this;
    }

    /**
     * Add a delete request to the changeset.
     *
     * @param request delete request to be added.
     * @return the current updated changeset.
     */
    public ODataChangeset addRequest(final ODataDeleteRequest request) {
        requests.add(request);
        return this;
    }
}