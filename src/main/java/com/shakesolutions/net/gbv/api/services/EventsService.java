package com.shakesolutions.net.gbv.api.services;

import com.shakesolutions.net.gbv.api.entity.Events;
import com.shakesolutions.net.gbv.api.entity.GetPageRequest;
import com.shakesolutions.net.gbv.api.entity.Webinars;
import com.shakesolutions.net.gbv.api.repository.EventRepository;
import com.shakesolutions.net.gbv.api.repository.WebinarsRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
@Slf4j
public class EventsService {
    @Autowired
    EventRepository repository;

    public Page<Events> getPage(GetPageRequest pageRequest) {
        log.info("Requesting news events for the following: "+pageRequest.toString());
        return repository.findAll(PageRequest.of(pageRequest.getCurrentPage(), pageRequest.getRecordsPerPage(), Sort.by(Arrays.asList(Sort.Order.desc("event_date")))));
    }

    public Events add(Events data) {
        log.info(String.format("Adding new events with details %s",data));
        return repository.saveAndFlush(data);
    }

    public List<Events> all() {
        log.info("Requesting all events");
        return repository.findAllByOrderByEventDateDesc();
    }
}
