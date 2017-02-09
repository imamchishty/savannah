package com.shedhack.cloud.savannah.core.model.def;

import com.shedhack.cloud.savannah.core.model.Api;

public class DefaultApi implements Api {

    public DefaultApi(){}

    public DefaultApi(String id, String apiVersion, String description) {
        this.id = id;
        this.version = apiVersion;
        this.description = description;
    }

    // -------------
    // Class members
    // -------------

    private String id, version, description;

    public void setVersion(String version) {
        this.version = version;
    }

    public String getVersion() {
        return version;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
