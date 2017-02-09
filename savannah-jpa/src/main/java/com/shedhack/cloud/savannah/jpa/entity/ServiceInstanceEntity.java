package com.shedhack.cloud.savannah.jpa.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.shedhack.cloud.savannah.core.model.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "service_instance")
public class ServiceInstanceEntity implements ServiceInstance {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    private String id;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "service_id", nullable = false)
    private ServiceEntity service;

    @OneToMany(mappedBy = "instance")
    private Set<ApiEntity> apiVersions = new HashSet<>();

    @OneToMany(mappedBy = "instance")
    private Set<DependencyEntity> dependencies = new HashSet<>();

    @Column(name = "container_image")
    private String containerImage;

    private String version, url;

    @ManyToOne
    @JoinColumn(name = "profile_id")
    private ProfileEntity profile;

    @Column(name = "date_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateTime;

    @Column(name = "build_number")
    private String buildNo;

    @Column(name = "build_job")
    private String buildJob;

    // ---------------
    // Entity methods
    // ---------------

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Set<? extends Api> getApis() {
        return apiVersions;
    }

    public void setApis(Set<? extends Api> apiVersions) {
        this.apiVersions = (Set<ApiEntity>) apiVersions;
    }

    public void addApi(Api apiVersion) {
        this.apiVersions.add((ApiEntity) apiVersion);
    }

    public String getArtifactVersion() {
        return version;
    }

    public void setArtifactVersion(String version) {
        this.version = version;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date date) {
        this.dateTime = date;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = (ProfileEntity) profile;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getContainerImage() {
        return containerImage;
    }

    public void setContainerImage(String containerImage) {
        this.containerImage = containerImage;
    }

    public String getBuildJob() {
        return this.buildJob;
    }

    public void setBuildJob(String ci) {
        this.buildJob = ci;
    }

    public String getBuildNo() {
        return this.buildNo;
    }

    public void setBuildNo(String ci) {
        this.buildNo = ci;
    }

    public Set<? extends DependencyEntity> getDependencies() {
        return dependencies;
    }

    public void setDependencies(Set<? extends Dependency> dependencies) {
        this.dependencies = (Set<DependencyEntity>) dependencies;
    }

    public void addDependency(Dependency dependency) {
        this.dependencies.add((DependencyEntity) dependency);
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = (ServiceEntity) service;
    }

    @Override
    public String toString() {
        return "{\"ServiceInstanceEntity\":{"
                + "\"id\":\"" + id + "\""
                + ", \"apiVersions\":" + apiVersions
                + ", \"dependencies\":" + dependencies
                + ", \"containerImage\":\"" + containerImage + "\""
                + ", \"version\":\"" + version + "\""
                + ", \"url\":\"" + url + "\""
                + ", \"profile\":" + profile
                + ", \"dateTime\":" + dateTime
                + ", \"buildNo\":\"" + buildNo + "\""
                + ", \"buildJob\":\"" + buildJob + "\""
                + "}}";
    }
}
