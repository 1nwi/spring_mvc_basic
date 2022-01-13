package com.spring.mvc.score;


import com.spring.mvc.employee.Employee;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@Log4j2
public class ScoreController {

    private final ScoreRepository scoreRepository;

    @Autowired
    public ScoreController(ScoreRepository scoreRepository) {
        this.scoreRepository = scoreRepository;
    }

    @GetMapping("/score/form")
    public String scoreList() {
        log.info("/score/form GET 요청 발생!");
        return "score/score-list";
    }

    @PostMapping("/score/register")
    public String register(Score score) {
        log.info("/score/register POST - " + score);
        scoreRepository.save(score);
        return "redirect:/score/list";
    }

    @GetMapping("/score/list")
    public String list(Model model) {
        log.info("/score/list GET !");
        List<Score> scoreList = scoreRepository.findAll();

        model.addAttribute("scores",scoreList);
        return "score/score-list";
    }

    @GetMapping("/score/delete")
    public String delete(int stuNum) {
        log.info("/emp/delete GET !");
        scoreRepository.remove(stuNum);
        return "redirect:/score/list";
    }
}
