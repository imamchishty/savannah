package com.shedhack.cloud.savannah.jpa.config;

import com.shedhack.cloud.savannah.core.service.SavannahService;
import com.shedhack.cloud.savannah.jpa.repository.*;
import com.shedhack.cloud.savannah.jpa.service.SavannahServiceJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.HashMap;

/**
 * @author imamchishty
 */
@Configuration
@EnableJpaRepositories(basePackages = "com.shedhack.cloud.savannah.jpa")
public class SavannahJPAConfiguration {

    @Autowired
    private OrganisationRepository organisationRepository;

    @Autowired
    private ServiceRepository serviceRepository;

    @Autowired
    private ServiceInstanceRepository serviceInstanceRepository;

    @Autowired
    private ProfileRepository profileRepository;

    @Autowired
    private DependencyRepository dependencyRepository;

    @Bean
    public SavannahService savannahServiceJPA() {
        return new SavannahServiceJPA(organisationRepository, serviceRepository,
                serviceInstanceRepository, profileRepository, dependencyRepository);
    }

}