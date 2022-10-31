package com.project.backend.api.user.model.dto;

import lombok.*;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class MemberSession implements Serializable {

    private long id;

    private String nickname;
    private String userType;


    public MemberSession convertMemberSession(String str) throws ParseException {
        JSONParser parser=  new JSONParser();
        JSONObject json = (JSONObject) parser.parse(str);

        return new MemberSession(Long.parseLong(json.get("id").toString()), json.get("nickname").toString(), json.get("userType").toString());

    }
}
