package tiengnhatmienphi.com.japanese.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tiengnhatmienphi.com.japanese.Entity.Question;

import java.util.List;

/**
 * Phan Thi Dieu Hien
 **/

public interface QuestionRepository extends JpaRepository<Question,Integer> {



}
