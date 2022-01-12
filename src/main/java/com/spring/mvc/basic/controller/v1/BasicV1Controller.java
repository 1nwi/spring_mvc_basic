package com.spring.mvc.basic.controller.v1;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

// HTTP API 방식 : REST API 사용

//컨트롤러 : 브라우저의 요청을 받아서 처리
@Controller   // @ Component 와 같음.  명시적으로 컨트롤러 역할임을 표시
public class BasicV1Controller {

    //요청 처리 메서드

    @GetMapping("/v1/hello")  // 클라이언트가 /v1/hello 라고 GET으로 여청했을 시 작동
    @ResponseBody  // 응답 내용에 관한 것, 브라우저에게 데이터를 직접 리턴
    public String hello() {
        System.out.println("/v1/hello GET 요청!! 발생!!");
        return "안녕~~ 손님~~!!";
    }

    @GetMapping("/sign-in")
    @ResponseBody
    public String login() {
        System.out.println("/sign-in GET!! 요청!!");
        return "로그인 요청하셨어요?";
    }

    @GetMapping("/food/menu")
    @ResponseBody
    public List<String> foodMenu() {
        List<String> foodList = new ArrayList<>();
        foodList.add("볶음밥");
        foodList.add("탕수육");
        foodList.add("짜장면");
        foodList.add("짬짜면");

        return foodList;
    }

    @GetMapping("/hobby")
    @ResponseBody
    public Map<String, String> hobby() {
        Map<String, String> hobbies = new HashMap<>();
        hobbies.put("activity", "축구");
        hobbies.put("study", "영어회화");
        hobbies.put("home", "영화감상");

        return hobbies;

    }

    @GetMapping("/user/info")
    @ResponseBody
    public UserInfo userInfo() {
        return new UserInfo("고길동", "대전시 서구", 40, Arrays.asList("청소", "요리", "농구"));
    }

    @GetMapping("/user/all")
    @ResponseBody
    public List<UserInfo> allUsers() {
        List<UserInfo> users = new ArrayList<>();
        users.add(new UserInfo("김철수", "대전", 24, Arrays.asList("청소", "요리", "농구")));
        users.add(new UserInfo("박영희", "서울", 27, Arrays.asList("축구", "야구", "배구")));
        users.add(new UserInfo("홍길동", "부산", 12, Arrays.asList("먹기", "자기", "놀기")));

        return users;
    }

}
