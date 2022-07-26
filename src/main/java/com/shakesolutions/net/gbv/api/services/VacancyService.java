package com.shakesolutions.net.gbv.api.services;

import com.shakesolutions.net.gbv.api.entity.Company;
import com.shakesolutions.net.gbv.api.entity.GetPageRequest;
import com.shakesolutions.net.gbv.api.entity.Vacancy;
import com.shakesolutions.net.gbv.api.repository.CompanyRepository;
import com.shakesolutions.net.gbv.api.repository.VacancyRepository;
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
public class VacancyService {
    @Autowired
    VacancyRepository vacancyRepository;

    public Page<Vacancy> getPage(GetPageRequest pageRequest) {
        log.info("Requesting vacancy page for the following: "+pageRequest.toString());
        return vacancyRepository.findAll(PageRequest.of(pageRequest.getCurrentPage(), pageRequest.getRecordsPerPage(), Sort.by(Arrays.asList(Sort.Order.desc("date")))));
    }

    public Vacancy add(Vacancy data) {
        log.info(String.format("Adding Vacancy with details %s",data));
        return vacancyRepository.saveAndFlush(data);
    }

    public List<Vacancy> all() {
        log.info("Requesting all vacancy");
        return vacancyRepository.findAll();
    }
}
