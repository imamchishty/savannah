package com.shedhack.cloud.savannah.jpa.entity;

import com.shedhack.cloud.savannah.core.model.Organisation;
import com.shedhack.cloud.savannah.core.model.Service;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "organisation")
public class OrganisationEntity implements Organisation {

    // ----------------------------
    // Private fields + constructor
    // ----------------------------

    @Id
    private String name;

    private String description;

    @OneToMany(mappedBy = "organisation", fetch = FetchType.LAZY)
    private Set<ServiceEntity> services = new HashSet<>();

    // ---------------
    // Entity methods
    // ---------------

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

    public Set<? extends Service> getServices() {
        return services;
    }

    public void addService(Service service) {
        this.services.add((ServiceEntity) service);
    }

    public void removeService(Service service) {
        this.services.remove(service);
    }

    @Override
    public String toString() {
        return "{\"OrganisationEntity\":{"
                + ", \"name\":\"" + name + "\""
                + ", \"description\":\"" + description + "\""
                + ", \"services\":" + services
                + "}}";
    }
}