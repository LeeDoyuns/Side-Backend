package com.project.backend.api.user.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;

@Getter
@AllArgsConstructor
public class MemberTypeDTO implements Serializable {

    private String userType;

    private String typeName;
}
