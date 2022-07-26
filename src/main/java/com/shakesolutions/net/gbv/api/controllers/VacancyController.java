package com.shakesolutions.net.gbv.api.controllers;

import com.shakesolutions.net.gbv.api.entity.GetPageRequest;
import com.shakesolutions.net.gbv.api.entity.Team;
import com.shakesolutions.net.gbv.api.entity.Vacancy;
import com.shakesolutions.net.gbv.api.services.TeamService;
import com.shakesolutions.net.gbv.api.services.VacancyService;
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
@RequestMapping("/api/vacancy")
public class VacancyController {
    @Autowired
    VacancyService vacancyService;

    @GetMapping("/")
    private ResponseEntity get(@RequestBody GetPageRequest pageRequest)
    {
        try{
            return new ResponseEntity<>(vacancyService.getPage(pageRequest), HttpStatus.OK);
        }catch (Exception e){
            log.error("Error "+e.getMessage());
            return new ResponseEntity<>(false,HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/all")
    private ResponseEntity all()
    {
        try{
            return new ResponseEntity<>(vacancyService.all(), HttpStatus.OK);
        }catch (Exception e){
            log.error("Error "+e.getMessage());
            return new ResponseEntity<>(false,HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/")
    private ResponseEntity add(@RequestBody Vacancy data)
    {
        try{
            return new ResponseEntity<>(vacancyService.add(data), HttpStatus.OK);
        }catch (Exception e){
            log.error("Error "+e.getMessage());
            return new ResponseEntity<>(false,HttpStatus.BAD_REQUEST);
        }
    }
}
