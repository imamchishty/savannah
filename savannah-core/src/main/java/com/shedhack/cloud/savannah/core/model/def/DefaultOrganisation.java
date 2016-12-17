package com.shedhack.cloud.savannah.core.model.def;

import com.shedhack.cloud.savannah.core.model.Organisation;
import com.shedhack.cloud.savannah.core.model.Profile;
import com.shedhack.cloud.savannah.core.model.Service;

import java.util.HashSet;
import java.util.Set;

public class DefaultOrganisation implements Organisation {

    // --------------
    // Static Builder
    // --------------

    public static class Builder {

        private DefaultOrganisation organisation;

        public Builder(String id, String description) {

            organisation = new DefaultOrganisation();
            organisation.setId(id);
            organisation.setDescription(description);
        }

        public Builder withProfiles(Set<Profile> profiles) {
            organisation.profiles = profiles;
            return this;
        }

        public Builder withProfile(Profile profile) {
            organisation.addProfile(profile);
            return this;
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

    private String id, description;

    private Set<Service> services = new HashSet<>();

    private Set<Profile> profiles = new HashSet<>();

    // --------------
    // Public Methods
    // --------------

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public Set<Profile> getProfiles() {
        return profiles;
    }

    public void addProfile(Profile profile) {
        profiles.add(profile);
    }

    public void removeProfile(Profile profile) {
        profiles.remove(profile);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DefaultOrganisation that = (DefaultOrganisation) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (services != null ? !services.equals(that.services) : that.services != null) return false;
        return profiles != null ? profiles.equals(that.profiles) : that.profiles == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (services != null ? services.hashCode() : 0);
        result = 31 * result + (profiles != null ? profiles.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "{\"DefaultOrganisation\":{"
                + "\"id\":\"" + id + "\""
                + ", \"description\":\"" + description + "\""
                + ", \"services\":" + services
                + ", \"profiles\":" + profiles
                + "}}";
    }
}
