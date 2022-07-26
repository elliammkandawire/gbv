package com.shakesolutions.net.gbv.api.repository;

import com.shakesolutions.net.gbv.api.entity.Publications;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PublicationsRepository extends JpaRepository<Publications, String> {
}
