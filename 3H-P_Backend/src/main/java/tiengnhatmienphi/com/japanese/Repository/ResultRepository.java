package tiengnhatmienphi.com.japanese.Repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tiengnhatmienphi.com.japanese.Entity.Result;
import tiengnhatmienphi.com.japanese.Entity.ResultVocabulary;
import tiengnhatmienphi.com.japanese.Entity.User;

import java.util.List;
import java.util.Optional;

public interface ResultRepository extends JpaRepository<Result,Integer> {
    @Query( value = "select * from result where result.user_id = ?1", nativeQuery = true)
    List<Result> findAllByUserResult(Integer user_id);

}
