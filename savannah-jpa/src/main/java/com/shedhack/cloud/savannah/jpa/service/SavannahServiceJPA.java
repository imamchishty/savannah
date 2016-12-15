package com.shedhack.cloud.savannah.jpa.service;

import com.shedhack.cloud.savannah.core.model.Organisation;
import com.shedhack.cloud.savannah.core.model.Service;
import com.shedhack.cloud.savannah.core.model.ServiceInstance;
import com.shedhack.cloud.savannah.core.service.SavannahService;
import com.shedhack.cloud.savannah.jpa.repository.OrganisationRepository;
import com.shedhack.cloud.savannah.jpa.repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@org.springframework.stereotype.Service
public class SavannahServiceJPA implements SavannahService {

    private OrganisationRepository organisationRepository;

    private ServiceRepository serviceRepository;

    public SavannahServiceJPA(@Autowired OrganisationRepository organisationRepository,
                              @Autowired ServiceRepository serviceRepository) {

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

    public void persist(com.shedhack.cloud.savannah.core.model.Service service) {

    }

    public void addInstanceToService(String serviceId, ServiceInstance instance) {

    }

    public void removeService(String service) {

    }

    public void removeServiceInstance(ServiceInstance instanceModel) {

    }

    public com.shedhack.cloud.savannah.core.model.Service findService(String serviceId) {
        return null;
    }

    public List<? extends com.shedhack.cloud.savannah.core.model.Service> findServicesForOrganisation(String organisationId) {
        return null;
    }

    public List<? extends com.shedhack.cloud.savannah.core.model.Service> findAllServices(String organisation) {
        return null;
    }

    public void persist(ServiceInstance instance) {

    }

    public ServiceInstance findInstance(String id) {
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
