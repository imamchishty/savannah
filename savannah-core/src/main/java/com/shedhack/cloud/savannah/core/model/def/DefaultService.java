package com.shedhack.cloud.savannah.core.model.def;

import com.shedhack.cloud.savannah.core.model.Service;
import com.shedhack.cloud.savannah.core.model.ServiceInstance;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.Map;

public class DefaultService implements Service {

    // -------
    // Builder
    // -------

    public static class Builder {

        private DefaultService service;

        public Builder(String id, String description) {

            service = new DefaultService();
            service.setId(id);
            service.setDescription(description);
        }

        public Builder withTeam(String team) {
            service.team = team;
            return this;
        }

        public Builder withScm(String scm) {
            service.scm = scm;
            return this;
        }

        public Builder withInstances(Set<ServiceInstance> instances) {
            service.instances = instances;
            return this;
        }

        public Builder withInstance(ServiceInstance instance) {
            service.instances.add(instance);
            return this;
        }

        public Builder withMetadata(String key, Object value) {
            service.metadata.put(key, value);
            return this;
        }

        public Builder withMetadata(Map<String, Object> map) {
            service.metadata = map;
            return this;
        }

        public Service build() {
            return service;
        }

    }

    // ----------------
    // Static method
    // ----------------

    public static Builder builder(String id, String description) {
        return new Builder(id, description);
    }

    // ---------------
    // Private members
    // ---------------

    private String id;

    private String team;

    private String description;

    private String scm;

    private Set<ServiceInstance> instances = new HashSet<>();

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

    public Set<ServiceInstance> getInstances() {
        return instances;
    }

    public void setInstances(Set<ServiceInstance> instances) {
        this.instances = instances;
    }

    public void addInstance(ServiceInstance instance) {

        // if it already exists then thrown an error
        if(this.instances.contains(instance)) {
            throw new IllegalStateException("Instance already exists. You must update/remove existing one.");
        }

        System.out.println("exists?--->" + this.instances.contains(instance));

        this.instances.add(instance);
    }

    public void removeInstance(ServiceInstance instance) {
        this.instances.remove(instance);
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

        DefaultService that = (DefaultService) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (team != null ? !team.equals(that.team) : that.team != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (scm != null ? !scm.equals(that.scm) : that.scm != null) return false;
        if (instances != null ? !instances.equals(that.instances) : that.instances != null) return false;
        return metadata != null ? metadata.equals(that.metadata) : that.metadata == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (team != null ? team.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (scm != null ? scm.hashCode() : 0);
        result = 31 * result + (instances != null ? instances.hashCode() : 0);
        result = 31 * result + (metadata != null ? metadata.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "{\"DefaultService\":{"
                + "\"id\":\"" + id + "\""
                + ", \"team\":\"" + team + "\""
                + ", \"description\":\"" + description + "\""
                + ", \"scm\":\"" + scm + "\""
                + ", \"instances\":" + instances
                + ", \"metadata\":" + metadata
                + "}}";
    }
}
