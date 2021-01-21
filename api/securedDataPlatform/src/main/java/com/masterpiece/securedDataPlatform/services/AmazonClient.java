package com.masterpiece.securedDataPlatform.services;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.masterpiece.securedDataPlatform.entities.Document;
import com.masterpiece.securedDataPlatform.repositories.DocumentRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

@Service
public class AmazonClient {
    private final DocumentServiceImpl documentService;
    private final DocumentRepository documentRepository;
    //encapsulation
    private AmazonS3 s3client;
    @Value("${s3.endpointUrl}")
    private String endpointUrl;
    @Value("${s3.bucketName}")
    private String bucketName;
    @Value("${s3.accessKeyId}")
    private String accessKeyId;
    @Value("${s3.secretKey}")
    private String secretKey;
    @Value("${s3.region}")
    private String region;

    public AmazonClient(DocumentServiceImpl documentService, DocumentRepository documentRepository) {
        this.documentService = documentService;
        this.documentRepository = documentRepository;
    }

    //initializer method for amazon credentials
    @PostConstruct
    private void initializeAmazon() {
        AWSCredentials credentials
                //new AWSCredentials object created as an instance of BasicAWSCredentials
                = new BasicAWSCredentials(this.accessKeyId, this.secretKey);
        //builder properties for  Amazons3
        this.s3client = AmazonS3ClientBuilder
                .standard()
                .withRegion(region)
                .withCredentials(new AWSStaticCredentialsProvider(credentials))
                .build();
    }

    public String uploadFile(MultipartFile multipartFile, String recipientEmail) throws Exception {
        //initialize variable for the bucket fileurl
        String fileUrl = "";

        //convert the multipartfile to a file
        File file = convertMultiPartToFile(multipartFile);

        //retrieve file's name
        String fileName = generateFileName(multipartFile);


        fileUrl = endpointUrl + "/" + bucketName + "/" + fileName;

        //call the method to retrieve the name's file and the file from the s3Bucket
        uploadFileTos3bucket(fileName, file);

        //once the file is uploaded delete the file from the bucket
        file.delete();

        documentService.create(fileName, fileUrl, recipientEmail);

        return fileUrl;
    }

    public String deleteFileFromS3Bucket(String fileUrl) {
        //retrieve the fileName from the fileUrl
        String fileName = fileUrl.substring(fileUrl.lastIndexOf("/") + 1);
        //delete object (file) from amazonS3
        s3client.deleteObject(bucketName, fileName);
        return "Successfully deleted";
    }

    private void uploadFileTos3bucket(String fileName, File file) {
        //add object to amazonS3
        s3client.putObject(bucketName, fileName, file);
    }

    private File convertMultiPartToFile(MultipartFile file) throws IOException {
        //create an instance of the object File to Return the original filename in the client's filesystem.
        File convFile = new File(file.getOriginalFilename());
        //Creates a file output stream to write to the file represented by the specified File object.
        FileOutputStream fos = new FileOutputStream(convFile);
        //Writes b.length bytes from the specified byte array to this file output stream.
        fos.write(file.getBytes());
        // Closes this file output stream and releases any system resources associated with this stream.
        fos.close();

        return convFile;
    }

    private String generateFileName(MultipartFile multipartFile) {
        return new Date().getTime() + "-" + multipartFile.getOriginalFilename().replace(" ", "_");
    }

    public String getFile(Long id) throws IOException {
        Document document = documentRepository.getDocumentById(id);
        String fileUrl = document.getFileUrl();
        System.out.println(fileUrl);
        String fileName = document.getName();
        //fileUrl = endpointUrl + "/" + bucketName + "/" + fileName;
        File file = new File("/home/india/Documents"+"/"+fileName);
        ObjectMetadata s3Object = s3client.getObject(new GetObjectRequest(bucketName, fileName),file);
        // File multipartFile = convertMultiPartToFile(file);

        // test = s3client.getObject(new GetObjectRequest(bucketName,fileName),file);
/*        InputStream in = test.getObjectContent();

        BufferedReader reader = new BufferedReader(new InputStreamReader(in));*/
        System.out.println(s3Object);
        return fileUrl;
    }


}
