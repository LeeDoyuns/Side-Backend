package com.project.backend.api.news.controller;

import com.project.backend.api.news.error.NewsErrorCode;
import com.project.backend.config.exception.InternalServerErrorException;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@RestControllerAdvice
@RequestMapping("/api")
public class NewsImageViewController {

    @Value("${spring.servlet.multipart.location}")
    private String fileUploadPath;


    @GetMapping("/news/viewImage/{fileNm}")
    public ResponseEntity<Resource> imageView(HttpServletRequest req, @PathVariable String fileNm){

        Resource resource = new FileSystemResource(fileUploadPath + "/" + fileNm);
        if(!resource.exists()){
            new InternalServerErrorException(NewsErrorCode.NOT_FOUND_IMAGE);
        }

        HttpHeaders headers = new HttpHeaders();
        Path filePath = null;
        try{
            filePath = Paths.get(fileUploadPath+"/"+fileNm);
            headers.add("Content-Type", Files.probeContentType(filePath));

        }catch(Exception e){
            e.printStackTrace();
            new InternalServerErrorException(NewsErrorCode.NOT_FOUND_IMAGE);
        }

        return new ResponseEntity<Resource>(resource, headers, HttpStatus.OK);
    }

}
