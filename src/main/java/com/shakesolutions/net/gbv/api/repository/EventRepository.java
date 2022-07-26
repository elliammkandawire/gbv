package com.shakesolutions.net.gbv.api.repository;

import com.shakesolutions.net.gbv.api.entity.Events;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EventRepository extends JpaRepository<Events, String> {

    List<Events> findAllByOrderByEventDateDesc();
}
