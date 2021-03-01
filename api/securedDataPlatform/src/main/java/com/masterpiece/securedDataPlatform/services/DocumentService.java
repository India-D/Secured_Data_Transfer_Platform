package com.masterpiece.securedDataPlatform.services;

import com.masterpiece.securedDataPlatform.dtos.DocumentDto;
import com.masterpiece.securedDataPlatform.entities.Document;
import com.masterpiece.securedDataPlatform.entities.Member;

import java.io.IOException;
import java.util.List;


public interface DocumentService {

    // void create(MultipartFile[] files) throws IOException;

    // public List<DocumentViewDto> findAll();
    // List<DocumentViewDto> getAllFiles();
    List<DocumentDto> findAllBySenderId(Long id);

    List<DocumentDto> findAllByRecipientId(Long id);

    void create(String fileName, String fileUrl, String recipientEmail) throws IOException;

    void update(Member memberRecipient, Document document);
}
