package com.masterpiece.securedDataPlatform.controllers;

import com.masterpiece.securedDataPlatform.dtos.DocumentDto;
import com.masterpiece.securedDataPlatform.services.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/documentController")
public class DocumentController {

    final private DocumentService documentService;

    @Autowired
    public DocumentController(DocumentService documentService) {
        this.documentService = documentService;
    }

    @GetMapping("/{id}")
    protected List<DocumentDto> findAllBySenderId(@PathVariable("id") Long id) {
        return documentService.findAllBySenderId(id);
    }

    @GetMapping("member-recipient/{id}")
    protected List<DocumentDto> findAllByRecipientId(@PathVariable("id") Long id){
        return documentService.findAllByRecipientId(id);
    }



}
