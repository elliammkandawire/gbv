package com.shakesolutions.net.gbv.api.services;


import com.shakesolutions.net.gbv.api.entity.GetPageRequest;
import com.shakesolutions.net.gbv.api.entity.Team;
import com.shakesolutions.net.gbv.api.entity.TeamGroups;
import com.shakesolutions.net.gbv.api.repository.TeamGroupRepository;
import com.shakesolutions.net.gbv.api.repository.TeamRepository;
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
public class TeamService {
    @Autowired
    TeamRepository teamRepository;

    public Page<Team> getPage(GetPageRequest pageRequest) {
        log.info("Requesting Team page for the following: "+pageRequest.toString());
        return teamRepository.findAll(PageRequest.of(pageRequest.getCurrentPage(), pageRequest.getRecordsPerPage(), Sort.by(Arrays.asList(Sort.Order.desc("date")))));
    }

    public List<Team> all() {
        log.info("Requesting All Team Members");
        return teamRepository.findAll();
    }

    public Team add(Team data) {
        log.info("Add new team with details "+data);
        return teamRepository.saveAndFlush(data);
    }
}
