package com.shedhack.cloud.savannah.core.model.def;

import com.shedhack.cloud.savannah.core.model.Dependency;
import com.shedhack.cloud.savannah.core.model.DependencyType;

public class DefaultDependency implements Dependency {

    public DefaultDependency(){}

    public DefaultDependency(String name, String version, String description, DependencyType type) {
        this.name = name;
        this.version = version;
        this.description = description;
        this.type = type;
    }

    // -------------
    // Class members
    // -------------

    private String name, version, description;

    private DependencyType type;

    public void setVersion(String version) {
        this.version = version;
    }

    public String getVersion() {
        return version;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DependencyType getType() {
        return type;
    }

    public void setType(DependencyType type) {
        this.type = type;
    }

}
