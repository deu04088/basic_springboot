package backend.blog.service;

import backend.blog.DataNotFoundException;
import backend.blog.domain.Question;
import backend.blog.repository.QuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class QuestionService {
    private final QuestionRepository questionRepository;

    public List<Question> getList() {
        return this.questionRepository.findAll();
    }

    public Question getQuestion(Integer id) {
        Optional<Question> question = this.questionRepository.findById(id);
        if (question.isPresent()) {
            return question.get();                          // Optional이 값을 가지고 있을 때 반환
        }
        else {
            throw new DataNotFoundException("question not found");
        }
    }
}
