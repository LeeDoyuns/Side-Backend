package com.project.backend.api.news.model.dto;

import com.project.backend.api.news.model.domain.NewsContents;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

/**
 * 기사작성할 기사의 정보를 받는 dto  class
 * @author byj
 */
@RequiredArgsConstructor
@Getter
@Setter
public class CreateNewDTO {
    private String title;
    private String category;
    private String postingTime;
    private String newsStatus;
    //private NewsContents contentsId;
    private String contents;
    long[] imgIdArr;

    long reporterId;
}
