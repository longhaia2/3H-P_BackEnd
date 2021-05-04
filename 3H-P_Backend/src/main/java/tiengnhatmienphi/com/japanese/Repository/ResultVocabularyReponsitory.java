package tiengnhatmienphi.com.japanese.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tiengnhatmienphi.com.japanese.Entity.ResultVocabulary;

@Repository
public interface ResultVocabularyReponsitory extends JpaRepository<ResultVocabulary, Integer> {
}
