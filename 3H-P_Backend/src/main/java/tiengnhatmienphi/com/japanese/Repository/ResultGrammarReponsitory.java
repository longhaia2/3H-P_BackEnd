package tiengnhatmienphi.com.japanese.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tiengnhatmienphi.com.japanese.Entity.ResultGrammar;

@Repository
public interface ResultGrammarReponsitory extends JpaRepository<ResultGrammar, Integer> {

}
