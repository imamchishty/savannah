package com.shedhack.cloud.savannah.jpa;

import com.shedhack.cloud.savannah.core.model.ServiceInstance;
import com.shedhack.cloud.savannah.jpa.entity.ServiceEntity;
import com.shedhack.cloud.savannah.jpa.entity.ServiceInstanceEntity;
import com.shedhack.cloud.savannah.jpa.repository.ServiceRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * @author imamchishty
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = Application.class)
public class ServiceRepositoryTest {

    @Autowired
    private ServiceRepository repository;


    @Test
    @Sql({"/data.sql"})
    @Transactional()
    public void should_load_existing_services() {

        // Arrange + Act
      /*  List<ServiceEntity> entities = repository.findByOrganisationId("a");


        for(ServiceEntity entity : entities) {
            System.out.println("entity-" + entity.getId() + "--" + entity.getName());

            for(ServiceInstance serviceInstanceEntity : entity.getInstances()) {
                System.out.println("------>" + serviceInstanceEntity );
            }
        }

        // Assert
        assertEquals(5, entities.size());*/
    }


}
