package com.birddog.model;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "upload_tutorial")
public class UploadTutorial {

    private Integer id;
    private String title;
    private String description;
    private String link;
    private int roleId;
    private String type;
    private int isDeleted;

    @Column(name = "IS_DELETED")
    public int getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(int isDeleted) {
        this.isDeleted = isDeleted;
    }

    @Column(name = "TYPE")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public UploadTutorial() {
    }

    public UploadTutorial(String title, String description, String link, Integer roleId) {

        this.title = title;
        this.description = description;
        this.link = link;
        this.roleId = roleId;

    }

    @Column(name = "ROLE")
    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
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

    @Column(name = "TITLE")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Column(name = "DESCRIPTION")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "LINK")
    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

}
