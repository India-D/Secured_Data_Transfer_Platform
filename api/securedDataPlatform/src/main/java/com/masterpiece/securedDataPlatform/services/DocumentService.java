package com.masterpiece.securedDataPlatform.services;

import com.masterpiece.securedDataPlatform.dtos.DocumentViewDto;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


@Service
public interface DocumentService {
    public void saveFile(MultipartFile file);

    public void getFiles();

    public List<DocumentViewDto> findAll();
}
