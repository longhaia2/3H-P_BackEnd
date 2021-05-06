package tiengnhatmienphi.com.japanese.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import tiengnhatmienphi.com.japanese.Entity.Question;
import tiengnhatmienphi.com.japanese.Model.QuestionModel;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
/**
 * Phan Thi Dieu Hien
 **/
@Service
@Transactional
public interface QuestionService {
    void createQuestion(Question question);
    void deleteQuestion(Question question);
    Optional<Question> findById(Integer id);
    Question updateQuestion(Question question);
    Page<Question> getAllQuestion(Pageable pageable);
    List<Question> getListQuestionByExam(Integer examId);
    List<QuestionModel> getListQuestion(Integer examId, boolean history);
    Page<Question> getPageQuestionByExamId(Integer examId, Pageable pageable);
    Page<Question> getListAllQuestion(Pageable pageable);
    long countQuestion();
}