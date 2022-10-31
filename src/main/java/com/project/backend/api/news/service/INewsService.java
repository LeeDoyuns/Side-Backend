package com.project.backend.api.news.service;

import com.project.backend.api.news.model.domain.News;
import com.project.backend.api.news.model.dto.CreateNewContentsDTO;
import com.project.backend.api.news.model.dto.CreateNewDTO;
import com.project.backend.api.news.model.dto.NewsListDTO;

import java.util.List;

public interface INewsService {
    void createNews(CreateNewDTO param);

    void createNewsContents(CreateNewContentsDTO newContents);

    List<NewsListDTO> selectNewsList();
}
