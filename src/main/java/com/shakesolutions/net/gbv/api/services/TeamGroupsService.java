package com.shakesolutions.net.gbv.api.services;


import com.shakesolutions.net.gbv.api.entity.GetPageRequest;
import com.shakesolutions.net.gbv.api.entity.Member;
import com.shakesolutions.net.gbv.api.entity.TeamGroups;
import com.shakesolutions.net.gbv.api.repository.MemberRepository;
import com.shakesolutions.net.gbv.api.repository.TeamGroupRepository;
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
public class TeamGroupsService {
    @Autowired
    TeamGroupRepository teamGroupRepository;

    public Page<TeamGroups> getPage(GetPageRequest pageRequest) {
        log.info("Requesting Team Group page for the following: "+pageRequest.toString());
        return teamGroupRepository.findAll(PageRequest.of(pageRequest.getCurrentPage(), pageRequest.getRecordsPerPage(), Sort.by(Arrays.asList(Sort.Order.desc("date")))));
    }

    public TeamGroups add(TeamGroups data) {
        log.info(String.format("Add new Teams Group with details %s",data));
        return teamGroupRepository.saveAndFlush(data);
    }

    public List<TeamGroups> all() {
        log.info("Read all team groups");
        return  teamGroupRepository.findAll();
    }
}
