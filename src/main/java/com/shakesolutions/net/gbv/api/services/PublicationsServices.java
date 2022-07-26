package com.shakesolutions.net.gbv.api.services;

import com.shakesolutions.net.gbv.api.entity.GetPageRequest;
import com.shakesolutions.net.gbv.api.entity.Member;
import com.shakesolutions.net.gbv.api.entity.Publications;
import com.shakesolutions.net.gbv.api.repository.MemberRepository;
import com.shakesolutions.net.gbv.api.repository.PublicationsRepository;
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
public class PublicationsServices {
    @Autowired
    PublicationsRepository repository;

    public Page<Publications> getPage(GetPageRequest pageRequest) {
        log.info("Requesting publications page for the following: "+pageRequest.toString());
        return repository.findAll(PageRequest.of(pageRequest.getCurrentPage(), pageRequest.getRecordsPerPage(), Sort.by(Arrays.asList(Sort.Order.desc("date")))));
    }

    public Publications add(Publications data) {
        log.info(String.format("Adding new publication with details %s",data));
        return repository.saveAndFlush(data);
    }

    public List<Publications> all() {
        log.info("Requesting all publications");
        return repository.findAll();
    }
}
