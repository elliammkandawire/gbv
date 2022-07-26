package com.shakesolutions.net.gbv.api.services;

import com.shakesolutions.net.gbv.api.entity.CaseStudy;
import com.shakesolutions.net.gbv.api.entity.GetPageRequest;
import com.shakesolutions.net.gbv.api.repository.CaseStudyRepository;
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
public class CaseStudyService {
    @Autowired
    CaseStudyRepository repository;

    public Page<CaseStudy> getPage(GetPageRequest pageRequest) {
        log.info("Requesting case study case for the following: "+pageRequest.toString());
        return repository.findAll(PageRequest.of(pageRequest.getCurrentPage(), pageRequest.getRecordsPerPage(), Sort.by(Arrays.asList(Sort.Order.desc("date")))));
    }

    public CaseStudy add(CaseStudy data) {
        log.info(String.format("Adding new case study with details %s",data));
        return repository.saveAndFlush(data);
    }

    public List<CaseStudy> all() {
        log.info("Requesting all case study");
        return repository.findAll();
    }
}
