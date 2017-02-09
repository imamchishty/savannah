package com.shedhack.cloud.savannah.jpa.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.shedhack.cloud.savannah.core.model.Organisation;
import com.shedhack.cloud.savannah.core.model.Service;
import com.shedhack.cloud.savannah.core.model.ServiceInstance;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "service")
public class ServiceEntity implements Service {

    @Id
    private String name;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "organisation_id", nullable = false)
    private OrganisationEntity organisation;

    private String description;

    @OneToMany(mappedBy = "service")
    private Set<ServiceInstanceEntity> instances = new HashSet<>();

    // ---------------
    // Entity methods
    // ---------------

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<? extends ServiceInstance> getInstances() {
        return instances;
    }

    public void setInstances(Set<? extends ServiceInstance> instances) {
        this.instances = (Set<ServiceInstanceEntity>) instances;
    }

    public void addInstance(ServiceInstance instance) {
        this.instances.add((ServiceInstanceEntity) instance);
    }

    public void removeInstance(ServiceInstance instance) {
        this.instances.remove(instance);
    }

    public void setOrganisation(Organisation organisation) {
        this.organisation = (OrganisationEntity) organisation;
    }

    public Organisation getOrganisation() {
        return organisation;
    }

    @Override
    public String toString() {
        return "{\"ServiceEntity\":{"
                + ", \"name\":\"" + name + "\""
                + ", \"description\":\"" + description + "\""
                + ", \"instances\":" + instances
                + "}}";
    }
}
