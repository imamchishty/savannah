package com.shedhack.cloud.savannah.jpa;

import com.shedhack.cloud.savannah.core.model.*;
import com.shedhack.cloud.savannah.core.service.SavannahService;
import com.shedhack.cloud.savannah.jpa.entity.OrganisationEntity;
import com.shedhack.cloud.savannah.jpa.entity.ServiceEntity;
import com.shedhack.cloud.savannah.jpa.repository.OrganisationRepository;
import com.shedhack.cloud.savannah.jpa.repository.ServiceRepository;
import com.shedhack.thread.context.annotation.ThreadContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Date;
import java.util.List;

@RestController
public class TestController {


    @Autowired
    private SavannahService savannahService;


    // ---------------
    // Profile methods
    // ---------------

    @ThreadContext
    @RequestMapping(value = "/profiles", method = RequestMethod.GET)
    public List<? extends Profile> findAllProfiles() {
        return savannahService.findAllProfiles();
    }

    @ThreadContext
    @RequestMapping(value = "/profiles/{profileId}", method = RequestMethod.GET)
    public List<? extends Profile> findProfile(@PathVariable String profileId) {
        return  savannahService.findProfile(profileId);
    }

    @ThreadContext
    @RequestMapping(value = "/profiles", method = RequestMethod.POST)
    public Profile saveProfile(Profile profile) {
        return savannahService.saveProfile(profile);
    }

    @ThreadContext
    @RequestMapping(value = "/profiles/{profileId}", method = RequestMethod.DELETE)
    public void removeProfile(@PathVariable String profileId) {
        savannahService.removeProfile(profileId);
    }

    @ThreadContext
    @RequestMapping(value = "/profiles", method = RequestMethod.DELETE)
    public void removeAllProfiles() {
        savannahService.removeAllProfiles();
    }

    // --------------------
    // Organisation methods
    // --------------------

    @ThreadContext
    @RequestMapping(value = "/organisations", method = RequestMethod.GET)
    public List<? extends Organisation> findAllOrganisations() {
        return savannahService.findAllOrganisations();
    }

    @ThreadContext
    @RequestMapping(value = "/organisations/{organisationId}", method = RequestMethod.GET)
    public Organisation findOrganisation(@PathVariable String organisationId) {
        return savannahService.findOrganisation(organisationId);
    }

    @ThreadContext
    @RequestMapping(value = "/organisations", method = RequestMethod.POST)
    public Organisation saveOrganisation(Organisation organisation) {
        return savannahService.saveOrganisation(organisation);
    }

    @ThreadContext
    @RequestMapping(value = "/organisations/{organisationId}", method = RequestMethod.POST)
    public void addServiceToOrganisation(@PathVariable String organisationId, Service service) {
        savannahService.addServiceToOrganisation(organisationId, service);
    }

    @ThreadContext
    @RequestMapping(value = "/organisations/{organisationId}", method = RequestMethod.DELETE)
    public void removeOrganisation(@PathVariable String organisationId) {
        savannahService.removeOrganisation(organisationId);
    }

    @ThreadContext
    @RequestMapping(value = "/organisations", method = RequestMethod.DELETE)
    public void removeAllOrganisations() {
        savannahService.removeAllOrganisations();
    }

    // ---------------
    // Service methods
    // ---------------

    @ThreadContext
    @RequestMapping(value = "/services", method = RequestMethod.GET)
    public List<? extends Service> findAllServices() {
        return savannahService.findAllServices();
    }

    @ThreadContext
    @RequestMapping(value = "/services/{serviceId}", method = RequestMethod.GET)
    public Service findService(@PathVariable String serviceId) {
        return savannahService.findService(serviceId);
    }

    @ThreadContext
    @RequestMapping(value = "/organisations/{organisationId}/services", method = RequestMethod.GET)
    public List<? extends Service> findServicesByOrganisation(@PathVariable String organisationId) {
        return savannahService.findServicesByOrganisation(organisationId);
    }

    @ThreadContext
    @RequestMapping(value = "/organisations/{organisationId}/services", method = RequestMethod.POST)
    public Service saveService(String organisationId, Service service) {
        return savannahService.saveService(service);
    }

    @ThreadContext
    @RequestMapping(value = "/services/{serviceId}/instances", method = RequestMethod.POST)
    public void addInstanceToService(@PathVariable String serviceId, ServiceInstance instance) {
        savannahService.addInstanceToService(serviceId, instance);
    }

    @ThreadContext
    @RequestMapping(value = "/services/{serviceId}", method = RequestMethod.DELETE)
    public void removeService(@PathVariable String serviceId) {
        savannahService.removeService(serviceId);
    }

    @ThreadContext
    @RequestMapping(value = "/services", method = RequestMethod.DELETE)
    public void removeAllServices() {
        savannahService.removeAllServices();
    }

    // ------------------------
    // Service instance methods
    // ------------------------

    @ThreadContext
    @RequestMapping(value = "/instances", method = RequestMethod.GET)
    public List<? extends ServiceInstance> findAllServiceInstances() {
        return savannahService.findAllServiceInstances();
    }

    @ThreadContext
    @RequestMapping(value = "/instances/{instanceId}", method = RequestMethod.GET)
    public ServiceInstance findServiceInstance(@PathVariable String instanceId) {
        return savannahService.findServiceInstance(instanceId);
    }

    @ThreadContext
    @RequestMapping(value = "/services/{serviceId}/instances", method = RequestMethod.GET)
    public List<? extends ServiceInstance> findServiceInstancesByService(@PathVariable String serviceId) {
        return savannahService.findServiceInstancesByService(serviceId);
    }

    @ThreadContext
    @RequestMapping(value = "/instances/profiles/{profileId}", method = RequestMethod.GET)
    public List<? extends ServiceInstance> findServiceInstancesByProfile(@PathVariable String profileId) {
        return savannahService.findServiceInstancesByProfile(profileId);
    }

    @ThreadContext
    //@RequestMapping(value = "/profiles", method = RequestMethod.GET)
    public List<? extends ServiceInstance> findServiceInstancesByServiceAndProfile(String serviceId, String profileId) {
        return savannahService.findServiceInstancesByServiceAndProfile(serviceId, profileId);
    }

    @ThreadContext
    //@RequestMapping(value = "/profiles", method = RequestMethod.GET)
    public List<? extends ServiceInstance> findServiceInstancesByServiceAndDate(String serviceId, Date start, Date end) {
        return savannahService.findServiceInstancesByServiceAndDate(serviceId, start, end);
    }

    @ThreadContext
    //@RequestMapping(value = "/profiles", method = RequestMethod.POST)
    public ServiceInstance saveServiceInstance(String serviceId, ServiceInstance instance) {
        return savannahService.saveServiceInstance(instance);
    }

    @ThreadContext
   // @RequestMapping(value = "/profiles", method = RequestMethod.DELETE)
    public void removeServiceInstance(String instanceId) {
        savannahService.removeServiceInstance(instanceId);
    }

    @ThreadContext
    //@RequestMapping(value = "/profiles", method = RequestMethod.DELETE)
    public void removeAllServiceInstances() {
        savannahService.removeAllServiceInstances();
    }

    // ------------------
    // Dependency methods
    // ------------------

    @ThreadContext
    //@RequestMapping(value = "/profiles", method = RequestMethod.GET)
    public List<? extends Dependency> findAllDependencies() {
        return savannahService.findAllDependencies();
    }

    @ThreadContext
    //@RequestMapping(value = "/profiles", method = RequestMethod.GET)
    public Dependency findDependency(String name, String version) {
        return savannahService.findDependency(name, version);
    }

    @ThreadContext
    //@RequestMapping(value = "/profiles", method = RequestMethod.GET)
    public List<? extends Dependency> findDependencyByName(String name) {
        return savannahService.findDependencyByName(name);
    }

    @ThreadContext
    //@RequestMapping(value = "/profiles", method = RequestMethod.GET)
    public List<? extends Dependency> findDependencyByServiceInstance(String serviceInstanceId) {
        return savannahService.findDependencyByServiceInstance(serviceInstanceId);
    }

    @ThreadContext
    //@RequestMapping(value = "/profiles", method = RequestMethod.GET)
    public List<? extends ServiceInstance> findServiceInstancesByDependencyName(String dependency) {
        return savannahService.findServiceInstancesByDependencyName(dependency);
    }

    @ThreadContext
    //@RequestMapping(value = "/profiles", method = RequestMethod.POST)
    public Dependency saveDependency(Dependency dependency) {
        return savannahService.saveDependency(dependency);
    }

    @ThreadContext
    //@RequestMapping(value = "/profiles", method = RequestMethod.POST)
    public void saveDependencies(List<? extends Dependency> dependencies) {
        savannahService.saveDependencies(dependencies);
    }

    @ThreadContext
    //@RequestMapping(value = "/profiles", method = RequestMethod.DELETE)
    public void removeDependency(String name, String version) {
        savannahService.removeDependency(name, version);
    }

    @ThreadContext
    //@RequestMapping(value = "/profiles", method = RequestMethod.DELETE)
    public void removeAllDependencies() {
        savannahService.removeAllDependencies();
    }
}
