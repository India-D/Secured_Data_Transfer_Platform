package com.masterpiece.securedDataPlatform.dtos;

import com.masterpiece.securedDataPlatform.entities.Member;

import java.util.Date;

public interface DocumentDto {
    String getName();

    String getType();

    Date getDownloadDate();

    Date getUploadDate();

    Member getMemberRecipient();

    String getMemberRecipientEmail();

    Member getMemberSender();
}
