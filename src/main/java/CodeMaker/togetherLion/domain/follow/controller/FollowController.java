package CodeMaker.togetherLion.domain.follow.controller;

import CodeMaker.togetherLion.domain.follow.dto.request.FollowReq;
import CodeMaker.togetherLion.domain.follow.dto.request.UnfollowReq;
import CodeMaker.togetherLion.domain.follow.dto.response.FollowRes;
import CodeMaker.togetherLion.domain.follow.dto.response.UnfollowRes;
import CodeMaker.togetherLion.domain.follow.service.FollowService;
import CodeMaker.togetherLion.domain.util.SessionUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/follow")
@RequiredArgsConstructor
public class FollowController {

    private final FollowService followService;
    private final SessionUtil sessionUtil;

    // 팔로우
    @PostMapping("")
    public FollowRes follow(@RequestBody FollowReq followReq, HttpServletRequest request) {
        int followingUserId = sessionUtil.getUserIdFromSession(request);
        return followService.follow(followReq, followingUserId);
    }

    // 언팔로우
    @PostMapping("/unfollow")
    public UnfollowRes unfollow(@RequestBody UnfollowReq unfollowReq, HttpServletRequest request) {
        int unfollowingUserId = sessionUtil.getUserIdFromSession(request);
        return followService.unfollow(unfollowReq, unfollowingUserId);
    }
}
