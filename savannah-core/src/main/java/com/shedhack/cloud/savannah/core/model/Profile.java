package com.shedhack.cloud.savannah.core.model;

import java.io.Serializable;

public interface Profile extends Serializable {

    // ---------
    // Unique ID
    // ---------
    String getId();

    Organisation getOrganisation();

    void setOrganisation(Organisation model);

    String getName();

    void setName(String name);

    String getDescription();

    void setDescription(String description);

}