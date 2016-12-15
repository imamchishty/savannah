package com.shedhack.cloud.savannah.jpa;

import com.shedhack.cloud.savannah.jpa.config.EnableSavannahJPA;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableSavannahJPA
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
