package com.project.backend.api.news.service.repository;

import com.project.backend.api.news.model.domain.News;
import com.project.backend.api.news.model.dto.CreateNewDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface NewsRepository extends JpaRepository<News,Long> {
        @Query(value = "select n from News n where n.postingTime <= now()")
    List<News> selectNewsList();


    //List<News> findAllNew();
}
