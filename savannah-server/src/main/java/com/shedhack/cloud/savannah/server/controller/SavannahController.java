package com.shedhack.cloud.savannah.server.controller;

import com.shedhack.cloud.savannah.core.model.Organisation;
import com.shedhack.cloud.savannah.core.model.Service;
import com.shedhack.cloud.savannah.core.model.ServiceInstance;
import com.shedhack.cloud.savannah.core.service.SavannahService;
import com.shedhack.cloud.savannah.server.constant.ApiConstants;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SavannahController implements SavannahService {

    private SavannahService savannahService;

    public SavannahController(SavannahService service) {
        this.savannahService = service;
    }

    @RequestMapping(path = ApiConstants.API_SAVANNAH_ROOT + "/organisations", method = RequestMethod.POST)
    public void persist(Organisation organisation) {
        savannahService.persist(organisation);
    }

    @RequestMapping(path = ApiConstants.API_SAVANNAH_ROOT + "/organisations/{organisationId}", method = RequestMethod.POST)
    public void addServiceToOrganisation(@PathVariable("organisationId") String organisationId, Service service) {
        savannahService.addServiceToOrganisation(organisationId, service);
    }

    @RequestMapping(path = ApiConstants.API_SAVANNAH_ROOT + "/organisations/{organisationId}", method = RequestMethod.DELETE)
    public void removeOrganisation(@PathVariable("organisationId") String organisationId) {
        savannahService.removeOrganisation(organisationId);
    }

    @RequestMapping(path = ApiConstants.API_SAVANNAH_ROOT + "/organisations", method = RequestMethod.DELETE)
    public void removeAllOrganisations() {
        savannahService.removeAllOrganisations();
    }

    @RequestMapping(path = ApiConstants.API_SAVANNAH_ROOT + "/organisations/{organisationId}", method = RequestMethod.GET)
    public Organisation findOrganisation(String organisationId) {
        return savannahService.findOrganisation(organisationId);
    }

    @RequestMapping(path = ApiConstants.API_SAVANNAH_ROOT + "/organisations", method = RequestMethod.GET)
    public List<? extends Organisation> findAllOrganisations() {
        return savannahService.findAllOrganisations();
    }

    public void persist(Service service) {

    }

    public void addInstanceToService(String serviceId, ServiceInstance instance) {

    }

    public void removeService(String service) {

    }

    public void removeServiceInstance(ServiceInstance instanceModel) {

    }

    public Service findService(String serviceId) {
        return null;
    }

    public List<? extends Service> findServicesForOrganisation(String organisationId) {
        return null;
    }

    public List<? extends Service> findAllServices(String organisation) {
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
