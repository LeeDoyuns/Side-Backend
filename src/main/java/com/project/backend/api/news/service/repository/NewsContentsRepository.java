package com.project.backend.api.news.service.repository;

import com.project.backend.api.news.model.domain.News;
import com.project.backend.api.news.model.domain.NewsContents;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NewsContentsRepository extends JpaRepository<NewsContents,Long> {


}
