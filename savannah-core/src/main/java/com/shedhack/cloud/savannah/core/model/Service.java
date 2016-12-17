package com.shedhack.cloud.savannah.core.model;

import java.io.Serializable;
import java.util.Set;
import java.util.Map;

public interface Service extends Serializable {

    // ---------
    // Unique ID
    // ---------
    String getId();

    void setId(String id);

    String getTeam();

    void setTeam(String team);

    String getDescription();

    void setDescription(String description);
    
    String getScm();

    void setScm(String scm);

    Set<ServiceInstance> getInstances();

    void setInstances(Set<ServiceInstance> instances);

    void addInstance(ServiceInstance instance);

    void removeInstance(ServiceInstance instance);

    void setMetadata(Map<String, Object> map);

    void addMetadata(String key, Object value);

    Map<String, Object> getMetadata();
}