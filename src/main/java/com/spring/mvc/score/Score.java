package com.spring.mvc.score;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter @Getter @ToString
@AllArgsConstructor
public class Score {
    //누적되는 순차번호를 만들기 위함
    private static int seq;

    // 클라이언트가 전달한 데이터
    private String name;
    private int kor, eng, math;

    //자체 생성 데이터
    private int stuNum; //학번
    private int total;  //총점
    private double average; //평균

    public Score() {
        this.stuNum = ++seq;
    }

    public Score(String name, int kor, int eng, int math) {
        this();
        this.name = name;
        this.kor = kor;
        this.eng = eng;
        this.math = math;
    }


}