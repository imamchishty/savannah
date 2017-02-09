package com.shedhack.cloud.savannah.core.model;

import java.io.Serializable;

public interface Profile extends Serializable {

    String getName();

    void setName(String name);

    String getDescription();

    void setDescription(String description);

}
