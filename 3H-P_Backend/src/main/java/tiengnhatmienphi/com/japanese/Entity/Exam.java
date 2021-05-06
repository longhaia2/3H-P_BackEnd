package tiengnhatmienphi.com.japanese.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity()
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table
public class Exam {
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

    private String level;

     private String term;

    @Column(name = "create_by")
    private String createBy;


    @Column(name = "total_question")
    private Integer totalQuestion;

    @Column(name = "time_out")
    private Integer timeOut;


    @Column(name = "create_date")
    private Date createDate;

    @Column(name = "status")
    private Integer status;


    @JsonIgnore
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JoinTable(name = "exam_question",
            joinColumns = @JoinColumn(name = "exam_id"),
            inverseJoinColumns = @JoinColumn(name = "question_id")
    )
    private List<Question> questions;

    @JsonIgnore
    @OneToMany(mappedBy = "exam_result",cascade = CascadeType.ALL)
    private List<Result> listResult;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCodeExam() {
        return codeExam;
    }

    public void setCodeExam(String codeExam) {
        this.codeExam = codeExam;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Integer getTotalQuestion() {
        return totalQuestion;
    }

    public void setTotalQuestion(Integer totalQuestion) {
        this.totalQuestion = totalQuestion;
    }

    public Integer getTimeOut() {
        return timeOut;
    }

    public void setTimeOut(Integer timeOut) {
        this.timeOut = timeOut;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public List<Result> getListResult() {
        return listResult;
    }

    public void setListResult(List<Result> listResult) {
        this.listResult = listResult;
    }
}
