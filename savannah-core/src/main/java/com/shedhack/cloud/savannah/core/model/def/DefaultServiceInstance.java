package com.shedhack.cloud.savannah.core.model.def;

import com.shedhack.cloud.savannah.core.model.Api;
import com.shedhack.cloud.savannah.core.model.Dependency;
import com.shedhack.cloud.savannah.core.model.Profile;
import com.shedhack.cloud.savannah.core.model.ServiceInstance;

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

        public Builder withApiVersions(Set<Api> versions) {
            instance.setApis(versions);
            return this;
        }

        public Builder withApi(Api version) {
            instance.addApi(version);
            return this;
        }

        public Builder withDependencies(Set<Dependency> dependencies) {
            instance.setDependencies(dependencies);
            return this;
        }

        public Builder withDependency(Dependency dependency) {
            instance.addDependency(dependency);
            return this;
        }

        public Builder withContainerImage(String image) {
            instance.setContainerImage(image);
            return this;
        }

        public Builder withArtifactVersion(String version) {
            instance.setArtifactVersion(version);
            return this;
        }

        public Builder withUrl(String url) {
            instance.setUrl(url);
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

        public Builder withBuildJob(String job) {
            instance.buildJob = job;
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

    private Set<Api> apis = new HashSet<>();

    private Set<Dependency> dependencies = new HashSet<>();

    private String containerImage;

    private String artifactVersion, url;

    private Profile profile;

    private Date dateTime;

    private String buildJob, buildNo;

    // --------------
    // Public Methods
    // --------------

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Set<Api> getApis() {
        return apis;
    }

    public void setApis(Set<? extends Api> apiVersions) {
        this.apis = (Set<Api>) apiVersions;
    }

    public void addApi(Api apiVersion) {
        this.apis.add(apiVersion);
    }

    public Set<? extends Dependency> getDependencies() {
        return dependencies;
    }

    public void setDependencies(Set<? extends Dependency> dependencies) {
        this.dependencies = (Set<Dependency>) dependencies;
    }

    public void addDependency(Dependency dependency) {
        this.dependencies.add(dependency);
    }

    public String getArtifactVersion() {
        return artifactVersion;
    }

    public void setArtifactVersion(String version) {
        this.artifactVersion = version;
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

}
