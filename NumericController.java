package com.app.server.rest;

import java.math.BigDecimal;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.app.server.domain.NumericRequest;
import com.app.server.domain.NumericResponse;
import com.app.server.service.Service;

@RestController
@RequestMapping(path = "/numeric")
public class NumericController {

    @Autowired
    @Qualifier("serviceImpl")
    private Service service;

    @RequestMapping(value = "/sqrt3highest", method = RequestMethod.POST)
    public ResponseEntity<NumericResponse> update(@RequestBody NumericRequest numReq) throws Exception {

        BigDecimal ret = service.computeSquareRootOf3Highest(Arrays.asList(numReq.getData()));
        
        NumericResponse res = new NumericResponse();
        res.setOutput(ret);
        
        return new ResponseEntity<NumericResponse>(res, HttpStatus.OK);
    }
    
}
