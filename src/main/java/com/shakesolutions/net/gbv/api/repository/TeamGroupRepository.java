package com.shakesolutions.net.gbv.api.repository;

import com.shakesolutions.net.gbv.api.entity.TeamGroups;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamGroupRepository extends JpaRepository<TeamGroups, String> {
}
