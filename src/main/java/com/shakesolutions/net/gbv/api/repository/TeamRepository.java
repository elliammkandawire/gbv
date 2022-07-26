package com.shakesolutions.net.gbv.api.repository;

import com.shakesolutions.net.gbv.api.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team, String> {
}
