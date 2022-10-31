package com.project.backend.api.news.service;

import com.project.backend.api.news.model.domain.NewsImage;

public interface INewsImageUploadService {
    Long saveImage(NewsImage image);
}
