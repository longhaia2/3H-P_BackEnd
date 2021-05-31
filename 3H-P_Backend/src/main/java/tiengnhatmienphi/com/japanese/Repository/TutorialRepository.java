package tiengnhatmienphi.com.japanese.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tiengnhatmienphi.com.japanese.Entity.Question;

public interface TutorialRepository extends JpaRepository<Question,Integer> {
}
