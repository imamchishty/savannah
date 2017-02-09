package com.shedhack.cloud.savannah.core.service;

import com.shedhack.cloud.savannah.core.model.*;

import java.util.Date;
import java.util.List;

public interface SavannahService {

    // ---------------
    // Profile methods
    // ---------------

    List<? extends Profile> findAllProfiles();

    List<? extends Profile> findProfile(String profileId);

    Profile saveProfile(Profile profile);

    void removeProfile(String profileId);

    void removeAllProfiles();

    // --------------------
    // Organisation methods
    // --------------------

    List<? extends Organisation> findAllOrganisations();

    Organisation findOrganisation(String organisationId);

    Organisation saveOrganisation(Organisation organisation);

    void addServiceToOrganisation(String organisationId, Service service);

    void removeOrganisation(String organisationId);

    void removeAllOrganisations();

    // ---------------
    // Service methods
    // ---------------

    List<? extends Service> findAllServices();

    Service findService(String serviceId);

    List<? extends Service> findServicesByOrganisation(String organisationId);

    Service saveService(String organisationId, Service service);

    void addInstanceToService(String serviceId, ServiceInstance instance);

    void removeService(String serviceId);

    void removeAllServices();

    // ------------------------
    // Service instance methods
    // ------------------------

    List<? extends ServiceInstance> findAllServiceInstances();

    ServiceInstance findServiceInstance(String instanceId);

    List<? extends ServiceInstance> findServiceInstancesByService(String serviceId);

    List<? extends ServiceInstance> findServiceInstancesByProfile(String profileId);

    List<? extends ServiceInstance> findServiceInstancesByServiceAndProfile(String serviceId, String profileId);

    List<? extends ServiceInstance> findServiceInstancesByServiceAndDate(String serviceId, Date start, Date end);

    ServiceInstance saveServiceInstance(String serviceId, ServiceInstance instance);

    void removeServiceInstance(String instanceId);

    void removeAllServiceInstances();

    // ------------------
    // Dependency methods
    // ------------------

    List<? extends Dependency> findAllDependencies();

    Dependency findDependency(String name, String version);

    List<? extends Dependency> findDependencyByName(String name);

    List<? extends Dependency> findDependencyByServiceInstance(String serviceInstanceId);

    List<? extends Service> findDependencyByService(String serviceId);

    List<? extends ServiceInstance> findServiceInstancesByDependencyName(String dependency);

    Dependency saveDependency(Dependency dependency);

    void saveDependencies(List<? extends Dependency> dependencies);

    void removeDependency(String name, String version);

    void removeAllDependencies();
}
