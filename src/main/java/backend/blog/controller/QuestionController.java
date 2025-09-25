package backend.blog.controller;

import backend.blog.domain.Question;
import backend.blog.repository.QuestionRepository;
import backend.blog.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/question")
@RequiredArgsConstructor                            // final이 붙은 속성을 포함하는 생성자를 자동으로 생성
@Controller
public class QuestionController {
    private final QuestionService questionService;
    
    @GetMapping("/list")
//    @ResponseBody
    public String list(Model model) {               // 매개 변수 Model이 객체를 자동 생성
        List<Question> questionList = this.questionService.getList();
        model.addAttribute("questionList", questionList);       // questionList 데이터를 questionList라는 이름으로 model 객체에 저장
        return "question_list";
    }

    @GetMapping(value = "/detail/{id}")
    public String detail(Model model, @PathVariable("id") Integer id) {
        Question question = this.questionService.getQuestion(id);
        model.addAttribute("question", question);
        return "question_detail";
    }

    @GetMapping("/create")
    public String questionCreate() {
        return "question_create";
    }

    @PostMapping("/create")
    public String questionCreate(@RequestParam(value="subject") String subject, @RequestParam(value="content") String content) {
        this.questionService.create(subject, content);
        return "redirect:/question/list";
    }
}
