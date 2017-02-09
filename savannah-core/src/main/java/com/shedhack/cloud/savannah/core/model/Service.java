package com.shedhack.cloud.savannah.core.model;

import java.io.Serializable;
import java.util.Set;
import java.util.Map;

public interface Service extends Serializable {

    // -------------
    // Field methods
    //--------------

    String getDescription();

    String getName();

    void setName(String name);

    void setDescription(String description);

    // ------------------------
    // Service Instance methods
    //-------------------------

    Set<? extends ServiceInstance> getInstances();

    void setInstances(Set<? extends ServiceInstance> instances);

    void addInstance(ServiceInstance instance);

    void removeInstance(ServiceInstance instance);

}