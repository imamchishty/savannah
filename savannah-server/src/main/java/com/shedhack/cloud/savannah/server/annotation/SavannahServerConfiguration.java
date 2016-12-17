package com.shedhack.cloud.savannah.server.annotation;

import com.shedhack.cloud.savannah.core.service.SavannahService;
import com.shedhack.cloud.savannah.server.controller.HelpController;
import com.shedhack.cloud.savannah.server.controller.PingController;
import com.shedhack.cloud.savannah.server.controller.SavannahController;
import com.shedhack.tool.spring.boost.EnableSpringBoost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author imamchishty
 */
@Configuration
@EnableSpringBoost
public class SavannahServerConfiguration extends WebMvcConfigurerAdapter {

    // -----------
    // Controllers
    // -----------

    @Bean
    public HelpController helpController() {
        return new HelpController();
    }

    @Bean
    public PingController pingController() {
        return new PingController();
    }

    @Autowired(required = false)
    private SavannahService savannahService;

    @Bean
    public SavannahController savannahController() {

        if(savannahService == null) {
            // default to inmemory one
        }
        return new SavannahController(savannahService);
    }

}