package com.project.backend.api.user.service;

import com.project.backend.api.user.model.dto.JoinMemberDTO;
import com.project.backend.api.user.model.dto.LoginMemberDTO;
import com.project.backend.api.user.model.dto.MemberSession;

public interface IMemberService {
    boolean insertMember(JoinMemberDTO param);

    MemberSession findByLoginIdAndPassword(LoginMemberDTO login);

    void querySelectMember(long id);

    void queryDSLSample(long id);
}
