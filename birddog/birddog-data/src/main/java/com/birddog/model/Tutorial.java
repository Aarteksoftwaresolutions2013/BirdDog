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
@Table(name = "tutorial")
public class Tutorial {

    private Integer id;
    private ReInvestor reInvestor;
    private String type;
    private String audience;
    private int attachmentId;
    private String contentDetails;
    private int isDeleted;
    private Date creationTime;
    private Date updationTime;

    public Tutorial() {
    }

    public Tutorial(ReInvestor reInvestor, String type, String audience, int attachmentId, String contentDetails,
                    int isDeleted, Date creationTime, Date updationTime) {
        this.reInvestor = reInvestor;
        this.type = type;
        this.audience = audience;
        this.attachmentId = attachmentId;
        this.contentDetails = contentDetails;
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "REI_ID", nullable = false)
    public ReInvestor getReInvestor() {
        return this.reInvestor;
    }

    public void setReInvestor(ReInvestor reInvestor) {
        this.reInvestor = reInvestor;
    }

    @Column(name = "TYPE", nullable = false, length = 50)
    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Column(name = "AUDIENCE", nullable = false, length = 100)
    public String getAudience() {
        return this.audience;
    }

    public void setAudience(String audience) {
        this.audience = audience;
    }

    @Column(name = "ATTACHMENT_ID", nullable = false)
    public int getAttachmentId() {
        return this.attachmentId;
    }

    public void setAttachmentId(int attachmentId) {
        this.attachmentId = attachmentId;
    }

    @Column(name = "CONTENT_DETAILS", nullable = false, length = 200)
    public String getContentDetails() {
        return this.contentDetails;
    }

    public void setContentDetails(String contentDetails) {
        this.contentDetails = contentDetails;
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
