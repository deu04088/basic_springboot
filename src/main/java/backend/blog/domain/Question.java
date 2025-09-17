package backend.blog.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter                     // get 메서드 자동 생성
@Setter                     // set 메서드 자동 생성
@Entity                     // Question 클래스를 엔티티로 인식
public class Question {
    @Id                     // 기본키 속성으로 지정
    @GeneratedValue(strategy = GenerationType.IDENTITY)         // 데이터 저장 시 속성값을 자동으로 1씩 더하여 저장
    private Integer id;

    @Column(length = 200)                               // 열 설정, 열 길이 설정
    private String subject;

    @Column(columnDefinition = "TEXT")                  // 열의 데이터 유형이나 성격 설정 (columnDefinition)
    private String content;

    private LocalDateTime createDate;

    @OneToMany(mappedBy = "question", cascade = CascadeType.REMOVE)             // 참조 속성 question을 mappedBy에 전달. 삭제 설정
    private List<Answer> answers;

}
