package com.shedhack.cloud.savannah.core.model;

import java.io.Serializable;

public interface Dependency extends Serializable {

    // -------------
    // Field methods
    //--------------

    String getName();

    void setName(String name);

    void setVersion(String version);

    String getVersion();

    String getDescription();

    void setDescription(String description);

    DependencyType getType();

    void setType(DependencyType type);

}
