package com.shedhack.cloud.savannah.jpa.entity;

import com.shedhack.cloud.savannah.core.model.ApiVersion;
import com.shedhack.cloud.savannah.core.model.ServiceInstance;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "api_version")
public class ApiVersionEntity implements ApiVersion {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    private String id;

    private String version;

    private String description;

    @ManyToOne
    @JoinColumn(name = "instance_id")
    private ServiceInstanceEntity instance;

    public String getId() {
        return id;
    }

    public void setApiVersion(String version) {
        this.version = version;
    }

    public String getApiVersion() {
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

}
