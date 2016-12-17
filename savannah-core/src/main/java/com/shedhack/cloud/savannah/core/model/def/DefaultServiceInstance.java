package com.shedhack.cloud.savannah.core.model.def;

import com.shedhack.cloud.savannah.core.model.ApiVersion;
import com.shedhack.cloud.savannah.core.model.Profile;
import com.shedhack.cloud.savannah.core.model.ServiceInstance;
import com.shedhack.cloud.savannah.core.model.ServiceInstanceDependency;

import java.util.*;

public class DefaultServiceInstance implements ServiceInstance {

    // -------
    // Builder
    // -------

    public static class Builder {

        private DefaultServiceInstance instance;

        public Builder(String id) {

            instance = new DefaultServiceInstance();
            instance.id = id;
        }

        public Builder withApiVersions(Set<ApiVersion> versions) {
            instance.setApiVersions(versions);
            return this;
        }

        public Builder withApiVersion(ApiVersion version) {
            instance.addApiVersion(version);
            return this;
        }

        public Builder withDependencies(Set<ServiceInstanceDependency> dependencies) {
            instance.setDependencies(dependencies);
            return this;
        }

        public Builder withDependency(ServiceInstanceDependency dependency) {
            instance.addDependency(dependency);
            return this;
        }

        public Builder withScmRevision(String scmRevision) {
            instance.setScmRevision(scmRevision);
            return this;
        }

        public Builder withContainerImage(String image) {
            instance.setContainerImage(image);
            return this;
        }

        public Builder withVersion(String version) {
            instance.setVersion(version);
            return this;
        }

        public Builder withStatus(String status) {
            instance.setStatus(status);
            return this;
        }

        public Builder withExecutor(String executor) {
            instance.setExecutor(executor);
            return this;
        }

        public Builder withHost(String host) {
            instance.setHost(host);
            return this;
        }

        public Builder withProfile(Profile profile) {
            instance.setProfile(profile);
            return this;
        }

        public Builder withDateTime(Date dateTime) {
            instance.setDateTime(dateTime);
            return this;
        }

        public Builder withPort(int port) {
            instance.setPort(port);
            return this;
        }

        public Builder withBuildJob(String job) {
            instance.buildJob = job;
            return this;
        }

        public Builder withMetadata(String key, Object value) {
            instance.metadata.put(key, value);
            return this;
        }

        public Builder withMetadata(Map<String, Object> map) {
            instance.metadata = map;
            return this;
        }

        public Builder withBuildNo(String no) {
            instance.buildNo = no;
            return this;
        }

        public ServiceInstance build() {
            return instance;
        }
    }

    // ----------------
    // Static method
    // ----------------

    public static Builder builder(String id) {
        return new Builder(id);
    }

    // ---------------
    // Private members
    // ---------------

    private String id;

    private Set<ApiVersion> apiVersions = new HashSet<>();

    private Set<ServiceInstanceDependency> dependencies = new HashSet<>();

    private String scmRevision;

    private String containerImage;

    private String version, status, executor, host;

    private Profile profile;

    private Date dateTime;

    private int port;

    private String buildJob, buildNo;

    private Map<String, Object> metadata = new HashMap<>();

    // --------------
    // Public Methods
    // --------------

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Set<ApiVersion> getApiVersions() {
        return apiVersions;
    }

    public void setApiVersions(Set<ApiVersion> apiVersions) {
        this.apiVersions = apiVersions;
    }

    public void addApiVersion(ApiVersion apiVersion) {
        this.apiVersions.add(apiVersion);
    }

    public Set<ServiceInstanceDependency> getDependencies() {
        return dependencies;
    }

    public void setDependencies(Set<ServiceInstanceDependency> dependencies) {
        this.dependencies = dependencies;
    }

    public void addDependency(ServiceInstanceDependency dependency) {
        this.dependencies.add(dependency);
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

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
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

    public String getBuildJob() {
        return buildJob;
    }

    public void setBuildJob(String ci) {
        this.buildJob = ci;
    }

    public String getBuildNo() {
        return buildNo;
    }

    public void setBuildNo(String ci) {
        this.buildNo = ci;
    }

    public void setMetadata(Map<String, Object> map) {
        this.metadata = map;
    }

    public void addMetadata(String key, Object value) {
        this.metadata.put(key, value);
    }

    public Map<String, Object> getMetadata() {
        return metadata;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DefaultServiceInstance that = (DefaultServiceInstance) o;

        if (port != that.port) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (apiVersions != null ? !apiVersions.equals(that.apiVersions) : that.apiVersions != null) return false;
        if (dependencies != null ? !dependencies.equals(that.dependencies) : that.dependencies != null) return false;
        if (scmRevision != null ? !scmRevision.equals(that.scmRevision) : that.scmRevision != null) return false;
        if (containerImage != null ? !containerImage.equals(that.containerImage) : that.containerImage != null)
            return false;
        if (version != null ? !version.equals(that.version) : that.version != null) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;
        if (executor != null ? !executor.equals(that.executor) : that.executor != null) return false;
        if (host != null ? !host.equals(that.host) : that.host != null) return false;
        if (profile != null ? !profile.equals(that.profile) : that.profile != null) return false;
        if (dateTime != null ? !dateTime.equals(that.dateTime) : that.dateTime != null) return false;
        if (buildJob != null ? !buildJob.equals(that.buildJob) : that.buildJob != null) return false;
        if (buildNo != null ? !buildNo.equals(that.buildNo) : that.buildNo != null) return false;
        return metadata != null ? metadata.equals(that.metadata) : that.metadata == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (apiVersions != null ? apiVersions.hashCode() : 0);
        result = 31 * result + (dependencies != null ? dependencies.hashCode() : 0);
        result = 31 * result + (scmRevision != null ? scmRevision.hashCode() : 0);
        result = 31 * result + (containerImage != null ? containerImage.hashCode() : 0);
        result = 31 * result + (version != null ? version.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (executor != null ? executor.hashCode() : 0);
        result = 31 * result + (host != null ? host.hashCode() : 0);
        result = 31 * result + (profile != null ? profile.hashCode() : 0);
        result = 31 * result + (dateTime != null ? dateTime.hashCode() : 0);
        result = 31 * result + port;
        result = 31 * result + (buildJob != null ? buildJob.hashCode() : 0);
        result = 31 * result + (buildNo != null ? buildNo.hashCode() : 0);
        result = 31 * result + (metadata != null ? metadata.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "{\"DefaultServiceInstance\":{"
                + "\"id\":\"" + id + "\""
                + ", \"apiVersions\":" + apiVersions
                + ", \"dependencies\":" + dependencies
                + ", \"scmRevision\":\"" + scmRevision + "\""
                + ", \"containerImage\":\"" + containerImage + "\""
                + ", \"version\":\"" + version + "\""
                + ", \"status\":\"" + status + "\""
                + ", \"executor\":\"" + executor + "\""
                + ", \"host\":\"" + host + "\""
                + ", \"profile\":" + profile
                + ", \"dateTime\":" + dateTime
                + ", \"port\":\"" + port + "\""
                + ", \"buildJob\":\"" + buildJob + "\""
                + ", \"buildNo\":\"" + buildNo + "\""
                + ", \"metadata\":" + metadata
                + "}}";
    }
}
