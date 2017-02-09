package com.shedhack.cloud.savannah.jpa.service;

import com.shedhack.cloud.savannah.core.model.*;
import com.shedhack.cloud.savannah.core.service.SavannahService;
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
        return null;
    }

    public List<? extends Profile> findProfile(String profileId) {
        return null;
    }

    public Profile saveProfile(Profile profile) {
        return null;
    }

    public void removeProfile(String profileId) {

    }

    public void removeAllProfiles() {

    }

    // --------------------
    // Organisation methods
    // --------------------

    public List<? extends Organisation> findAllOrganisations() {
        return null;
    }

    public Organisation findOrganisation(String organisationId) {
        return null;
    }

    public Organisation saveOrganisation(Organisation organisation) {
        return null;
    }

    public void addServiceToOrganisation(String organisationId, Service service) {

    }

    public void removeOrganisation(String organisationId) {

    }

    public void removeAllOrganisations() {

    }

    // ---------------
    // Service methods
    // ---------------

    public List<? extends Service> findAllServices() {
        return null;
    }

    public Service findService(String serviceId) {
        return null;
    }

    public List<? extends Service> findServicesByOrganisation(String organisationId) {
        return null;
    }

    public Service saveService(String organisationId, Service service) {
        return null;
    }

    public void addInstanceToService(String serviceId, ServiceInstance instance) {

    }

    public void removeService(String serviceId) {

    }

    public void removeAllServices() {

    }

    // ------------------------
    // Service instance methods
    // ------------------------

    public List<? extends ServiceInstance> findAllServiceInstances() {
        return null;
    }

    public ServiceInstance findServiceInstance(String instanceId) {
        return null;
    }

    public List<? extends ServiceInstance> findServiceInstancesByService(String serviceId) {
        return null;
    }

    public List<? extends ServiceInstance> findServiceInstancesByProfile(String profileId) {
        return null;
    }

    public List<? extends ServiceInstance> findServiceInstancesByServiceAndProfile(String serviceId, String profileId) {
        return null;
    }

    public List<? extends ServiceInstance> findServiceInstancesByServiceAndDate(String serviceId, Date start, Date end) {
        return null;
    }

    public ServiceInstance saveServiceInstance(String serviceId, ServiceInstance instance) {
        return null;
    }

    public void removeServiceInstance(String instanceId) {

    }

    public void removeAllServiceInstances() {

    }

    // ------------------
    // Dependency methods
    // ------------------

    public List<? extends Dependency> findAllDependencies() {
        return null;
    }

    public Dependency findDependency(String name, String version) {
        return null;
    }

    public List<? extends Dependency> findDependencyByName(String name) {
        return null;
    }

    public List<? extends Dependency> findDependencyByServiceInstance(String serviceInstanceId) {
        return null;
    }

    public List<? extends Service> findDependencyByService(String serviceId) {
        return null;
    }

    public List<? extends ServiceInstance> findServiceInstancesByDependencyName(String dependency) {
        return null;
    }

    public Dependency saveDependency(Dependency dependency) {
        return null;
    }

    public void saveDependencies(List<? extends Dependency> dependencies) {

    }

    public void removeDependency(String name, String version) {

    }

    public void removeAllDependencies() {

    }
}
