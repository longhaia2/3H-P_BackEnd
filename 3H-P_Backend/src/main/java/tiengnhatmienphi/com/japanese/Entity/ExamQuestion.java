//package tiengnhatmienphi.com.japanese.Entity;
//
//import lombok.AllArgsConstructor;
//import lombok.Builder;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//import javax.persistence.*;
//
//@Entity
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//@Builder
//@Table
//public class ExamQuestion {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Integer id;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name ="exam_id" )
//    private Exam examQuestion;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name ="question_id" )
//    private Question questionExam;
//}
