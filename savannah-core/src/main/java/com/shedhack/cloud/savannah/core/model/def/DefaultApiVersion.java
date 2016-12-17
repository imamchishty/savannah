package com.shedhack.cloud.savannah.core.model.def;

import com.shedhack.cloud.savannah.core.model.ApiVersion;

public class DefaultApiVersion implements ApiVersion {

    public DefaultApiVersion(){}

    public DefaultApiVersion(String apiVersion, String description) {
        this.apiVersion = apiVersion;
        this.description = description;
    }

    // -------------
    // Class members
    // -------------

    private String apiVersion, description;

    public void setApiVersion(String version) {
        this.apiVersion = version;
    }

    public String getApiVersion() {
        return apiVersion;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DefaultApiVersion that = (DefaultApiVersion) o;

        if (apiVersion != null ? !apiVersion.equals(that.apiVersion) : that.apiVersion != null) return false;
        return description != null ? description.equals(that.description) : that.description == null;

    }

    @Override
    public int hashCode() {
        int result = apiVersion != null ? apiVersion.hashCode() : 0;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "{\"DefaultApiVersion\":{"
                + "\"apiVersion\":\"" + apiVersion + "\""
                + ", \"description\":\"" + description + "\""
                + "}}";
    }
}
