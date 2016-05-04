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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * 
 * @author Aartek
 *
 */
@Entity
@Table(name="account_settings")
public class AccountSettings {

    private int id, isDeleted;
    private ReInvestor reInvestor;
    private String qs1, qs2, qs3, qs4, qs5AndMore, paymentInterval, productlevel;
    private Date creationTime;
    private Date updationTime;

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "IS_DELETED", nullable = false)
    public int getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(int isDeleted) {
        this.isDeleted = isDeleted;
    }

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "REI_ID")
    public ReInvestor getReInvestor() {
        return reInvestor;
    }

    public void setReInvestor(ReInvestor reInvestor) {
        this.reInvestor = reInvestor;
    }

    @Column(name = "QS_1")
    public String getQs1() {
        return qs1;
    }

    public void setQs1(String qs1) {
        this.qs1 = qs1;
    }

    @Column(name = "QS_2")
    public String getQs2() {
        return qs2;
    }

    public void setQs2(String qs2) {
        this.qs2 = qs2;
    }

    @Column(name = "QS_3")
    public String getQs3() {
        return qs3;
    }

    public void setQs3(String qs3) {
        this.qs3 = qs3;
    }

    @Column(name = "QS_4")
    public String getQs4() {
        return qs4;
    }

    public void setQs4(String qs4) {
        this.qs4 = qs4;
    }

    @Column(name = "QS_5_AND_MORE")
    public String getQs5AndMore() {
        return qs5AndMore;
    }

    public void setQs5AndMore(String qs5AndMore) {
        this.qs5AndMore = qs5AndMore;
    }

    @Column(name = "PAYMENT_INTERVAL")
    public String getPaymentInterval() {
        return paymentInterval;
    }

    public void setPaymentInterval(String paymentInterval) {
        this.paymentInterval = paymentInterval;
    }

    @Column(name = "PRODUCT_LEVEL")
    public String getProductlevel() {
        return productlevel;
    }

    public void setProductlevel(String productlevel) {
        this.productlevel = productlevel;
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
