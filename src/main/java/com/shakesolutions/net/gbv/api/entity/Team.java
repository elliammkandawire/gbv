package com.shakesolutions.net.gbv.api.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@javax.persistence.Entity
public class Team {
    @Id
    private String slug;
    private String name;
    private String position;
    private String country;
    private String phone;
    private String email;
    private String facebook_url;
    private String twitter_url;
    private String picture;
    @CreationTimestamp
    @Column(nullable = false, updatable = false, columnDefinition="TIMESTAMP default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP")
    private Date date;
    @ManyToOne
    @JoinColumn(name = "teams_group", nullable = false)
    private TeamGroups teamGroups;
}
