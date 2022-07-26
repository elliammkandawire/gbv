package com.shakesolutions.net.gbv.api.repository;

import com.shakesolutions.net.gbv.api.entity.News;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NewsRepository extends JpaRepository<News, String> {
}
