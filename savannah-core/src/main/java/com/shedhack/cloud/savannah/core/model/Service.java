package com.shedhack.cloud.savannah.core.model;

import java.io.Serializable;
import java.util.List;

public interface Service extends Serializable {

    // ---------
    // Unique ID
    // ---------
    String getId();

    Organisation getOrganisation();

    void setOrganisation(Organisation model);

    String getName();

    void setName(String name);

    String getTeam();

    void setTeam(String team);

    String getDescription();

    void setDescription(String description);
    
    String getScm();

    void setScm(String scm);

    List<? extends ServiceInstance> getInstances();

    void setInstances(List<? extends ServiceInstance> instances);

    void addInstance(ServiceInstance instance);
}