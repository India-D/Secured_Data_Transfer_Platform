package com.masterpiece.securedDataPlatform.dtos;

import com.masterpiece.securedDataPlatform.entities.Member;

import javax.validation.constraints.*;
import java.util.Date;

public class DocumentViewDto {

    @NotEmpty
    @Size(max = 200)
    private String name;

    @NotEmpty
    @Size(max = 200)
    private String type;

    @NotNull
    private Date uploadDate;

    private Date downloadDate;

    private String fileUrl;

    private String filePath;

    @Size(max = 200)
    private Member memberRecipient;

    @NotEmpty
    @Size(max = 250)
    @Email
    //@Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^?&*_=+-]).{8,50}$", message = "Invalid email address")
    private String memberRecipientEmail;


    @NotEmpty
    @Size(max = 200)
    private Member memberSender;

    public DocumentViewDto() {
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

    public Date getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(Date uploadDate) {
        this.uploadDate = uploadDate;
    }

    public Date getDownloadDate() {
        return downloadDate;
    }

    public void setDownloadDate(Date downloadDate) {
        this.downloadDate = downloadDate;
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

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

}
