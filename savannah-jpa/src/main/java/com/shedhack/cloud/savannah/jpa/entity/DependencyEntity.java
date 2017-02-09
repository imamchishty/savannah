package com.shedhack.cloud.savannah.jpa.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.shedhack.cloud.savannah.core.model.Dependency;
import com.shedhack.cloud.savannah.core.model.DependencyType;
import com.shedhack.cloud.savannah.core.model.ServiceInstance;

import javax.persistence.*;

@Entity
@Table(name = "service_instance_dependency")
public class DependencyEntity implements Dependency {

    @EmbeddedId
    private DependencyPK primaryKey;

    private String description;

    @Enumerated(EnumType.STRING)
    private DependencyType type;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "instance_id")
    private ServiceInstanceEntity instance;

    public void setPrimaryKey(DependencyPK primaryKey) {
        this.primaryKey = primaryKey;
    }

    public DependencyPK getPrimaryKey() {
        return this.primaryKey;
    }

    public void setVersion(String version) {
        this.primaryKey.setVersion(version);
    }

    public String getVersion() {
        return this.primaryKey.getVersion();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return this.primaryKey.getName();
    }

    public void setName(String name) {
        this.primaryKey.setName(name);
    }

    public DependencyType getType() {
        return type;
    }

    public void setType(DependencyType type) {
        this.type = type;
    }

    public ServiceInstance getInstance() {
        return instance;
    }

    public void setInstance(ServiceInstance instance) {
        this.instance = (ServiceInstanceEntity) instance;
    }

    @Override
    public String toString() {
        return "{\"DependencyEntity\":{"
                + ", \"pk\":\"" + primaryKey + "\""
                + ", \"description\":\"" + description + "\""
                + ", \"type\":\"" + type + "\""
                + ", \"instance\":" + instance
                + "}}";
    }
}

