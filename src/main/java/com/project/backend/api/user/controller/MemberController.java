package com.project.backend.api.user.controller;

import com.project.backend.api.common.UserType;
import com.project.backend.api.user.model.dto.JoinMemberDTO;
import com.project.backend.api.user.model.dto.LoginMemberDTO;
import com.project.backend.api.user.model.dto.MemberSession;
import com.project.backend.api.user.model.dto.MemberTypeDTO;
import com.project.backend.common.ResponseObject;
import com.project.backend.api.user.service.IMemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/member")
@RequiredArgsConstructor
@RestControllerAdvice
@Slf4j
public class MemberController {

    private final IMemberService memberService;

    @PostMapping("/join-user")
    public ResponseEntity<ResponseObject<Boolean>> joinUser(@RequestBody JoinMemberDTO param){
        ResponseObject<Boolean> result = new ResponseObject<>();
        boolean flag = memberService.insertMember(param);
        result.set(flag);
        return new ResponseEntity<ResponseObject<Boolean>>(result, HttpStatus.OK);
    }

    /**
     * login, session처리
     * @param login
     * @author leedy
     * @return
     */
    @PostMapping("/login")
    public ResponseEntity<ResponseObject<MemberSession>> loginUser (@RequestBody LoginMemberDTO login){
        ResponseObject<MemberSession> result = new ResponseObject<>();
        MemberSession loginInfo = memberService.findByLoginIdAndPassword(login);    //loginId와 password로 유저 조회

        //redisSession에 등록
       // session.setAttribute(generateKey(loginInfo.getId()),loginInfo);

        result.set(loginInfo);

        //key값인 id와 nickname 리턴
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    //session에 등록할 key값 생성
    private String generateKey(long id){
        return "user::"+id;
    }


    @GetMapping("/sampleTest")
    public String test(){
        thisSample();
        return "test";
    }

    /**
     * 샘플 예제
     * @author  leedy
     */
    public void thisSample(){

        //@Query예제
        long id = 2;
//        memberService.querySelectMember(id);

        //QueryDSL 예제
        memberService.queryDSLSample(id);
    }

    @RequestMapping("/memberType")
    public ResponseEntity<List<MemberTypeDTO>> getMemberType(){

        UserType[] type = UserType.values();
        List<MemberTypeDTO> list = new ArrayList<>();
        for(int i=0; i<type.length; i++){
            String name = type[i].name();
            String typeName = type[i].getMessage();

           list.add( new MemberTypeDTO(name,typeName));
        }

        return new ResponseEntity<>(list,HttpStatus.OK);
    }

}
