package backend.blog.controller;

import backend.blog.domain.Question;
import backend.blog.repository.QuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@RequiredArgsConstructor                            // final이 붙은 속성을 포함하는 생성자를 자동으로 생성
@Controller
public class QuestionController {
    private final QuestionRepository questionRepository;
    
    @GetMapping("/question/list")
//    @ResponseBody
    public String list(Model model) {               // 매개 변수 Model이 객체를 자동 생성
        List<Question> questionList = this.questionRepository.findAll();
        model.addAttribute("questionList", questionList);       // questionList 데이터를 questionList라는 이름으로 model 객체에 저장
        return "question_list";
    }
}
