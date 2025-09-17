package backend.blog.repository;

import backend.blog.domain.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Integer> {              // 기본키가 Integer인 Question 엔티티로 레포지터리를 생성 의미
    Question findBySubject(String subject);                 // 사용자 메서드 추가
    Question findBySubjectAndContent(String subject, String content);
    List<Question> findBySubjectLike(String subject);
}
