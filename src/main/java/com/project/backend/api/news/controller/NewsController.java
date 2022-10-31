package com.project.backend.api.news.controller;

import com.project.backend.api.news.model.domain.News;
import com.project.backend.api.news.model.dto.CreateNewContentsDTO;
import com.project.backend.api.news.model.dto.CreateNewDTO;
import com.project.backend.api.news.model.dto.NewsListDTO;
import com.project.backend.api.news.service.INewsService;
import com.project.backend.common.ResponseObject;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/news")
@RequiredArgsConstructor
@RestControllerAdvice
@Slf4j
public class NewsController {

    private final INewsService newsService;

    @PostMapping("/createNews")
    public ResponseEntity<ResponseObject<Boolean>> createNews(@RequestBody CreateNewDTO param){
        ResponseObject<Boolean> result = new ResponseObject<>();
//        param.setNewsStatus();
        newsService.createNews(param);
        result.set(true);
        return new ResponseEntity<ResponseObject<Boolean>>(result,HttpStatus.OK);
    }
    @GetMapping("/selectNewsList")
    public ResponseEntity<ResponseObject<List<NewsListDTO>>> selectNewsList(){
        ResponseObject<List<NewsListDTO>> result = new ResponseObject<>();
        List<NewsListDTO> list = newsService.selectNewsList();
        result.set(list);
        return new ResponseEntity<ResponseObject<List<NewsListDTO>>>(result,HttpStatus.OK);
    }

//    @GetMapping("/deleteNews")
//    public ResponseEntity<ResponseObject<Boolean>> deleteNews(){
//        ResponseObject<List> result = new ResponseObject<>();
////        List<NewsListDTO> list = newsService.selectNewsList();
////        result.set(list);
//        return new ResponseEntity<ResponseObject<List>>(result,HttpStatus.OK);
//    }

}
