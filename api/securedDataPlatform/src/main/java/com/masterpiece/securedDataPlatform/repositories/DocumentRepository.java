package com.masterpiece.securedDataPlatform.repositories;

import com.masterpiece.securedDataPlatform.entities.Document;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentRepository extends JpaRepository<Document, Long> {

}
