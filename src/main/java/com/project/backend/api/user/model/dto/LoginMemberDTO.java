package com.project.backend.api.user.model.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
@Setter
public class LoginMemberDTO {

    private String loginId;

    private String password;
}
