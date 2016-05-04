package com.birddog.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 * @author Aartek
 */
@Entity
@Table(name = "re_investor")
public class ReInvestor {

    private Integer id;
    private Address address;
    private String name;
    private String contactNo;
    private String email;
    private String version;
    private int isDeleted;
    private Date creationTime;
    private Date updationTime;
    private Integer reiRole;
    private String imageName;
    private String fromDate;
    private String toDate;
    private String search;

    @Transient
    public String getFromDate() {
        return fromDate;
    }

    public void setFromDate(String fromDate) {
        this.fromDate = fromDate;
    }

    @Transient
    public String getToDate() {
        return toDate;
    }

    public void setToDate(String toDate) {
        this.toDate = toDate;
    }

    @Transient
    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    @Column(name = "IMAGE_NAME", length = 50)
    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public ReInvestor() {
    }

    public ReInvestor(String name, String contactNo, String email, int isDeleted, Date creationTime, Date updationTime,
                    Integer reiRole,String version) {
        this.name = name;
        this.contactNo = contactNo;
        this.email = email;
        this.isDeleted = isDeleted;
        this.creationTime = creationTime;
        this.updationTime = updationTime;
        this.reiRole = reiRole;
        this.version=version;
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

    @Column(name = "NAME", nullable = false, length = 50)
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "CONTACT_NO", nullable = false, length = 15)
    public String getContactNo() {
        return this.contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    @Column(name = "EMAIL", nullable = false, length = 50)
    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "IS_DELETED", nullable = false)
    public int getIsDeleted() {
        return this.isDeleted;
    }

    public void setIsDeleted(int isDeleted) {
        this.isDeleted = isDeleted;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CREATION_TIME", nullable = false, length = 19)
    public Date getCreationTime() {
        return this.creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "UPDATION_TIME", nullable = false, length = 19)
    public Date getUpdationTime() {
        return this.updationTime;
    }

    public void setUpdationTime(Date updationTime) {
        this.updationTime = updationTime;
    }

    @Transient
    public Integer getReiRole() {
        return reiRole;
    }

    public void setReiRole(Integer reiRole) {
        this.reiRole = reiRole;
    }

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "ADDRESS_ID")
    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Column(name = "VERSION", nullable = false)
    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

}
