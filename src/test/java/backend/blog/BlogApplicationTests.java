package backend.blog;

import backend.blog.domain.Answer;
import backend.blog.domain.Question;
import backend.blog.repository.AnswerRepository;
import backend.blog.repository.QuestionRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest                             // 테스트 클래스 임을 의미
class BlogApplicationTests {

    @Autowired                              // 의존성 주입
    private QuestionRepository questionRepository;

    @Autowired
    private AnswerRepository answerRepository;

    @Transactional
	@Test                                   // 테스트 메서드임을 의미
	void testJpa() {
        // id가 2인 Question 데이터 조회 및 가져오기
        Optional<Question> oq = this.questionRepository.findById(2);
        assertTrue(oq.isPresent());
        Question q = oq.get();

        // q에 연결된 Answer 객체를 List 형태로 가져옴
        List<Answer> answerList = q.getAnswers();                               // Question 내 정의된 get과 매칭

        assertEquals(2, answerList.size());                             // Answer 사이즈 확인
        assertEquals("네 자동으로 발생합니다", answerList.get(0).getContent());      // List 내 첫 번째 요소의 Content가 "네 자동으로 생성됩니다"인지 비교 확인

//        Optional<Answer> oa = this.answerRepository.findById(1);
//        assertTrue(oa.isPresent());
//        Answer a = oa.get();
//        assertEquals(2, a.getQuestion().getId());                           // answer 엔티티 내에 id가 2인 question 데이터가 있는지 비교

//        Optional<Question> oq = questionRepository.findById(2);                 // 질문 데이터 조회
//        assertTrue(oq.isPresent());
//        Question q = oq.get();
//
//        Answer a = new Answer();
//        a.setContent("네 자동으로 발생합니다");                                     // 답변 내용(Content) 설정
//        a.setQuestion(q);                                                       // 어떤 질문의 답변인지 연결.
//        a.setCreateDate(LocalDateTime.now());                                   // 시간값 설정
//        this.answerRepository.save(a);                                          // DB에 저장

//        assertEquals(2, this.questionRepository.count());                   // questionRepository에 저장된 전체 Question 수가 2개인지 확인
//        Optional<Question> oq = this.questionRepository.findById(1);                // id가 1인 Question 객체 조회
//        assertTrue(oq.isPresent());                                                 // 실제 Question 값이 있는지 조회
//        Question q = oq.get();                                                      // Optional 안에 Question 객체를 꺼내 q에 저장
//        this.questionRepository.delete(q);                                          // DB에서 해당 Question 객체를 삭제
//        assertEquals(1, this.questionRepository.count());                   // Question 수가 1개인지 확인

//        Optional<Question> oq = this.questionRepository.findById(1);                //  id가 1인 데이터를 찾아 optional 객체에 삽입
//        assertTrue(oq.isPresent());                                                 // oq 내 데이터가 존재하는지 판별
//        Question q = oq.get();                                                      // Optional<Question> 타입은 setSubject() 메서드 사용불가. Optional 안에 Question 객체를 꺼내 q에 저장
//        q.setSubject("수정된 제목");                                                  // subject 내용 수정
//        this.questionRepository.save(q);                                            // 데이터베이스에 저장

//        List<Question> qList = this.questionRepository.findBySubjectLike("sbb%");

//        Question q = this.questionRepository.findBySubjectAndContent("sbb가 무엇인가요?", "sbb에 대해서 알고 싶습니다.");
//        assertEquals(2, q.getId());

//        Question q = this.questionRepository.findBySubject("sbb가 무엇인가요?");
//        assertEquals(1, q.getId());

//        Optional<Question> question = questionRepository.findById(1);
//        if(question.isPresent()) {
//            Question q = question.get();
//            assertEquals("sbb가 무엇인가요?", q.getId());
//        }


//        List<Question> all = this.questionRepository.findAll();
//        assertEquals(4, all.size());
//
//        Question q = all.get(0);
//        assertEquals("sbb가 무엇인가요?", q.getSubject());


//        Question q1 = new Question();
//        q1.setSubject("sbb가 무엇인가요?");
//        q1.setContent("sbb에 대해서 알고 싶습니다.");
//        q1.setCreateDate(LocalDateTime.now());
//        this.questionRepository.save(q1);   // 첫번째 질문 저장
//
//        Question q2 = new Question();
//        q2.setSubject("스프링부트 모델 질문입니다.");
//        q2.setContent("id는 자동으로 생성되나요?");
//        q2.setCreateDate(LocalDateTime.now());
//        this.questionRepository.save(q2);  // 두번째 질문 저장
	}
}
