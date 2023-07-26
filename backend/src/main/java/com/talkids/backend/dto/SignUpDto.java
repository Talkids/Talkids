package com.talkids.backend.dto;

import com.talkids.backend.entity.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

public class SignUpDto {

    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class Request{

        @NotBlank(message = "이메일을 입력해주세요")
        private String memberMail;

        @NotBlank(message = "비밀번호를 입력해주세요")
        private String memberPassword;

        @NotBlank(message = "이름을 입력해주세요")
        private String memberName;

        private int schoolId;

        private int countryId;

        private int languageId;

        private int memberTypeId;

        @Builder
        public Member saveMemberDto(String encodePassword, School school, Language language, Country country, MemberType memberType){
            return Member.builder()
                    .memberMail(memberMail)
                    .memberPassword(encodePassword)
                    .memberName(memberName)
                    .school(school)
                    .language(language)
                    .country(country)
                    .memberType(memberType)
                    .build();
        }
    }
}
