package com.project.backend.api.news.service;

import com.project.backend.api.news.model.domain.NewsImage;
import com.project.backend.api.news.service.repository.NewsImageUploadRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NewsImageUploadService implements INewsImageUploadService{

    private final NewsImageUploadRepository uploadRepo;

    @Override
    public Long saveImage(NewsImage image) {
        //IMG_M에 INSERT한다.
        return uploadRepo.saveAndFlush(image).getId();

    }
}
