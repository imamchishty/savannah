package com.shedhack.cloud.savannah.core.model.def;

import com.shedhack.cloud.savannah.core.model.Organisation;
import com.shedhack.cloud.savannah.core.model.Service;

import java.util.HashSet;
import java.util.Set;

public class DefaultOrganisation implements Organisation {

    // --------------
    // Static Builder
    // --------------

    public static class Builder {

        private DefaultOrganisation organisation;

        public Builder(String name, String description) {

            organisation = new DefaultOrganisation();
            organisation.setName(name);
            organisation.setDescription(description);
        }

        public Builder withServices(Set<Service> services) {
            organisation.services = services;
            return this;
        }

        public Builder withService(Service service) {
            organisation.addService(service);
            return this;
        }

        public Organisation build() {
            return organisation;
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

    private String name, description;

    private Set<Service> services = new HashSet<>();

    // --------------
    // Public Methods
    // --------------

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

    public Set<Service> getServices() {
        return services;
    }

    public void addService(Service service) {
        this.services.add(service);
    }

    public void removeService(Service service) {
        services.remove(service);
    }

}
