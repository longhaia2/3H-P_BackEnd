package tiengnhatmienphi.com.japanese.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tiengnhatmienphi.com.japanese.Entity.Question;

import java.util.List;

/**
 * Phan Thi Dieu Hien
 **/

public interface QuestionRepository extends JpaRepository<Question,Integer> {

//    @Query(value = "select qs.ans_a,qs.ans_b,qs.ans_c,qs.ans_d,qs.an from question qs,exam_question ex where ex.exam_id=?1 AND ex.question_id=qs.id",nativeQuery = true)
//    List<Question> getListQuestionByExamId(Integer examId);
//        @Query(value =" select  qs.ans_a,qs.ans_b,qs.ans_c,qs.ans_d,qs.ans_correct, qs.content from Exam as ex, exam_question as eq, Question as qs where ex.id=?1 and eq.exam_id = ex.id and eq.question_id = qs.id", nativeQuery = true)
//    List<Question> getListQuestionByExamid(Integer idExam);

}
