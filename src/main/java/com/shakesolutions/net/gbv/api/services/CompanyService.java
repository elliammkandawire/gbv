package com.shakesolutions.net.gbv.api.services;

import com.shakesolutions.net.gbv.api.entity.Company;
import com.shakesolutions.net.gbv.api.entity.GetPageRequest;
import com.shakesolutions.net.gbv.api.entity.Services;
import com.shakesolutions.net.gbv.api.repository.CompanyRepository;
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
public class CompanyService {
    @Autowired
    CompanyRepository companyRepository;

    public Page<Company> getPage(GetPageRequest pageRequest) {
        log.info("Requesting company page for the following: "+pageRequest.toString());
        return companyRepository.findAll(PageRequest.of(pageRequest.getCurrentPage(), pageRequest.getRecordsPerPage(), Sort.by(Arrays.asList(Sort.Order.desc("date")))));
    }

    public Company add(Company data) {
        log.info(String.format("Adding company with details %s",data));
        return companyRepository.saveAndFlush(data);
    }

    public List<Company> all() {
        log.info("Requesting all service");
        return companyRepository.findAll();
    }
}
