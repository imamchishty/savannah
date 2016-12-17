package com.shedhack.cloud.savannah.server.controller;

import com.shedhack.cloud.savannah.core.model.Organisation;
import com.shedhack.cloud.savannah.core.model.Profile;
import com.shedhack.cloud.savannah.core.model.Service;
import com.shedhack.cloud.savannah.core.model.ServiceInstance;
import com.shedhack.cloud.savannah.core.model.def.*;
import com.shedhack.cloud.savannah.core.service.SavannahService;
import com.shedhack.cloud.savannah.server.constant.ApiConstants;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class SavannahController implements SavannahService {

    private SavannahService savannahService;

    public SavannahController(SavannahService service) {
        this.savannahService = service;
    }


    private Map<String, Organisation> organisationMap = new HashMap<>();

    @RequestMapping(path = ApiConstants.API_SAVANNAH_ROOT + "/test", method = RequestMethod.GET)
    public ResponseEntity<Organisation> organisation() {

        Profile dev = new DefaultProfile("dev", "development environment");
        Profile test = new DefaultProfile("test", "test environment");
        Profile prod = new DefaultProfile("prod", "production environment");

        Organisation organisation = DefaultOrganisation.builder("bbc", "british broadcasting corporation").withProfile(dev).build();
        organisation.addProfile(prod);
        organisation.addProfile(test);

// LOGIN
        Service login = DefaultService.builder("login", "authentication + authorisation")
                .withScm("github.com/services/login").withTeam("dubai")
                .withMetadata("wiki", "wiki.com/login").build();

        ServiceInstance loginDev = DefaultServiceInstance.builder("login-dev").withDateTime(new Date())
                .withApiVersion(new DefaultApiVersion("1.1", "Authentication added"))
                .withContainerImage("dockerhub.com/imamchishty/login:1.1")
                .withExecutor("Jenkins").withHost("192.168.2.99").withPort(8080)
                .withVersion("1.0.0")
                .withProfile(dev).withScmRevision("d32aef").withStatus("STARTED")
                .withBuildNo("jenkins.com/login")
                .withBuildJob("123")
                .withMetadata("wiki", "wiki.com/login")
                .withDependency(new DefaultServiceInstanceDependency("authentication", "1.2")).build();


        ServiceInstance loginTest = DefaultServiceInstance.builder("login-test").withDateTime(new Date())
                .withApiVersion(new DefaultApiVersion("1.1", "Authentication added"))
                .withContainerImage("dockerhub.com/imamchishty/login:1.1")
                .withExecutor("Jenkins").withHost("192.168.2.99").withPort(8080)
                .withVersion("1.0.0")
                .withProfile(test).withScmRevision("d32aef").withStatus("STARTED")
                .withBuildNo("jenkins.com/login")
                .withBuildJob("123")
                .withMetadata("wiki", "wiki.com/login")
                .withDependency(new DefaultServiceInstanceDependency("authentication", "1.2")).build();


        ServiceInstance loginProd = DefaultServiceInstance.builder("login-prod").withDateTime(new Date())
                .withApiVersion(new DefaultApiVersion("1.1", "Authentication added"))
                .withContainerImage("dockerhub.com/imamchishty/login:1.1")
                .withExecutor("Jenkins").withHost("192.168.2.99").withPort(8080)
                .withVersion("1.0.0")
                .withProfile(prod).withScmRevision("d32aef").withStatus("STARTED")
                .withBuildNo("jenkins.com/login")
                .withBuildJob("123")
                .withMetadata("wiki", "wiki.com/login")
                .withDependency(new DefaultServiceInstanceDependency("authentication", "1.2")).build();


        login.addInstance(loginDev);
        login.addInstance(loginTest);
        login.addInstance(loginProd);

// ORDER
        Service order = DefaultService.builder("order", "order service ")
                .withScm("github.com/services/order").withTeam("dubai")
                .withMetadata("wiki", "wiki.com/order").build();

        ServiceInstance orderDev = DefaultServiceInstance.builder("order-dev").withDateTime(new Date())
                .withApiVersion(new DefaultApiVersion("1.1", "Authentication added"))
                .withContainerImage("dockerhub.com/imamchishty/order:1.1")
                .withExecutor("Jenkins").withHost("192.168.2.99").withPort(8080)
                .withVersion("1.0.0")
                .withProfile(dev).withScmRevision("d32aef").withStatus("STARTED")
                .withBuildNo("jenkins.com/order")
                .withBuildJob("123")
                .withMetadata("wiki", "wiki.com/order")
                .withDependency(new DefaultServiceInstanceDependency("account", "1.2")).build();


        ServiceInstance orderTest = DefaultServiceInstance.builder("order-test").withDateTime(new Date())
                .withApiVersion(new DefaultApiVersion("1.1", "Authentication added"))
                .withContainerImage("dockerhub.com/imamchishty/order:1.1")
                .withExecutor("Jenkins").withHost("192.168.2.99").withPort(8080)
                .withVersion("1.0.0")
                .withProfile(test).withScmRevision("d32aef").withStatus("STARTED")
                .withBuildNo("jenkins.com/order")
                .withBuildJob("123")
                .withMetadata("wiki", "wiki.com/order")
                .withDependency(new DefaultServiceInstanceDependency("account", "1.2")).build();





        order.addInstance(orderDev);
        order.addInstance(orderTest);
       // order.addInstance(orderProd);


        organisation.addService(login);
        organisation.addService(order);

        organisationMap.put(organisation.getId(), organisation);

        return new ResponseEntity<Organisation>(organisation, HttpStatus.OK);
    }

    @RequestMapping(path = ApiConstants.API_SAVANNAH_ROOT + "/test/add", method = RequestMethod.GET)
    public ResponseEntity<Organisation> organisations() {

        Profile prod = new DefaultProfile("prod", "production environment");

        ServiceInstance orderProd = DefaultServiceInstance.builder(UUID.randomUUID().toString()).withDateTime(new Date())
                .withApiVersion(new DefaultApiVersion("1.1", "Authentication added"))
                .withContainerImage("dockerhub.com/imamchishty/order:1.1")
                .withExecutor("Jenkins").withHost("192.168.2.99").withPort(8080)
                .withVersion("1.0.0")
                .withProfile(prod).withScmRevision("d32aef").withStatus("STARTED")
                .withBuildNo("jenkins.com/order")
                .withBuildJob("123")
                .withMetadata("wiki", "wiki.com/order")
                .withDependency(new DefaultServiceInstanceDependency("account", "1.2")).build();

        // I need the following to add instance
        String org = "bbc";
        String ser = "order";

        Organisation o = organisationMap.get(org);

        for(Service s : o.getServices()) {
            if(s.getId().equals(ser)) {

                for(ServiceInstance i : s.getInstances()) {
                    System.out.println(orderProd.getId() + ">" + orderProd.hashCode() + "===" + i.getId() + "=="  + i.hashCode() + "--" + i.equals(orderProd));
                }

                s.addInstance(orderProd);
            }
        }

        //organisationMap.get("bbc").getServices().get(0).addInstance(orderProd);

        return new ResponseEntity<Organisation>(organisationMap.get("bbc"), HttpStatus.OK);
    }

    @RequestMapping(path = ApiConstants.API_SAVANNAH_ROOT + "/test/del", method = RequestMethod.GET)
    public ResponseEntity<Organisation> organisationsdel() {
        String org = "bbc";
        String ser = "order";

        Organisation o = organisationMap.get(org);

        for(Service s : o.getServices()) {
            if(s.getId().equals(ser)) {
                //s.addInstance(orderProd);
            }
        }

        return new ResponseEntity<Organisation>(organisationMap.get("bbc"), HttpStatus.OK);

    }


    @RequestMapping(path = ApiConstants.API_SAVANNAH_ROOT + "/test/status", method = RequestMethod.GET)
    public ResponseEntity<Organisation> organisationsstatus() {
        String org = "bbc";
        String ser = "order";

        Organisation o = organisationMap.get(org);

        for(Service s : o.getServices()) {
            if(s.getId().equals(ser)) {
                //s.addInstance(orderProd);
                for(ServiceInstance instance : s.getInstances()) {
                    if(instance.getId().equals("order-prod")) {
                        instance.setStatus("STOPPED");
                    }
                }
            }
        }

        return new ResponseEntity<Organisation>(organisationMap.get("bbc"), HttpStatus.OK);

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

    @RequestMapping(path = ApiConstants.API_SAVANNAH_ROOT + "/organisations/{organisationId}/services", method = RequestMethod.POST)
    public void persist(Service serviceId) {
        savannahService.persist(serviceId);
    }

    @RequestMapping(path = ApiConstants.API_SAVANNAH_ROOT + "/organisations/{organisationId}/services/{serviceId}", method = RequestMethod.POST)
    public void addInstanceToService(String serviceId, ServiceInstance instance) {
        savannahService.addInstanceToService(serviceId, instance);
    }

    @RequestMapping(path = ApiConstants.API_SAVANNAH_ROOT + "/organisations/{organisationId}/services/{serviceId}", method = RequestMethod.DELETE)
    public void removeService(String serviceId) {
        savannahService.removeService(serviceId);
    }

    @RequestMapping(path = ApiConstants.API_SAVANNAH_ROOT + "/organisations/{organisationId}/services/{serviceId}/instances/{instanceId}", method = RequestMethod.DELETE)
    public void removeServiceInstance(String instanceId) {

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
