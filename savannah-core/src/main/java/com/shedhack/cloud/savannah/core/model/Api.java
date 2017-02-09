package com.shedhack.cloud.savannah.core.model;

import java.io.Serializable;

public interface Api extends Serializable {

    // -------------
    // Field methods
    //--------------

    String getId();

    void setId(String id);

    void setVersion(String version);

    String getVersion();

    String getDescription();

    void setDescription(String description);

}
