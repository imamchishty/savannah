package com.shedhack.cloud.savannah.jpa.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.shedhack.cloud.savannah.core.model.Api;
import com.shedhack.cloud.savannah.core.model.ServiceInstance;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "service_instance_api")
public class ApiEntity implements Api {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    private String id;

    private String version;

    private String description;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "instance_id")
    private ServiceInstanceEntity instance;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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

    public ServiceInstance getInstance() {
        return instance;
    }

    public void setInstance(ServiceInstance instance) {
        this.instance = (ServiceInstanceEntity) instance;
    }

    @Override
    public String toString() {
        return "{\"ApiEntity\":{"
                + "\"id\":\"" + id + "\""
                + ", \"version\":\"" + version + "\""
                + ", \"description\":\"" + description + "\""
                + "}}";
    }
}
