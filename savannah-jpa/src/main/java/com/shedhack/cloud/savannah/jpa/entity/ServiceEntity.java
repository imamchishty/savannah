package com.shedhack.cloud.savannah.jpa.entity;

import com.shedhack.cloud.savannah.core.model.Organisation;
import com.shedhack.cloud.savannah.core.model.Service;
import com.shedhack.cloud.savannah.core.model.ServiceInstance;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "service")
public class ServiceEntity implements Service {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    private String id;

    @ManyToOne
    @JoinColumn(name = "organisation_id")
    private OrganisationEntity organisation;

    private String name;

    private String team;

    private String description;

    private String scm;

    @OneToMany(mappedBy = "service")
    private List<ServiceInstanceEntity> instances;

    public String getId() {
        return id;
    }

    public Organisation getOrganisation() {
        return organisation;
    }

    public void setOrganisation(Organisation organisation) {
        this.organisation = (OrganisationEntity) organisation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getScm() {
        return scm;
    }

    public void setScm(String scm) {
        this.scm = scm;
    }

    public List<ServiceInstanceEntity> getInstances() {
        return instances;
    }

    public void setInstances(List<? extends ServiceInstance> instances) {
        this.instances = (List<ServiceInstanceEntity>) instances;
    }

    public void addInstance(ServiceInstance instance) {
        this.instances.add((ServiceInstanceEntity) instance);
    }

}
