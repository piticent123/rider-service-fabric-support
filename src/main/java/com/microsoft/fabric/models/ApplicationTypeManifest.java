package com.microsoft.fabric.models;

import com.azure.core.annotation.Fluent;
import com.fasterxml.jackson.annotation.JsonProperty;

/** Contains the manifest describing an application type registered in a Service Fabric cluster. */
@Fluent
public final class ApplicationTypeManifest {
    /*
     * The XML manifest as a string.
     */
    @JsonProperty(value = "Manifest")
    private String manifest;

    /**
     * Get the manifest property: The XML manifest as a string.
     *
     * @return the manifest value.
     */
    public String getManifest() {
        return this.manifest;
    }

    /**
     * Set the manifest property: The XML manifest as a string.
     *
     * @param manifest the manifest value to set.
     * @return the ApplicationTypeManifest object itself.
     */
    public ApplicationTypeManifest setManifest(String manifest) {
        this.manifest = manifest;
        return this;
    }
}
