package com.shedhack.cloud.savannah.server.controller;

import com.shedhack.cloud.savannah.server.constant.ApiConstants;
import com.shedhack.thread.context.annotation.ThreadContext;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * This is an example controller with a feign client.
 */
@RestController
public class PingController {

    @Value("${spring.application.name}")
    private String appName;

    /**
     * Used to provide tools a HTTP 200 OK when service is running.
     */
    @RequestMapping(path = ApiConstants.API_PING, method = RequestMethod.GET)
    public ResponseEntity<String> ping(){
        System.out.println("-->POING");
        return new ResponseEntity<>(appName + " is running.....", HttpStatus.OK);
    }

    @RequestMapping(path = "/api/error", method = RequestMethod.GET)
    public ResponseEntity<String> eping(){
        System.out.println("-->POING");
        throw new IllegalStateException("nejej");
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

}