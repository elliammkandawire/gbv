package com.shakesolutions.net.gbv.api.repository;


import com.shakesolutions.net.gbv.api.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, String> {
}
