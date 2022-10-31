package com.project.backend.api.user.service;

import com.project.backend.api.user.error.UserErrorCode;
import com.project.backend.api.news.model.domain.News;
import com.project.backend.api.news.model.domain.NewsContents;
import com.project.backend.api.user.model.domain.QMembers;
import com.project.backend.api.user.model.dto.LoginMemberDTO;
import com.project.backend.api.user.model.dto.MemberSession;
import com.project.backend.api.user.service.repository.MemberRepository;
import com.project.backend.api.user.model.domain.Members;
import com.project.backend.api.user.model.dto.JoinMemberDTO;
import com.project.backend.config.exception.BadRequestException;
import com.project.backend.config.exception.NotFoundException;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class MemberService implements IMemberService{

    private final JPAQueryFactory factory;

    private final EntityManager em;

    private final MemberRepository memberRepo;


    @Transactional
    public boolean insertMember(JoinMemberDTO param) {
        Members member = Members.builder().
                nickname(param.getNickname()).
                loginId(param.getLoginId()).
                password(param.getPassword()).
                userType(param.getUserType()).
                build();

//        NewsContents con = new NewsContents();
//
//        News news = News.builder()
//                .title("")
//                .postingTime("djWJrh")
//                .newsContentsId(con)
//                .build();
        Optional<Members> loginIdCheck = memberRepo.findByLoginId(param.getLoginId());
        if(!loginIdCheck.isEmpty()){
            throw new BadRequestException(UserErrorCode.ALREADY_LOGIN_ID);
        }
        Optional<Members> nickNameCheck = memberRepo.findBynickname(param.getNickname());
        if(!nickNameCheck.isEmpty()){
            throw new BadRequestException(UserErrorCode.ALREADY_NICKNAME);
        }
        memberRepo.saveAndFlush(member);
        return true;
    }

    @Override
    public MemberSession findByLoginIdAndPassword(LoginMemberDTO login) {
        Members member = memberRepo.findByLoginIdAndPassword(login.getLoginId(), login.getPassword());
        MemberSession sessionItem = Members.getMemberSession(member);

        return sessionItem;
    }

    @Override
    public void querySelectMember(long id) {
        Members mem = null;
        try{
            mem = memberRepo.querySelectMember(id);
        }catch(Exception e){
            throw new NotFoundException(UserErrorCode.NOT_FOUND);
        }

        //또 다른 에러 처리
        mem = memberRepo.findById(id).orElseThrow(()-> new NotFoundException(UserErrorCode.NOT_FOUND));

    }

    @Override
    public void queryDSLSample(long id) {

        QMembers members = QMembers.members;

        //MemberSession DTO로 변환해서 select 해오는 경우임
        MemberSession session = factory.from(members)
                        .select(Projections.bean(MemberSession.class,members.memberId,
                                members.nickname
                        ))
                        .where(members.memberId.eq(id))
                        .fetchOne();

        //original
        Members member = factory.from(members)
                        .select(members)
                                .where(members.memberId.eq(id)).fetchOne();



    }
}
