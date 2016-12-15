package com.shedhack.cloud.savannah.core.model;

public interface ApiVersion {

    String getId();

    void setApiVersion(String version);

    String getApiVersion();

    String getDescription();

    void setDescription(String description);

    ServiceInstance getInstance();

    void setInstance(ServiceInstance instance);

}
