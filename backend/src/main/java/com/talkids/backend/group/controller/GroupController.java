package com.talkids.backend.group.controller;

import com.talkids.backend.common.utils.ApiUtils.ApiResult;
import com.talkids.backend.group.dto.GroupDto;
import com.talkids.backend.group.entity.Group;
import com.talkids.backend.group.service.GroupService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

import static com.talkids.backend.common.utils.ApiUtils.success;

@RestController
@RequiredArgsConstructor
@RequestMapping("/group")
public class GroupController {

    private final GroupService groupService;

    /** 선생님 - 회원별 그룹 리스트 조회 */
    @GetMapping("/{memberId}")
    public ApiResult<List<Group>> getGroupList(@PathVariable int memberId) throws Exception {
        List<Group> groupList = groupService.getGroupList(memberId);
        Collections.reverse(groupList); // 생성 최신순으로

        return success(groupList);
    }

    /** 선생님 - 그룹 개설 */
    @PostMapping
    public ApiResult<Integer> createGroup(@Valid @RequestBody GroupDto.Request req) throws Exception {
        return success(groupService.createGroup(req));
    }

//    /** 학생 - 그룹 신청 */
//    @PostMapping("/join")
//    public ApiResult<Integer> joinGroup(@Valid @RequestBody GroupJoinMemberDto.Request req) throws Exception {
//        return success(groupService.joinGroup(req));
//    }

}
