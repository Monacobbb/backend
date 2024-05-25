package CodeMaker.togetherLion.domain.user.controller;

import CodeMaker.togetherLion.domain.user.dto.request.*;
import CodeMaker.togetherLion.domain.user.dto.response.*;
import CodeMaker.togetherLion.domain.user.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("user")
@RequiredArgsConstructor
public class LoginController {

    private final LoginService loginService;

    // 회원가입 : 지수 - 법정동 개발 후 추가, 주소 찾기 부분 분리
    @PostMapping("/signup")
    public SignupResponse signup(@RequestBody SignupRequest signupRequest) {
        return loginService.signup(signupRequest);
    }

    // 주소 찾기
    @PostMapping("/findAddress")
    public FindAddressResponse findAddress(@RequestBody FindAddressRequest findAddressRequest) {
        return loginService.findAddress(findAddressRequest);
    }

    // 로그인 : 지수 - 완료
//    @PostMapping("/login")
//    public LoginResponse login(@RequestBody LoginRequest loginRequest) {
//        return loginService.login(loginRequest);
//    }
    @PostMapping("/login")
    public LoginResponse loginResponse(@RequestBody LoginRequest loginRequest, HttpServletRequest request) {
        LoginResponse loginResponse = loginService.login(loginRequest);

        HttpSession session = request.getSession(true);
        session.setAttribute("userId", loginResponse.getLoginId());

        return loginResponse;
    }

    // 아이디 중복 확인 : 지수 - 완료
    @PostMapping("/idCheck")
    public IdCheckResponse idCheck(@RequestBody IdCheckRequest idCheckRequest) {
        return loginService.idCheck(idCheckRequest);
    }

    // 닉네임 중복 확인 : 지수 - 완료
    @PostMapping("/nicknameCheck")
    public NicknameCheckResponse nicknameCheck(@RequestBody NicknameCheckRequest nicknameCheckRequest) {
        return loginService.nicknameCheck(nicknameCheckRequest);
    }

    // 전화번호 인증 : 지수 - 테스트 필요 + 비밀번호 전송(로그인시도, 비찾)과 멘트 구분 필요 -> 테스트 필요
    @PostMapping("/phoneAuth")
    public PhoneAuthResponse phoneAuth(@RequestBody PhoneAuthRequest phoneAuthRequest) {
        return loginService.phoneAuth(phoneAuthRequest);
    }

    // 아이디 찾기 : 지수 - 완료
    @PostMapping("/findId")
    public FindIdResponse findId(@RequestBody FindIdRequest findIdRequest) {
        return loginService.findId(findIdRequest);
    }

    // 비밀번호 찾기 : 지수 - 완료
    @PostMapping("/findPw")
    public FindPwResponse findPw(@RequestBody FindPwRequest findPwRequest) {
        return loginService.findPw(findPwRequest);
    }

    // 로그아웃 : 지수 - 완료
    @PostMapping("/logout")
    public String logout(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if(session != null) {
            session.invalidate();
        }

        return "logout";
    }

}
