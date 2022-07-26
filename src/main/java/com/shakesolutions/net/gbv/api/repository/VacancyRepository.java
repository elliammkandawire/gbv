package com.shakesolutions.net.gbv.api.repository;

import com.shakesolutions.net.gbv.api.entity.Vacancy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VacancyRepository extends JpaRepository<Vacancy, String > {
}
