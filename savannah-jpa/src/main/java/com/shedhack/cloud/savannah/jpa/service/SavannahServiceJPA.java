package com.shedhack.cloud.savannah.jpa.service;

import com.shedhack.cloud.savannah.core.model.Organisation;
import com.shedhack.cloud.savannah.core.model.Service;
import com.shedhack.cloud.savannah.core.model.ServiceInstance;
import com.shedhack.cloud.savannah.core.service.SavannahService;
import com.shedhack.cloud.savannah.jpa.repository.OrganisationRepository;
import com.shedhack.cloud.savannah.jpa.repository.ServiceRepository;

import java.util.List;

public class SavannahServiceJPA implements SavannahService {

    private OrganisationRepository organisationRepository;

    private ServiceRepository serviceRepository;

    public SavannahServiceJPA(OrganisationRepository organisationRepository,
                              ServiceRepository serviceRepository) {

        this.organisationRepository = organisationRepository;
        this.serviceRepository = serviceRepository;
    }

    public void persist(Organisation organisation) {

    }

    public void addServiceToOrganisation(String organisationId, Service service) {

    }

    public void removeOrganisation(String organisationId) {

    }

    public void removeAllOrganisations() {

    }

    public Organisation findOrganisation(String organisationId) {
        return null;
    }

    public List<? extends Organisation> findAllOrganisations() {
        return null;
    }

    public void persist(Service service) {

    }

    public void addInstanceToService(String serviceId, ServiceInstance instance) {

    }

    public void removeService(String serviceId) {

    }

    public void removeServiceInstance(String instanceId) {

    }

    public Service findService(String serviceId) {
        return null;
    }

    public List<? extends Service> findServicesForOrganisation(String organisationId) {
        return null;
    }

    public List<? extends Service> findAllServices(String organisationId) {
        return null;
    }

    public void persist(ServiceInstance instance) {

    }

    public ServiceInstance findInstance(String instanceId) {
        return null;
    }

    public List<? extends ServiceInstance> findInstancesByService(String serviceId) {
        return null;
    }

    public List<? extends ServiceInstance> findInstancesByStatus(String serviceId, String status) {
        return null;
    }

    public List<? extends ServiceInstance> findInstancesByProfile(String organisationId, String profileId) {
        return null;
    }
}
