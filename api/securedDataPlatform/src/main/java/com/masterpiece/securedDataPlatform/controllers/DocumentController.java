package com.masterpiece.securedDataPlatform.controllers;

import com.masterpiece.securedDataPlatform.dtos.DocumentViewDto;
import com.masterpiece.securedDataPlatform.entities.Document;
import com.masterpiece.securedDataPlatform.services.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/uploadFiles")
public class DocumentController {

    @Autowired
    private DocumentService documentService;

    @GetMapping("/")
    protected List<DocumentViewDto> getFiles() {
        return documentService.findAll();
    }

    @PostMapping
    protected void saveFile(@Valid @RequestBody MultipartFile[] files) {

        for (MultipartFile file : files) {
            String name = file.getOriginalFilename();
            try {
                Document document = new Document(name, file.getContentType(), file.getBytes());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
