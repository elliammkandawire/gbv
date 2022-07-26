package com.shakesolutions.net.gbv.api.services;

import com.shakesolutions.net.gbv.api.entity.GetPageRequest;
import com.shakesolutions.net.gbv.api.entity.Member;
import com.shakesolutions.net.gbv.api.entity.Services;
import com.shakesolutions.net.gbv.api.repository.ServicesRepository;
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
public class ServicesService {
    @Autowired
    ServicesRepository servicesRepository;

    public Page<Services> getPage(GetPageRequest pageRequest) {
        log.info("Requesting services page for the following: "+pageRequest.toString());
        return servicesRepository.findAll(PageRequest.of(pageRequest.getCurrentPage(), pageRequest.getRecordsPerPage(), Sort.by(Arrays.asList(Sort.Order.desc("date")))));
    }

    public Services add(Services data) {
        log.info(String.format("Adding new service with details %s",data));
        return servicesRepository.saveAndFlush(data);
    }

    public List<Services> all() {
        log.info("Requesting all service");
        return servicesRepository.findAll();
    }
}
