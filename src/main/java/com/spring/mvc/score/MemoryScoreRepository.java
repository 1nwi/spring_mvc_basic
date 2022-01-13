package com.spring.mvc.score;

import com.spring.mvc.employee.Employee;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
@Log4j2
public class MemoryScoreRepository implements ScoreRepository {

    private static Map<Integer, Score> scoreMap = new HashMap<>();

    static {
        scoreMap.put(1, new Score("김철수",98,87,56));
        scoreMap.put(2, new Score("홍길동",78,65,54));
        scoreMap.put(3, new Score("박영희",23,99,67));
    }

    @Override
    public void save(Score score) {
        scoreMap.put(score.getStuNum(), score);
        log.info(scoreMap);
    }

    @Override
    public List<Score> findAll() {
        List<Score> scores = new ArrayList<>();
        for (Integer key : scoreMap.keySet()) {
            scores.add(scoreMap.get(key));
        }
        return scores;
    }

    @Override
    public Score findOne(int stuNum) {
        return null;
    }


    @Override
    public void remove(int stuNum) {
        scoreMap.remove(stuNum);
    }
}
