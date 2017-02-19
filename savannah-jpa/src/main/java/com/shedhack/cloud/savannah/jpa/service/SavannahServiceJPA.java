package com.shedhack.cloud.savannah.jpa.service;

import com.shedhack.cloud.savannah.core.model.*;
import com.shedhack.cloud.savannah.core.service.SavannahService;
import com.shedhack.cloud.savannah.jpa.entity.*;
import com.shedhack.cloud.savannah.jpa.repository.*;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

// FIXME split into different services

@Transactional
public class SavannahServiceJPA implements SavannahService {

    // -------------
    // Class members
    // -------------

    private OrganisationRepository organisationRepository;

    private ServiceRepository serviceRepository;

    private ServiceInstanceRepository serviceInstanceRepository;

    private ProfileRepository profileRepository;

    private DependencyRepository dependencyRepository;

    public SavannahServiceJPA(OrganisationRepository organisationRepository,
                              ServiceRepository serviceRepository,
                              ServiceInstanceRepository serviceInstanceRepository,
                              ProfileRepository profileRepository,
                              DependencyRepository dependencyRepository) {

        this.organisationRepository = organisationRepository;
        this.serviceRepository = serviceRepository;
        this.serviceInstanceRepository = serviceInstanceRepository;
        this.profileRepository = profileRepository;
        this.dependencyRepository = dependencyRepository;
    }

    // ---------------
    // Profile methods
    // ---------------

    public List<? extends Profile> findAllProfiles() {
        return (List<? extends Profile>) profileRepository.findAll();
    }

    public List<? extends Profile> findProfile(String profileId) {
        return (List<? extends Profile>) profileRepository.findOne(profileId);
    }

    public Profile saveProfile(Profile profile) {
        return profileRepository.save((ProfileEntity) profile);
    }

    public void removeProfile(String profileId) {
        profileRepository.delete(profileId);
    }

    public void removeAllProfiles() {
        profileRepository.deleteAll();
    }

    // --------------------
    // Organisation methods
    // --------------------

    public List<? extends Organisation> findAllOrganisations() {
        return (List<? extends Organisation>) organisationRepository.findAll();
    }

    public Organisation findOrganisation(String organisationId) {
        return organisationRepository.findOne(organisationId);
    }

    public Organisation saveOrganisation(Organisation organisation) {
        return organisationRepository.save((OrganisationEntity) organisation);
    }

    public Service addServiceToOrganisation(String organisationId, Service service) {
        OrganisationEntity organisationEntity = (OrganisationEntity) findOrganisation(organisationId);
        organisationEntity.addService(service);
        organisationRepository.save(organisationEntity);
        return service;
    }

    public void removeOrganisation(String organisationId) {
        organisationRepository.delete(organisationId);
    }

    public void removeAllOrganisations() {
        organisationRepository.deleteAll();
    }

    // ---------------
    // Service methods
    // ---------------

    public List<? extends Service> findAllServices() {
        return (List<? extends Service>) serviceRepository.findAll();
    }

    public Service findService(String serviceId) {
        return serviceRepository.findOne(serviceId);
    }

    public List<? extends Service> findServicesByOrganisation(String organisationId) {
        return serviceRepository.findByOrganisationId(organisationId);
    }

    public Service saveService(Service service) {
        return serviceRepository.save((ServiceEntity) service);
    }

    public ServiceInstance addInstanceToService(String serviceId, ServiceInstance instance) {
        ServiceEntity serviceEntity = (ServiceEntity) findService(serviceId);
        serviceEntity.addInstance(instance);
        return instance;
    }

    public void removeService(String serviceId) {
        serviceRepository.delete(serviceId);
    }

    public void removeAllServices() {
        serviceRepository.deleteAll();
    }

    // ------------------------
    // Service instance methods
    // ------------------------

    public List<? extends ServiceInstance> findAllServiceInstances() {
        return (List<? extends ServiceInstance>) serviceInstanceRepository.findAll();
    }

    public ServiceInstance findServiceInstance(String instanceId) {
        return serviceInstanceRepository.findOne(instanceId);
    }

    public List<? extends ServiceInstance> findServiceInstancesByService(String serviceId) {
        return serviceInstanceRepository.findByService(serviceId);
    }

    public List<? extends ServiceInstance> findServiceInstancesByProfile(String profileId) {
        return serviceInstanceRepository.findByProfile(profileId);
    }

    public List<? extends ServiceInstance> findServiceInstancesByServiceAndProfile(String serviceId, String profileId) {
        return serviceInstanceRepository.findServiceInstancesByServiceAndProfile(serviceId, profileId);
    }

    public List<? extends ServiceInstance> findServiceInstancesByServiceAndDate(String serviceId, Date start, Date end) {
        return serviceInstanceRepository.findServiceInstancesByServiceAndDate(serviceId, start, end);
    }

    public ServiceInstance saveServiceInstance(ServiceInstance instance) {
        return serviceInstanceRepository.save((ServiceInstanceEntity) instance);
    }

    public void removeServiceInstance(String instanceId) {
        serviceInstanceRepository.delete(instanceId);
    }

    public void removeAllServiceInstances() {
        serviceInstanceRepository.deleteAll();
    }

    // ------------------
    // Dependency methods
    // ------------------

    public List<? extends Dependency> findAllDependencies() {
        return (List<? extends Dependency>) dependencyRepository.findAll();
    }

    public Dependency findDependency(String name, String version) {
        return dependencyRepository.findOne(new DependencyPK(name, version));
    }

    public List<? extends Dependency> findDependencyByName(String name) {
        return dependencyRepository.findDependencyByName(name);
    }

    public List<? extends Dependency> findDependencyByServiceInstance(String serviceInstanceId) {
        return dependencyRepository.findDependencyByServiceInstance(serviceInstanceId);
    }

    public List<? extends ServiceInstance> findServiceInstancesByDependencyName(String dependency) {
        return dependencyRepository.findServiceInstancesByDependencyName(dependency);
    }

    public Dependency saveDependency(Dependency dependency) {
        return dependencyRepository.save((DependencyEntity) dependency);
    }

    public void saveDependencies(List<? extends Dependency> dependencies) {
        for(Dependency dependency : dependencies) {
            dependencyRepository.save((DependencyEntity) dependencies);
        }
    }

    public void removeDependency(String name, String version) {
        dependencyRepository.delete(new DependencyPK(name, version));
    }

    public void removeAllDependencies() {
        dependencyRepository.deleteAll();
    }
}
