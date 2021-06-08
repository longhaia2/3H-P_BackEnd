package tiengnhatmienphi.com.japanese.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import tiengnhatmienphi.com.japanese.Entity.ResultGrammar;
import tiengnhatmienphi.com.japanese.Entity.ResultVocabulary;

import java.util.List;

@Repository
public interface ResultVocabularyReponsitory extends JpaRepository<ResultVocabulary, Integer> {

    @Query(value = "select * from result_vocabulary a where a.user_id = ?1", nativeQuery = true)
    List<ResultVocabulary> findAllByUser_id(Integer id);
    @Query(value = "select u.username, e.code_exam, e.content,g.score, g.id, g.exam_id,g.date_test from result_vocabulary as g,user as u, exam as e where u.id=g.user_id and e.id=g.exam_id", nativeQuery = true)
    List<Object> getAllResult();
}
