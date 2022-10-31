package com.project.backend.api.news.model.domain;

import lombok.Builder;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity(name="IMG_M")
@DynamicInsert
@DynamicUpdate
@NoArgsConstructor
public class NewsImage {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long newsImageId;

    private String originImgNm;

    private String imgNm;

    private String imgPath;

    private long inputId;

    private LocalDateTime createDate;

    private long updateId;

    private LocalDateTime updateDate;


    @Builder
    public NewsImage (
            String originImgNm,
            String saveImgNm,
            String path,
            long inputId
    ){
        this.originImgNm = originImgNm;
        this.imgNm = saveImgNm;
        this.imgPath = path;
        this.inputId = inputId;
        this.updateId = inputId;
    }


    public Long getId(){
        return newsImageId;
    }

}
