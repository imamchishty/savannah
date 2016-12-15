package com.shedhack.cloud.savannah.jpa;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @RequestMapping("/hello")
    public ResponseEntity<String> hello(){

            return new ResponseEntity<>("Hello", HttpStatus.ACCEPTED);
    }

}
