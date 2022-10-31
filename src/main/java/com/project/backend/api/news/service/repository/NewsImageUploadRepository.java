package com.project.backend.api.news.service.repository;

import com.project.backend.api.news.model.domain.NewsImage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NewsImageUploadRepository extends JpaRepository<NewsImage, Long> {
}
