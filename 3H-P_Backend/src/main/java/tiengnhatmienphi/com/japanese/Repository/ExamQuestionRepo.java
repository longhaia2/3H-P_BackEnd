package tiengnhatmienphi.com.japanese.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tiengnhatmienphi.com.japanese.Entity.ExamQuestion;
import tiengnhatmienphi.com.japanese.Entity.UserRoom;

import java.util.List;

public interface ExamQuestionRepo extends JpaRepository<ExamQuestion,Integer> {
    @Query("SELECT UR FROM ExamQuestion UR WHERE  UR.exam_id=:exam_id ")
    List<ExamQuestion> ListByExam(@Param("exam_id") Integer exam_id);

    @Query("SELECT UR FROM ExamQuestion UR WHERE  UR.exam_id=:exam_id and UR.question_id=:question_id")
    List<ExamQuestion> CoutQSByExam(@Param("exam_id") Integer exam_id, @Param("question_id") Integer question_id);
}
