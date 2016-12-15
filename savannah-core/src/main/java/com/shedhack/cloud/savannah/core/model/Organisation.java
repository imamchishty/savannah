package com.shedhack.cloud.savannah.core.model;

import java.io.Serializable;
import java.util.List;


public interface Organisation extends Serializable {

    // ---------
    // Unique ID
    // ---------
    String getId();

    // -------------
    // Field methods
    //--------------

    String getName();

    void setName(String name);

    String getDescription();

    void setDescription(String name);

    // ---------------
    // Service methods
    // ---------------

    List<? extends Service> getServices();

    void addService(Service service);

    void removeService(String service);

    // ---------------
    // Profile methods
    // ---------------

    List<? extends Profile> getProfiles();

    void addProfile(Profile profile);

    void removeProfile(String profile);

}
