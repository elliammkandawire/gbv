package com.shakesolutions.net.gbv.api.repository;

import com.shakesolutions.net.gbv.api.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository  extends JpaRepository<Company, String> {
}
