package com.shedhack.cloud.savannah.core.model;

import java.io.Serializable;
import java.util.List;

public interface ServiceInstanceDependency extends Serializable {

    // ---------
    // Unique ID
    // ---------
    String getId();

    void setId(String id);

    String getApiVersion();

    void setApiVersion(String apiVersion);

}
