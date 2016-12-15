package com.shedhack.cloud.savannah.server;

import com.shedhack.cloud.savannah.server.annotation.EnableSavannahServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableSavannahServer
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
