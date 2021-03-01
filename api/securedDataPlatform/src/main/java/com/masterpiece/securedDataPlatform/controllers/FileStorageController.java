package com.masterpiece.securedDataPlatform.controllers;

import com.masterpiece.securedDataPlatform.repositories.DocumentRepository;
import com.masterpiece.securedDataPlatform.services.AmazonClient;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/storage/")
@CrossOrigin("http://localhost:3000")
public class FileStorageController {
    private AmazonClient amazonClient;
    private DocumentRepository documentRepository;

    public FileStorageController(AmazonClient amazonClient, DocumentRepository documentRepository) {
        this.amazonClient = amazonClient;
        this.documentRepository = documentRepository;
    }

    @PostMapping("/uploadFile")
    public String uploadFile(@RequestPart(value = "file") MultipartFile file, @RequestPart(value = "recipientEmail") String recipientEmail) throws Exception {
        return this.amazonClient.uploadFile(file, recipientEmail);
    }

    @DeleteMapping("/deleteFile")
    public String deleteFile(@RequestPart(value = "url") String fileUrl) throws Exception {
        return this.amazonClient.deleteFileFromS3Bucket(fileUrl);
    }

    @GetMapping("/download/{id}")
    public ResponseEntity<ByteArrayResource> getFile(@PathVariable(value = "id") Long id) throws IOException {
        byte[] fileByte = amazonClient.getFile(id);
        ByteArrayResource byteArrayResources = new ByteArrayResource(fileByte);
        String name = amazonClient.getFileName(id);
        String contentType = amazonClient.getContentType(id);

        return ResponseEntity.ok().contentLength(byteArrayResources.contentLength()).contentType(MediaType.parseMediaType(contentType)).header("Content-Disposition", "attachment; filename= " + name).body(byteArrayResources);
    }


    //  @PostMapping("/download/{id}")
    //  public String getFile(@PathVariable(value = "id") Long id, @RequestPart(value = "filePath") String filePath) throws IOException {
    //     return this.amazonClient.getFile(id, filePath);
    // }

}