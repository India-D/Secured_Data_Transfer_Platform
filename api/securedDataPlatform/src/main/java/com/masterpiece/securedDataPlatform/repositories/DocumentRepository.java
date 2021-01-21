package com.masterpiece.securedDataPlatform.repositories;

import com.masterpiece.securedDataPlatform.dtos.DocumentDto;
import com.masterpiece.securedDataPlatform.entities.Document;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface DocumentRepository extends JpaRepository<Document, Long> {

    List<DocumentDto> findAllByMemberSenderId(Long id);

    Document getDocumentById(Long id);
}
