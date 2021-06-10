package tiengnhatmienphi.com.japanese.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import tiengnhatmienphi.com.japanese.Entity.Lesson;
import tiengnhatmienphi.com.japanese.Entity.ResultGrammar;

import java.util.List;

@Repository
public interface ResultGrammarReponsitory extends JpaRepository<ResultGrammar, Integer> {
    @Query(value = "select * from result_grammar a where a.user_id = ?1", nativeQuery = true)
    List<ResultGrammar> findAllByUser_id(Integer id);

    @Query("SELECT E.codeExam, E.content, UR.score FROM ResultGrammar UR, Exam E WHERE  UR.exam_id=E.id and UR.user_id=:userId")
    List<Object> FindResultByExam(Integer userId);

    @Query(value = "select u.username, e.code_exam, e.content,g.score, g.id, g.exam_id, g.date_test, e.total_question from result_grammar as g,user as u, exam as e where u.id=g.user_id and e.id=g.exam_id", nativeQuery = true)
    List<Object> getAllResult();
    @Query("select u.username, e.codeExam, e.content,g.score, g.id, g.exam_id from ResultGrammar as g,User as u, Exam as e where u.id=g.user_id and e.id=g.exam_id and e.id=g.exam_id and u.username=:searchText")
    List<Object> findbyusername(String searchText);
    @Query("select u.username, e.codeExam, e.content,g.score, g.id, g.exam_id from ResultGrammar as g,User as u, Exam as e where u.id=g.user_id and e.id=g.exam_id and e.id=g.exam_id and e.codeExam=:searchText")
    List<Object> findbycodeExam(String searchText);
}