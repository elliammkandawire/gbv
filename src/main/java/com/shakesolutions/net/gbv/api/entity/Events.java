package com.shakesolutions.net.gbv.api.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Time;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Events {
    @Id
    private String slug;
    private String name;
    private String picture;
    @Column(columnDefinition="TEXT")
    private String details;
    private Time eventTime;
    private Date eventDate;
    @CreationTimestamp
    @Column(nullable =  false, updatable = false, columnDefinition="TIMESTAMP default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP")
    private Date date;
    private String location;
}
