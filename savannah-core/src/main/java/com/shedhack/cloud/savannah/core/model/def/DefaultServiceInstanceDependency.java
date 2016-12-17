package com.shedhack.cloud.savannah.core.model.def;

import com.shedhack.cloud.savannah.core.model.ServiceInstanceDependency;

public class DefaultServiceInstanceDependency implements ServiceInstanceDependency {

    public DefaultServiceInstanceDependency(String id, String apiVersion) {
        this.apiVersion = apiVersion;
        this.id = id;
    }

    public DefaultServiceInstanceDependency(){}

    private String id;

    private String apiVersion;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getApiVersion() {
        return apiVersion;
    }

    public void setApiVersion(String apiVersion) {
        this.apiVersion = apiVersion;
    }
}
