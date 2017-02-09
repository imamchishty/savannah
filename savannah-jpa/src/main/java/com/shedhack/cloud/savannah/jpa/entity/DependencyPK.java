package com.shedhack.cloud.savannah.jpa.entity;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class DependencyPK implements Serializable {

    private String name;

    private String version;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "{\"DependencyPK\":{"
                + "\"name\":\"" + name + "\""
                + ", \"version\":\"" + version + "\""
                + "}}";
    }
}
