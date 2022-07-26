package com.shakesolutions.net.gbv.api.services;

import com.shakesolutions.net.gbv.api.entity.GetPageRequest;
import com.shakesolutions.net.gbv.api.entity.News;
import com.shakesolutions.net.gbv.api.entity.Webinars;
import com.shakesolutions.net.gbv.api.repository.NewsRepository;
import com.shakesolutions.net.gbv.api.repository.WebinarsRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Slf4j
@Service
public class WebinarsService {
    @Autowired
    WebinarsRepository repository;

    public Page<Webinars> getPage(GetPageRequest pageRequest) {
        log.info("Requesting news webinars for the following: "+pageRequest.toString());
        return repository.findAll(PageRequest.of(pageRequest.getCurrentPage(), pageRequest.getRecordsPerPage(), Sort.by(Arrays.asList(Sort.Order.desc("date")))));
    }

    public Webinars add(Webinars data) {
        log.info(String.format("Adding new webinars with details %s",data));
        return repository.saveAndFlush(data);
    }

    public List<Webinars> all() {
        log.info("Requesting all webinars");
        return repository.findAll();
    }
}
