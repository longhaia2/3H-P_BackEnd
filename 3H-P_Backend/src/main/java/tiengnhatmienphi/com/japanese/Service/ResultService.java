package tiengnhatmienphi.com.japanese.Service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import tiengnhatmienphi.com.japanese.Entity.Result;

import java.util.List;
import java.util.Optional;

public interface ResultService {

    void save(Result result);
    Optional<Result> findById(Integer id);
    Page<Result> getListResultExam(Pageable pageable);
    List<Result> getResultScoreDESC();
    long countResult();
    Page<Result> getListResultExamByUserId(Integer userId, Pageable pageable);
}
