package com.birddog.model;

import javax.persistence.Transient;

public class SendMail {
    String toMailId, fromMailId, subject, body;
    Integer reiId;

    public String getToMailId() {
        return toMailId;
    }

    public void setToMailId(String toMailId) {
        this.toMailId = toMailId;
    }

    public String getFromMailId() {
        return fromMailId;
    }

    public void setFromMailId(String fromMailId) {
        this.fromMailId = fromMailId;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Transient
    public Integer getReiId() {
        return reiId;
    }

    public void setReiId(Integer reiId) {
        this.reiId = reiId;
    }

}
