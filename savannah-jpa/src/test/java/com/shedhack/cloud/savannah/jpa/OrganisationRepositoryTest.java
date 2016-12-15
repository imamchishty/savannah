package com.shedhack.cloud.savannah.jpa;

import com.shedhack.cloud.savannah.core.model.Organisation;
import com.shedhack.cloud.savannah.jpa.entity.OrganisationEntity;
import com.shedhack.cloud.savannah.jpa.repository.OrganisationRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * @author imamchishty
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT, classes = Application.class)
public class OrganisationRepositoryTest {

    @Autowired
    private OrganisationRepository repository;

    @Test
    public void should_create_org() throws Exception {

        // Arrange
        OrganisationEntity organisation = new OrganisationEntity();
        organisation.setName("bbc");
        organisation.setDescription("broadcasting giant");

        // Act
        repository.save(organisation);

        // Assert - if we have an ID then it's been saved
        assertNotNull(organisation.getId());
    }

    @Test
    @Sql({"/test-organisations.sql"})
    @Transactional()
    public void should_load_existing_orgs() {

        List<OrganisationEntity> entities = repository.findAll();

        // Assert
        assertEquals(3, entities.size());

        for(OrganisationEntity organisationEntity : entities) {

            // should have three profiles per org
            assertEquals(3, organisationEntity.getProfiles().size());

            // apple has 5
            if(organisationEntity.getId().equals("a")) {
                assertEquals(5, organisationEntity.getServices().size());
            }

            // the others have 1 each
            else {
                assertEquals(1, organisationEntity.getServices().size());
            }

        }
    }
}
