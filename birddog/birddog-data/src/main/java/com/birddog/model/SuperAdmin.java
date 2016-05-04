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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author Aartek
 */
@Entity
@Table(name = "super_admin")
public class SuperAdmin {

    private Integer id;
    private Address address;
    private String name;
    private String email;
    private String contactNo;
    private int isDeleted;
    private Date creationTime;
    private Date updationTime;
    private String imageName;
    private String videoName;

    @Column(name = "VIDEO_NAME", length = 80)
    public String getVideoName() {
        return videoName;
    }

    public void setVideoName(String videoName) {
        this.videoName = videoName;
    }

    @Column(name = "IMAGE_NAME", length = 50)
    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public SuperAdmin() {
    }

    public SuperAdmin(Address address, String name, String email, String contactNo, int isDeleted, Date creationTime,
                    Date updationTime) {
        this.address = address;
        this.name = name;
        this.email = email;
        this.contactNo = contactNo;
        this.isDeleted = isDeleted;
        this.creationTime = creationTime;
        this.updationTime = updationTime;
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
    @JoinColumn(name = "ADDRESS_ID", nullable = false)
    public Address getAddress() {
        return this.address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Column(name = "NAME", nullable = false, length = 50)
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "EMAIL_ID", nullable = false, length = 50)
    public String getEmail() {
        return this.email;
    }

    public void setEmail(String emailId) {
        this.email = emailId;
    }

    @Column(name = "CONTACT_NO", nullable = false, length = 15)
    public String getContactNo() {
        return this.contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
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

}
