package tiengnhatmienphi.com.japanese.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import tiengnhatmienphi.com.japanese.Entity.*;
import tiengnhatmienphi.com.japanese.Repository.ExamRepository;
import tiengnhatmienphi.com.japanese.Repository.QuestionRepository;
import tiengnhatmienphi.com.japanese.Service.ExamService;
import tiengnhatmienphi.com.japanese.Service.QuestionService;

import java.security.Principal;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/question")
public class QuestionController {

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
