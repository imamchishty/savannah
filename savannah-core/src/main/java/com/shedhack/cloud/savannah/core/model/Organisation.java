package com.shedhack.cloud.savannah.core.model;

import java.io.Serializable;
import java.util.Set;


public interface Organisation extends Serializable {

    // -------------
    // Field methods
    //--------------

    String getName();

    void setName(String name);

    String getDescription();

    void setDescription(String description);

    // ---------------
    // Service methods
    // ---------------

    Set<? extends Service> getServices();

    void addService(Service service);

    void removeService(Service service);

}
