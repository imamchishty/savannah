package com.shedhack.cloud.savannah.jpa.entity;

import com.shedhack.cloud.savannah.core.model.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "service_instance")
public class ServiceInstanceEntity implements ServiceInstance {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    private String id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "service_id")
    private ServiceEntity service;

    @OneToMany(mappedBy = "instance")
    private List<ApiVersionEntity> apiVersions;

    @OneToMany(mappedBy = "instance")
    private List<ServiceInstanceDependencyEntity> dependencies;

    @Column(name = "scm_revision")
    private String scmRevision;

    @Column(name = "container_image")
    private String containerImage;

    private String version, status, executor, host;

    @ManyToOne
    @JoinColumn(name = "profile_id")
    private ProfileEntity profile;

    @Column(name = "date_time")
    private Date dateTime;

    private int port;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = (ServiceEntity) service;
    }

    public List<ApiVersionEntity> getApiVersions() {
        return apiVersions;
    }

    public void setApiVersions(List<? extends ApiVersion> apiVersions) {
        this.apiVersions = (List<ApiVersionEntity>) apiVersions;
    }

    public List<ServiceInstanceDependencyEntity> getDependencies() {
        return dependencies;
    }

    public void setDependencies(List<? extends ServiceInstanceDependency> dependencies) {
        this.dependencies = (List<ServiceInstanceDependencyEntity>) dependencies;
    }

    public void addDependency(ServiceInstanceDependency dependency) {
        this.dependencies.add((ServiceInstanceDependencyEntity) dependency);
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getScmRevision() {
        return scmRevision;
    }

    public void setScmRevision(String scmRevision) {
        this.scmRevision = scmRevision;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getExecutor() {
        return executor;
    }

    public void setExecutor(String executor) {
        this.executor = executor;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getContainerImage() {
        return containerImage;
    }

    public void setContainerImage(String containerImage) {
        this.containerImage = containerImage;
    }

}
