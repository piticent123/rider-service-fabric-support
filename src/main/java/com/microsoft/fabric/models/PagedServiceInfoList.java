package com.microsoft.fabric.models;

import com.azure.core.annotation.Fluent;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/**
 * The list of services in the cluster for an application. The list is paged when all of the results cannot fit in a
 * single message. The next set of results can be obtained by executing the same query with the continuation token
 * provided in this list.
 */
@Fluent
public final class PagedServiceInfoList {
    /*
     * The continuation token parameter is used to obtain next set of results.
     * The continuation token is included in the response of the API when the
     * results from the system do not fit in a single response. When this value
     * is passed to the next API call, the API returns next set of results. If
     * there are no further results, then the continuation token is not
     * included in the response.
     */
    @JsonProperty(value = "ContinuationToken")
    private String continuationToken;

    /*
     * List of service information.
     */
    @JsonProperty(value = "Items")
    private List<ServiceInfo> items;

    /**
     * Get the continuationToken property: The continuation token parameter is used to obtain next set of results. The
     * continuation token is included in the response of the API when the results from the system do not fit in a single
     * response. When this value is passed to the next API call, the API returns next set of results. If there are no
     * further results, then the continuation token is not included in the response.
     *
     * @return the continuationToken value.
     */
    public String getContinuationToken() {
        return this.continuationToken;
    }

    /**
     * Set the continuationToken property: The continuation token parameter is used to obtain next set of results. The
     * continuation token is included in the response of the API when the results from the system do not fit in a single
     * response. When this value is passed to the next API call, the API returns next set of results. If there are no
     * further results, then the continuation token is not included in the response.
     *
     * @param continuationToken the continuationToken value to set.
     * @return the PagedServiceInfoList object itself.
     */
    public PagedServiceInfoList setContinuationToken(String continuationToken) {
        this.continuationToken = continuationToken;
        return this;
    }

    /**
     * Get the items property: List of service information.
     *
     * @return the items value.
     */
    public List<ServiceInfo> getItems() {
        return this.items;
    }

    /**
     * Set the items property: List of service information.
     *
     * @param items the items value to set.
     * @return the PagedServiceInfoList object itself.
     */
    public PagedServiceInfoList setItems(List<ServiceInfo> items) {
        this.items = items;
        return this;
    }
}
