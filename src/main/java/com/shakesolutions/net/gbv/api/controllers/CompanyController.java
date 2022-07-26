package com.shakesolutions.net.gbv.api.controllers;

import com.shakesolutions.net.gbv.api.entity.Company;
import com.shakesolutions.net.gbv.api.entity.GetPageRequest;
import com.shakesolutions.net.gbv.api.services.CompanyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequestMapping("/api/company")
public class CompanyController {
    @Autowired
    CompanyService companyService;

    @GetMapping("/")
    private ResponseEntity get(@RequestBody GetPageRequest pageRequest)
    {
        try{
            return new ResponseEntity<>(companyService.getPage(pageRequest), HttpStatus.OK);
        }catch (Exception e){
            log.error("Error "+e.getMessage());
            return new ResponseEntity<>(false,HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/all")
    private ResponseEntity all()
    {
        try{
            return new ResponseEntity<>(companyService.all(), HttpStatus.OK);
        }catch (Exception e){
            log.error("Error "+e.getMessage());
            return new ResponseEntity<>(false,HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/")
    private ResponseEntity add(@RequestBody Company data)
    {
        try{
            return new ResponseEntity<>(companyService.add(data), HttpStatus.OK);
        }catch (Exception e){
            log.error("Error "+e.getMessage());
            return new ResponseEntity<>(false,HttpStatus.BAD_REQUEST);
        }
    }
}
