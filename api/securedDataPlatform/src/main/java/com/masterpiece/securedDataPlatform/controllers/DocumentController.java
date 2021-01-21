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

/*    @PostMapping
    protected void create(@Valid @RequestBody MultipartFile[] files) throws IOException {
        documentService.create(files);

    }*/


}
