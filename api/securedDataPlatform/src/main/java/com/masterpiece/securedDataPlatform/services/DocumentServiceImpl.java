package com.masterpiece.securedDataPlatform.services;

import com.masterpiece.securedDataPlatform.dtos.DocumentDto;
import com.masterpiece.securedDataPlatform.entities.Document;
import com.masterpiece.securedDataPlatform.entities.Member;
import com.masterpiece.securedDataPlatform.repositories.DocumentRepository;
import com.masterpiece.securedDataPlatform.repositories.MemberRepository;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Date;
import java.util.List;

@Service("documentService")
public class DocumentServiceImpl implements DocumentService {
    private final DocumentRepository documentRepository;
    private final MemberRepository memberRepository;

    public DocumentServiceImpl(DocumentRepository documentRepository, MemberRepository memberRepository) {
        this.documentRepository = documentRepository;
        this.memberRepository = memberRepository;
    }


    public void create(String fileName, String fileUrl, String recipientEmail) throws IOException {
        Document document = new Document();
        Member member = memberRepository.getById((long) 1);
        populateAndSave(document, fileName, fileUrl, recipientEmail, member);
    }

    @Override
    public void update(Member memberRecipient, Document document) {
        document.setMemberRecipient(memberRecipient);
        documentRepository.save(document);
    }

    @Override
    public List<DocumentDto> findAllBySenderId(Long id) {
        return documentRepository.findAllByMemberSenderId(id);
    }

    @Override
    public List<DocumentDto> findAllByRecipientId(Long id) {
        return documentRepository.findAllByMemberRecipientId(id);
    }


    public String getExtension(String fileName) {
        String extension = "";
        extension = fileName.substring(fileName.lastIndexOf(".") + 1);
        return extension;
    }
 /*   private void populateAndSave(Document document,MultipartFile[] files) throws IOException {
        for (MultipartFile file : files) {
           document.setName(file.getName());
           document.setType(getFileExtension(file));
           document.setDate(new Date());
           document.setSize(file.getBytes());
           documentRepository.save(document);
        }*/


    private void populateAndSave(Document document, String fileName, String fileUrl, String recipientEmail, Member member) throws IOException {
        document.setName(fileName);
        document.setUploadDate(new Date());
        document.setFileUrl(fileUrl);
        document.setType(getExtension(fileName));
        document.setMemberRecipientEmail(recipientEmail);
        document.setMemberSender(member);
        documentRepository.save(document);

    }
}
