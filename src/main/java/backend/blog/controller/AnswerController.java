package backend.blog.controller;

import backend.blog.domain.Question;
import backend.blog.service.AnswerService;
import backend.blog.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/answer")
@RequiredArgsConstructor
@Controller
public class AnswerController {
    private final QuestionService questionService;
    private final AnswerService answerService;

    @PostMapping("/create/{id}")
    public String createAnswer(Model model, @PathVariable("id") Integer id, @RequestParam(value = "content") String content) {
        Question question = this.questionService.getQuestion(id);           // id를 통해 QuestionService의 question 내용 가져오기)
        this.answerService.create(question, content);                       // 윗줄에서 선언한 question 객체를 넣음
        return String.format("redirect:/question/detail/%d", id);           // 변수 id 값을 넣기 위한 포맷팅
    }
}
