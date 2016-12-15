package com.shedhack.cloud.savannah.jpa.entity;

import com.shedhack.cloud.savannah.core.model.Organisation;
import com.shedhack.cloud.savannah.core.model.Profile;
import com.shedhack.cloud.savannah.core.model.Service;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "organisation")
public class OrganisationEntity implements Organisation {

    // ----------------------------
    // Private fields + constructor
    // ----------------------------

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    private String id;

    private String name;

    private String description;

    @OneToMany(mappedBy = "organisation", fetch = FetchType.LAZY)
    private List<ServiceEntity> services = new ArrayList<>();

    @OneToMany(mappedBy = "organisation", fetch = FetchType.EAGER)
    private List<ProfileEntity> profiles = new ArrayList<>();

    // ---------------
    // Service methods
    // ---------------

    public List<ServiceEntity> getServices() {
        return services;
    }

    public void addService(Service service) {

        // verify
        services.add((ServiceEntity)service);
    }

    public void removeService(String service) {
        services.remove(service);
    }

    // ---------------
    // Profile methods
    // ---------------

    public List<ProfileEntity> getProfiles() {
        return profiles;
    }

    public void addProfile(Profile profile) {
        profiles.add((ProfileEntity) profile);
    }

    public void removeProfile(String profile) {
        profiles.remove(profile);
    }

    // -------------
    // Field methods
    // -------------

    public String getId() {
        return id;
    }

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