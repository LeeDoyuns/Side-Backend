package com.project.backend.api.user.model.dto;

import lombok.Data;

/**
 * 회원가입할 유저의 정보를 받는 dto  class
 * @author leedy
 */
@Data
public class JoinMemberDTO {
    private String loginId;

    private String nickname;

    private String password;

    private String userType;

}
