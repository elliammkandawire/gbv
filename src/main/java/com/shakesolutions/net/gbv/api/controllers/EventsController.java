package com.shakesolutions.net.gbv.api.controllers;

import com.shakesolutions.net.gbv.api.entity.Events;
import com.shakesolutions.net.gbv.api.entity.GetPageRequest;
import com.shakesolutions.net.gbv.api.services.EventsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@Slf4j
@RequestMapping("/api/events")
public class EventsController {
    @Autowired
    EventsService service;

    @GetMapping("/")
    private ResponseEntity get(@RequestBody GetPageRequest pageRequest)
    {
        try{
            return new ResponseEntity<>(service.getPage(pageRequest), HttpStatus.OK);
        }catch (Exception e){
            log.error("Error "+e.getMessage());
            System.out.println(e);
            return new ResponseEntity<>(false,HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/all")
    private ResponseEntity all()
    {
        try{
            return new ResponseEntity<>(service.all(), HttpStatus.OK);
        }catch (Exception e){
            log.error("Error "+e.getMessage());
            return new ResponseEntity<>(false,HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/single/{slug}")
    private ResponseEntity single(@PathVariable("slug") String slug)
    {
        try{
            return new ResponseEntity<>(service.single(slug), HttpStatus.OK);
        }catch (Exception e){
            log.error("Error "+e.getMessage());
            return new ResponseEntity<>(false,HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/")
    private ResponseEntity add(@RequestBody Events data)
    {
        try{
            return new ResponseEntity<>(service.add(data), HttpStatus.OK);
        }catch (Exception e){
            log.error("Error "+e.getMessage());
            return new ResponseEntity<>(false,HttpStatus.BAD_REQUEST);
        }
    }
}
