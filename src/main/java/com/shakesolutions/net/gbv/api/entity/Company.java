package com.shakesolutions.net.gbv.api.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Column;
import javax.persistence.Id;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@javax.persistence.Entity
public class Company {
    @Id
    private String slug;
    private String shortname;
    private String fullname;
    @Column(columnDefinition="TEXT")
    private String objective;
    private String mission;
    private String motto;
    @Column(columnDefinition="TEXT")
    private String core_values;
    @Column(columnDefinition="TEXT")
    private String background;
    private String email;
    private String phone;
    private String postal_address;
    private String location;
    private String logo;
    private String youtube;
    @CreationTimestamp
    @Column(nullable =  false, updatable = false, columnDefinition="TIMESTAMP default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP")
    private Date date;
    private String icon;
    private String twitter;
    private String facebook;
    private String mobile_logo;
    private String header;
}
