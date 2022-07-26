package com.shakesolutions.net.gbv.api.repository;

import com.shakesolutions.net.gbv.api.entity.CaseStudy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CaseStudyRepository  extends JpaRepository<CaseStudy, String> {
}
