package com.masterpiece.securedDataPlatform.controllers;

import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.S3Object;
import com.masterpiece.securedDataPlatform.entities.Document;
import com.masterpiece.securedDataPlatform.services.AmazonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@RestController
@RequestMapping("/api/storage/")
@CrossOrigin("http://localhost:3000")
public class FileStorageController {
    private AmazonClient amazonClient;

    @Autowired
    FileStorageController(AmazonClient amazonClient) {
        this.amazonClient = amazonClient;
    }

    @PostMapping("/uploadFile")
    public String uploadFile(@RequestPart(value = "file") MultipartFile file,@RequestPart(value = "recipientEmail") String recipientEmail) throws Exception {
        return this.amazonClient.uploadFile(file,recipientEmail);
    }

    @DeleteMapping("/deleteFile")
    public String deleteFile(@RequestPart(value = "url") String fileUrl) throws Exception {
        return this.amazonClient.deleteFileFromS3Bucket(fileUrl);
    }

    @GetMapping("/download/{id}")
    @ResponseBody
    public String getFile(@PathVariable(value = "id") Long id) throws IOException {
       return this.amazonClient.getFile(id);
    }
}