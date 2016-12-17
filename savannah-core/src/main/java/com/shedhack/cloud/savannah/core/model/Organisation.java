package com.shedhack.cloud.savannah.core.model;

import java.io.Serializable;
import java.util.Set;


public interface Organisation extends Serializable {

    String getId();

    void setId(String id);

    // -------------
    // Field methods
    //--------------

    String getDescription();

    void setDescription(String description);

    // ---------------
    // Service methods
    // ---------------

    Set<Service> getServices();

    void addService(Service service);

    void removeService(Service service);

    // ---------------
    // Profile methods
    // ---------------

    Set<Profile> getProfiles();

    void addProfile(Profile profile);

    void removeProfile(Profile profile);

}
