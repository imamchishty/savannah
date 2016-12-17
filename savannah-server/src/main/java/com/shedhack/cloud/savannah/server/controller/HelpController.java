package com.shedhack.cloud.savannah.server.controller;

import com.shedhack.cloud.savannah.core.exception.SavannahBusinessCodes;
import com.shedhack.cloud.savannah.server.constant.ApiConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;

/**
 * <pre>
 *      Controller provides clients with a definitive list of all HTTP and Business codes.
 * </pre>
 */
@RestController
public class HelpController {

    private Map<Object, String> businessCodes = new HashMap<>();
    private Map<Object, String> httpCodes = new HashMap<>();
    private Map<String, Map<Object, String>> codes = new HashMap<>();

    @Autowired
    private ServerProperties serverProperties;

    @PostConstruct
    public void setup(){

        for(SavannahBusinessCodes code : SavannahBusinessCodes.values()) {
            businessCodes.put(code.getCode(), code.getDescription());
        }

        codes.put("businessCodes", businessCodes);


        for(HttpStatus httpStatus : HttpStatus.values()) {
            httpCodes.put(httpStatus.value(), httpStatus.getReasonPhrase());
        }

        codes.put("httpCodes", httpCodes);

    }


    @RequestMapping(path = ApiConstants.API_HELP, method = RequestMethod.GET)
    public ResponseEntity help(){
        return new ResponseEntity(codes, HttpStatus.OK);
    }

}