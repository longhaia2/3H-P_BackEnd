package tiengnhatmienphi.com.japanese.Service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import tiengnhatmienphi.com.japanese.Entity.Result;

import java.util.List;
import java.util.Optional;

@Service
public interface ResultService {
    void save(Result result);
    Optional<Result> findById(Integer id);
    Optional<Result> checkResultExist(Integer timeout, Integer userId, Integer ExamId,Integer status);
    Page<Result> getListResultExam(Pageable pageable);
    Page<Result> searchResultExam(String username, String examCode, Pageable pageable);
    void deleteResult(Result result);
    List<Result> getResultScoreDESC();
    long countResult();
    Page<Result> getListResultExamByUserId(Integer userId, Pageable pageable);
}
