package com.spring.mvc.score;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

//경로를 mapper 경로와 똑같은 경로로 resources 안에 만들어야함
@Mapper
public interface ScoreMapper {

    //점수 저장
    boolean save(Score score);

    //전체 점수 정보 조회
    List<Score> findAll();

    //개별 점수 정보 조회
    Score findOne(int stuNum);

    //점수 삭제
    boolean remove(int stuNum);
}
