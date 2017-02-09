package com.shedhack.cloud.savannah.core.model.def;

import com.shedhack.cloud.savannah.core.model.Profile;

public class DefaultProfile implements Profile {

    public DefaultProfile() {
    }

    public DefaultProfile(String name, String description) {
        this.name = name;
        this.description = description;
    }

    private String name, description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
