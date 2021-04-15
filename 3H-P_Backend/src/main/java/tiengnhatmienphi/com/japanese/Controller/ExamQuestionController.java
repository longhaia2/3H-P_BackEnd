package tiengnhatmienphi.com.japanese.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tiengnhatmienphi.com.japanese.Entity.*;
import tiengnhatmienphi.com.japanese.Repository.ExamRepository;
import tiengnhatmienphi.com.japanese.Repository.QuestionRepository;

import java.util.List;
import java.util.NoSuchElementException;
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/question")
public class ExamQuestionController {

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private ExamRepository examRepository;


    @GetMapping("/list/{id}")
    public ResponseEntity<Object> get(@PathVariable(name = "id") Integer id) {
        try {
            Exam exam = examRepository.findById(id).get();
//                List<ExamQuestion> examQuestions = examQRepository.findByExamQuestion(exam);
            List<Question> questions = exam.getQuestions();
            return ResponseEntity.ok(questions);
        } catch (NoSuchElementException e) {
            return ResponseEntity.ok("Không tìm thấy!");
        }
    }


}