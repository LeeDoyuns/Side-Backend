package com.project.backend.api.user.model.domain;

import com.project.backend.api.common.UserStatus;
import com.project.backend.api.common.UserType;
import com.project.backend.api.user.model.dto.MemberSession;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity(name = "members")
@Getter
@NoArgsConstructor
@DynamicInsert
@DynamicUpdate
public class Members   {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY) //생성 시 1씩 자동 증가
    private long memberId;

    @Column(name="INPUT_ID", columnDefinition = "BIGINT")
    private long inputId;

    @Column(name="CREATE_DATE", columnDefinition = "DATETIME")
    private LocalDateTime createDate;

    @Column(name="UPDATE_ID", columnDefinition = "BIGINT")
    private long updateId;
    @Column(name="UPDATE_DATE", columnDefinition = "DATETIME")
    private LocalDateTime updateDate;
    @Column(name="login_id")
    private String loginId;

    @Column(name="nickname")
    private String nickname;
    @Column(name="password")
    private String password;
    @Enumerated(EnumType.STRING)
    @Column(name="user_type")
    private UserType userType;

    @Enumerated(EnumType.STRING)    //원래 객체가 들어가지만 Enum을 써서 Status를 제어하는 경우에는 String타입으로 받을것을 명시
    @Column(name="user_status")
    private UserStatus userStatus;

    @Builder
    public Members (

        long memberId, //멤버아이디 a34234이런느낌
        String loginId, // 로그인한 아이디
        String nickname,
        String password,
        String userType,
        LocalDateTime createDate,
        LocalDateTime updateDate

    ){

        this.memberId = memberId;
        this.loginId = loginId;
        this.nickname = nickname;
        this.password = password;
        this.userType = UserType.valueOf(userType);
        this.inputId = 1;   //최초생성
        this.updateId = 1;  //최초 가입 시
        this.userStatus = UserStatus.ACTIVE;
        this.updateDate = updateDate;
        this.createDate = createDate;
    }

    public static MemberSession getMemberSession(Members member){
        return new MemberSession(member.memberId, member.nickname, member.userType.name());
    }

    public void setUpdateData(String password, long updateId, LocalDateTime updateDate){
        //this.
    }

}
