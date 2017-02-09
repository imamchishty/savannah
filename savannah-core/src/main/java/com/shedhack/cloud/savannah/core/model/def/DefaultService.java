package com.shedhack.cloud.savannah.core.model.def;

import com.shedhack.cloud.savannah.core.model.Service;
import com.shedhack.cloud.savannah.core.model.ServiceInstance;

import java.util.HashSet;
import java.util.Set;

public class DefaultService implements Service {

    // -------
    // Builder
    // -------

    public static class Builder {

        private DefaultService service;

        public Builder(String name, String description) {

            service = new DefaultService();
            service.setName(name);
            service.setDescription(description);
        }

        public Builder withInstances(Set<ServiceInstance> instances) {
            service.instances = instances;
            return this;
        }

        public Builder withInstance(ServiceInstance instance) {
            service.instances.add(instance);
            return this;
        }

        public Service build() {
            return service;
        }

    }

    // ----------------
    // Static method
    // ----------------

    public static Builder builder(String name, String description) {
        return new Builder(name, description);
    }

    // ---------------
    // Private members
    // ---------------

    private String name;

    private String description;

    private Set<ServiceInstance> instances = new HashSet<>();

    // --------------
    // Public Methods
    // --------------

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
        this.instances = (Set<ServiceInstance>) instances;
    }

    public void addInstance(ServiceInstance instance) {

        // if it already exists then thrown an error
        if(this.instances.contains(instance)) {
            throw new IllegalStateException("Instance already exists. You must update/remove existing one.");
        }

        this.instances.add(instance);
    }

    public void removeInstance(ServiceInstance instance) {
        this.instances.remove(instance);
    }

}
