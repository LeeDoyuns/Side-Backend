package com.project.backend.api.news.model.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
@DynamicInsert
@DynamicUpdate
@Table(name = "NEWS_CONTENTS")
public class NewsContents  {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY) //생성 시 1씩 자동 증가
    private long contentsId;

    @Column(name="INPUT_ID", columnDefinition = "BIGINT")
    private long inputId;

    @Column(name="CREATE_DATE", columnDefinition = "DATETIME")
    private LocalDateTime createDate;

    @Column(name="UPDATE_ID", columnDefinition = "BIGINT")
    private long updateId;
    @Column(name="UPDATE_DATE", columnDefinition = "DATETIME")
    private LocalDateTime updateDate;
    @Column(name="CONTENTS", columnDefinition = "MEDIUMTEXT")
    private String contents;


    @Builder NewsContents(
            String contents,
            long updateId,
            long inputId

    ){
        this.contents = contents;
        this.inputId = inputId;
        this.updateId = updateId;

    }

}