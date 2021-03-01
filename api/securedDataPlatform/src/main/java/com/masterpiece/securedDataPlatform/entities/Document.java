package com.masterpiece.securedDataPlatform.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Email;
import java.util.Date;

@Entity
public class Document extends AbstractEntity {

    @Column(length = 200, nullable = false)
    private String name;

    @Column(length = 200, nullable = false)
    private String type;

    @Column(nullable = false)
    private String fileUrl;

    @Column(nullable = true)
    private Date downloadDate;

    @Column(nullable = true)
    private Date uploadDate;

    @ManyToOne
    private Member memberRecipient;

    @Column(length = 250, nullable = false)
    @Email
   // @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^?&*_=+-]).{8,50}$", message = "Invalid email address")
    private String memberRecipientEmail;

    @ManyToOne
    private Member memberSender;


    public Document() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    public Date getDownloadDate() {
        return downloadDate;
    }

    public void setDownloadDate(Date downloadDate) {
        this.downloadDate = downloadDate;
    }

    public Date getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(Date uploadDate) {
        this.uploadDate = uploadDate;
    }

    public Member getMemberRecipient() {
        return memberRecipient;
    }

    public void setMemberRecipient(Member memberRecipient) {
        this.memberRecipient = memberRecipient;
    }

    public String getMemberRecipientEmail() {
        return memberRecipientEmail;
    }

    public void setMemberRecipientEmail(String memberRecipientEmail) {
        this.memberRecipientEmail = memberRecipientEmail;
    }

    public Member getMemberSender() {
        return memberSender;
    }

    public void setMemberSender(Member memberSender) {
        this.memberSender = memberSender;
    }

}
