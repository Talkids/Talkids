package com.talkids.backend.dto;

import com.talkids.backend.entity.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

public class DmRoomJoinDto {

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Request{

        private int dmRoomId;
        private int memberId;

        @Builder
        public static DmJoinMember saveDmRoomJoinDto(DmRoom dmRoom, Member member){
            return DmJoinMember.builder()
                    .dmRoom(dmRoom)
                    .member(member)
                    .build();
        }
    }

}
