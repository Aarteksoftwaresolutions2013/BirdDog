package com.birddog.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author Aartek
 */
@Entity
@Table(name = "city")
public class City {

    private Integer id;
    private County county;
    private String cityName;

    public City() {
    }

    public City(County county, String cityName, int isDeleted, Date creationTime, Date updationTime) {
        this.county = county;
        this.cityName = cityName;

    }

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "COUNTY_ID", nullable = false)
    public County getCounty() {
        return this.county;
    }

    public void setCounty(County county) {
        this.county = county;
    }

    @Column(name = "CITY_NAME", nullable = false, length = 50)
    public String getCityName() {
        return this.cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

}
