package com.shedhack.cloud.savannah.core.model;

import java.io.Serializable;
import java.util.List;

public interface ServiceInstanceDependency extends Serializable {

    // ---------
    // Unique ID
    // ---------
    String getId();

    ServiceInstance getServiceInstance();

    void setServiceInstance(ServiceInstance serviceInstance);

    String getName();

    void setName(String name);

    ApiVersion getApiVersion();

    void setApiVersion(ApiVersion apiVersion);

}
