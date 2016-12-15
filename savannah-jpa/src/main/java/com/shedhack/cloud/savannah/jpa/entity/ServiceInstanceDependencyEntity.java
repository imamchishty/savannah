package com.shedhack.cloud.savannah.jpa.entity;

import com.shedhack.cloud.savannah.core.model.ApiVersion;
import com.shedhack.cloud.savannah.core.model.ServiceInstance;
import com.shedhack.cloud.savannah.core.model.ServiceInstanceDependency;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "service_instance_dependency")
public class ServiceInstanceDependencyEntity implements ServiceInstanceDependency {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    private String id;

    @ManyToOne
    @JoinColumn(name = "instance_id")
    private ServiceInstanceEntity instance;

    private String name;

    @OneToOne
    @JoinColumn(name="api_version_id")
    private ApiVersionEntity apiVersion;

    public String getId() {
        return id;
    }

    public ServiceInstance getServiceInstance() {
        return instance;
    }

    public void setServiceInstance(ServiceInstance instance) {
        this.instance = (ServiceInstanceEntity) instance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ApiVersion getApiVersion() {
        return apiVersion;
    }

    public void setApiVersion(ApiVersion apiVersion) {
        this.apiVersion = (ApiVersionEntity) apiVersion;
    }

}
