package com.shakesolutions.net.gbv.api.services;


import com.shakesolutions.net.gbv.api.entity.GetPageRequest;
import com.shakesolutions.net.gbv.api.entity.Member;
import com.shakesolutions.net.gbv.api.repository.MemberRepository;
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
public class MemberService {
    @Autowired
    MemberRepository memberRepository;

    public Page<Member> getPage(GetPageRequest pageRequest) {
        log.info("Requesting portfolio page for the following: "+pageRequest.toString());
        return memberRepository.findAll(PageRequest.of(pageRequest.getCurrentPage(), pageRequest.getRecordsPerPage(), Sort.by(Arrays.asList(Sort.Order.desc("date")))));
    }

    public Member add(Member data) {
        log.info(String.format("Adding new member with details %s",data));
        return memberRepository.saveAndFlush(data);
    }

    public List<Member> all() {
        log.info("Requesting all members");
        return memberRepository.findAll();
    }
}
