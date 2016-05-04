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
@Table(name = "comment")
public class Comment {

    private Integer id;
    private UserRole userRole;
    private Lead lead;
    private String commentTitle;
    private String commentDetails;
    private int isDeleted;
    private Date creationTime;
    private Date updationTime;

    public Comment() {
    }

    public Comment(UserRole userRole, Lead lead, String commentTitle, String commentDetails, int isDeleted,
                    Date creationTime, Date updationTime) {
        this.userRole = userRole;
        this.lead = lead;
        this.commentTitle = commentTitle;
        this.commentDetails = commentDetails;
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
    @JoinColumn(name = "ROLE_ID")
    public UserRole getUserRole() {
        return this.userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "LEAD_ID", nullable = false)
    public Lead getLead() {
        return this.lead;
    }

    public void setLead(Lead lead) {
        this.lead = lead;
    }

    @Column(name = "COMMENT_TITLE", nullable = false, length = 50)
    public String getCommentTitle() {
        return this.commentTitle;
    }

    public void setCommentTitle(String commentTitle) {
        this.commentTitle = commentTitle;
    }

    @Column(name = "COMMENT_DETAILS", nullable = false, length = 50)
    public String getCommentDetails() {
        return this.commentDetails;
    }

    public void setCommentDetails(String commentDetails) {
        this.commentDetails = commentDetails;
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
