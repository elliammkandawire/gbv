package com.shakesolutions.net.gbv.api.services;

import com.shakesolutions.net.gbv.api.entity.GetPageRequest;
import com.shakesolutions.net.gbv.api.entity.News;
import com.shakesolutions.net.gbv.api.entity.Publications;
import com.shakesolutions.net.gbv.api.repository.NewsRepository;
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
public class NewsService {
    @Autowired
    NewsRepository repository;

    public Page<News> getPage(GetPageRequest pageRequest) {
        log.info("Requesting news page for the following: "+pageRequest.toString());
        return repository.findAll(PageRequest.of(pageRequest.getCurrentPage(), pageRequest.getRecordsPerPage(), Sort.by(Arrays.asList(Sort.Order.desc("date")))));
    }

    public News add(News data) {
        log.info(String.format("Adding new news with details %s",data));
        return repository.saveAndFlush(data);
    }

    public List<News> all() {
        log.info("Requesting all news");
        return repository.findAll();
    }

    public News single(String slug) {
        log.info("Requesting single news");
        return repository.findById(slug).get();
    }

    public Object latest() {
        log.info("Requesting latest news");
        return repository.findFirst5ByOrderByDateDesc();
    }
}
