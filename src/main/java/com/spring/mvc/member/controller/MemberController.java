package com.spring.mvc.member.controller;

import com.spring.mvc.board.domain.Board;
import com.spring.mvc.member.domain.Member;
import com.spring.mvc.member.service.LoginFlag;
import com.spring.mvc.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

//컨트롤러: 클라이언트가 처음 마주치는 진입점. 요청을 받는다
//        ->서비스한테 요청처리 전달 -> 서비스가 컨트롤러에게 처리 결과를 알려줌 -> 클라이언트에게 결과전달
@Controller
@Log4j2
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    //회원가입 화면 요청
    @GetMapping("/join")
    public String join() {
        return "member/join";
    }

    //아이디 중복확인 비동기 통신요청
    @GetMapping("/check")
    @ResponseBody
    public boolean check(String checkId) {
        return memberService.isDuplicateId(checkId);
    }

    @GetMapping("/check2")
    @ResponseBody
    public boolean check2(String checkEmail) {
        return memberService.isDuplicateEmail(checkEmail);
    }

    //회원가입 처리 요청
    @PostMapping("/member/sign-up")
    public String signUp(Member member) {
        log.info("/member/sign-up POST - " + member);
        memberService.signUp(member);
        return "redirect:/";
    }

    //로그인 화면 요청
    @GetMapping("/login")
    public String login() {
        return "member/login";
    }

    @PostMapping("/loginCheck")
    public String loginSuccess(String account, String password, Model model, HttpSession session) {
        log.info("/LoginCheck POST - " + account + "," + password);
        LoginFlag flag = memberService.login(account, password);
        model.addAttribute("msg", flag);

        //로그인 성공 시
        if (flag == LoginFlag.SUCCESS) {
            //세션에 로그인 정보를 기록
            session.setAttribute("loginUser", memberService.getMember(account));
            return "redirect:/";
        }

        //아이디 또는 비번이 틀린 경우
        return "member/login";
    }

    //로그아웃 요청
    @GetMapping("/sign-out")
    public String signOut(HttpSession session) {
        Member loginUser = (Member) session.getAttribute("loginUser");
        if (loginUser != null) {
            session.removeAttribute("loginUser");
            session.invalidate(); // 세션 무효화
        }
        return "redirect:/";
    }

}
