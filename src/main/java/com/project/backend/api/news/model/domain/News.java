package com.project.backend.api.news.model.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity()
@Getter
@NoArgsConstructor
@DynamicInsert
@DynamicUpdate
@Table(name="NEWS_M")
public class News  {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY) //생성 시 1씩 자동 증가
    private long newsId;

    @Column(name="INPUT_ID", columnDefinition = "BIGINT")
    private long inputId;

    @Column(name="CREATE_DATE", columnDefinition = "DATETIME")
    private LocalDateTime createDate;

    @Column(name="UPDATE_ID", columnDefinition = "BIGINT")
    private long updateId;
    @Column(name="UPDATE_DATE", columnDefinition = "DATETIME")
    private LocalDateTime updateDate;


    @Column(name="TITLE")
    private String title;
//    @Column(name = "CONTENTS_ID",columnDefinition = "BIGINT")
    @JoinColumn(name="CONTENTS_ID")
    @JsonIgnore
    @OneToOne(fetch = FetchType.LAZY, targetEntity = NewsContents.class)
    private NewsContents contentsId;
//
    @Column(name="CATEGORY")
    private String category;
    @Column(name="POSTING_TIME", columnDefinition = "DATETIME")
    private LocalDateTime postingTime;
    @Column(name="NEWS_STATUS")
    private String newsStatus;
    @Column(name="HITS")
    private int hits;

    @Builder News(
        long newsId,
        long inputId,
        LocalDateTime createDate,
        long updateId,
        LocalDateTime updateDate,
        String title,
        NewsContents contentsId,
        String category,
        LocalDateTime postingTime,
        String newsStatus,
        int hits
    ){
        this.newsId = newsId;
        this.inputId = inputId;
        this.createDate = createDate;
        this.updateId = updateId;
        this.updateDate = updateDate;
        this.title = title;
        this.contentsId = contentsId;
        this.category = category;
        this.postingTime = postingTime;
        this.newsStatus = newsStatus;
        this.hits = hits;

    }

}
