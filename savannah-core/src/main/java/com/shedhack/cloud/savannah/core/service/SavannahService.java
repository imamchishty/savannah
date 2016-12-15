package com.shedhack.cloud.savannah.core.service;

import com.shedhack.cloud.savannah.core.model.Organisation;
import com.shedhack.cloud.savannah.core.model.ServiceInstance;
import com.shedhack.cloud.savannah.core.model.Service;

import java.util.List;

public interface SavannahService {

    // --------------------
    // Organisation methods
    // --------------------

    void persist(Organisation organisation);

    void addServiceToOrganisation(String organisationId, Service service);

    void removeOrganisation(String organisationId);

    void removeAllOrganisations();

    Organisation findOrganisation(String organisationId);

    List<? extends Organisation> findAllOrganisations();

    // ---------------
    // Service methods
    // ---------------

    void persist(Service service);

    void addInstanceToService(String serviceId, ServiceInstance instance);

    void removeService(String service);

    void removeServiceInstance(ServiceInstance instanceModel);

    Service findService(String serviceId);

    List<? extends Service> findServicesForOrganisation(String organisationId);

    List<? extends Service> findAllServices(String organisation);

    // ----------------
    // Instance methods
    // ----------------

    void persist(ServiceInstance instance);

    ServiceInstance findInstance(String id);

    List<? extends ServiceInstance> findInstancesByService(String serviceId);

    List<? extends ServiceInstance> findInstancesByStatus(String serviceId, String status);

    // ----------------
    // Profile methods
    // ----------------

    List<? extends ServiceInstance> findInstancesByProfile(String organisationId, String profileId);

}
