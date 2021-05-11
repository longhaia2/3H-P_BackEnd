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

}
