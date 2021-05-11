package tiengnhatmienphi.com.japanese.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import tiengnhatmienphi.com.japanese.Entity.ResultGrammar;

import java.util.List;

@Repository
public interface ResultGrammarReponsitory extends JpaRepository<ResultGrammar, Integer> {
    @Query(value = "select * from result_grammar a where a.user_id = ?1", nativeQuery = true)
    List<ResultGrammar> findAllByUser_id(Integer id);

    @Query("SELECT E.codeExam, E.content, UR.score FROM ResultGrammar UR, Exam E WHERE  UR.exam_id=E.id and UR.user_id=:userId")
    List<Object> FindResultByExam(Integer userId);
}