package tiengnhatmienphi.com.japanese.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table
public class Exam {
    //    1 môn hoc có nhiều đề thi
//    1 dè thi thuojc 1 mon hoc
//    1 de thi có nhieu câu hỏi

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    // mã đề thi
    @Column(name = "code_exam")
    private String codeExam;

    // tieu de de thi
    @Column(name = "title")
    private String title;

    // noi dung de thi
    @Column(name = "content")
    private String content;

    @Column(name = "create_by")
    private String createBy;


    @Column(name = "total_question")
    private Integer totalQuestion;

    @Column(name = "time_out")
    private Integer timeOut;


    @Column(name = "create_date")
    private Date createDate;


    @JsonIgnore
    @OneToMany(mappedBy = "examQuestion",cascade = CascadeType.ALL)
    private List<ExamQuestion> listExamQuestion;

    @JsonIgnore
    @OneToMany(mappedBy = "exam_result",cascade = CascadeType.ALL)
    private List<Result> listResult;
}
