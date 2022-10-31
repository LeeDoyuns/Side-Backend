package com.project.backend.api.news.model.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;


@Getter
@Setter
public class NewsListDTO implements Serializable {

    private String title;

    private String category;

    private LocalDateTime postingTime;

    private int hits;

//    @QueryProjection
//    public NewsListDTO(String title, String category, LocalDateTime postingTime, int hits) {
//        this.title = title;
//        this.category = category;
//        this.postingTime = postingTime;
//        this.hits = hits;
//    }
}
