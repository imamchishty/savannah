package com.shedhack.cloud.savannah.core.model;

import java.io.Serializable;

public interface Profile extends Serializable {

    // ---------
    // Unique ID
    // ---------
    String getId();

    void setId(String id);

    String getDescription();

    void setDescription(String description);

}
