//package com.project.backend.api.user.model.domain;
//
//import org.springframework.data.jpa.domain.support.AuditingEntityListener;
//
//import javax.persistence.*;
//import java.time.LocalDateTime;
//
///**
// * BaseEntity
// * 도메인 객체를 만들 때 반드시 extend 한다.
// * @author  leedy
// */
//@MappedSuperclass
//@EntityListeners(value = AuditingEntityListener.class)
//public class BaseEntity {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY) //생성 시 1씩 자동 증가
//    protected long id;
//
//    protected long inputId;
//
//    protected LocalDateTime createDate;
//
//    protected long updateId;
//
//    protected LocalDateTime updateDate;
//}
