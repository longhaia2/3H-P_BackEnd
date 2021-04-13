package tiengnhatmienphi.com.japanese.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table
public class Question {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "content")
    private String content;

    @Column(name = "ans_a")
    private String ansA;

    @Column(name = "ans_b")
    private String ansB;

    @Column(name = "ans_c")
    private String ansC;

    @Column(name = "ans_d")
    private String ansD;

    @Column(name = "ans_correct")
    private String ansCorrect;

    @JsonIgnore
    @ManyToMany(mappedBy = "questions")
    private List<Exam> exams;

}

