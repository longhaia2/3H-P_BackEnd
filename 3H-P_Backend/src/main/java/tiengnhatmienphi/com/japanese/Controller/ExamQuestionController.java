package tiengnhatmienphi.com.japanese.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tiengnhatmienphi.com.japanese.Entity.*;
import tiengnhatmienphi.com.japanese.Repository.ExamQuestionRepo;
import tiengnhatmienphi.com.japanese.Repository.ExamRepository;
import tiengnhatmienphi.com.japanese.Repository.QuestionRepository;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/exam")
public class ExamQuestionController {

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private ExamRepository examRepository;
    @Autowired
    private ExamQuestionRepo examQuestionRepo;

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

    @GetMapping("/{code_exam}/challenge/{id}")
    public ResponseEntity<Object> getQuestionByLevelAndId(@PathVariable(name = "code_exam") String code_exam, @PathVariable(name = "id") Integer id) {
        try {
            Exam exams = examRepository.findByCodeExamAndId(code_exam,id);
            List<Question> questions = exams.getQuestions();

            return ResponseEntity.ok(questions);
        } catch (NoSuchElementException e) {
            return ResponseEntity.ok("Không tìm thấy!");
        }
    }
    @DeleteMapping("/delete-qs/{id}")
    public void delete(@PathVariable Integer id) { examQuestionRepo.deleteById(id);}


//    public void add(@RequestBody ExamQuestion qs) {examQuestionRepo.save(qs); }

    @PostMapping("/add-qs-in-exam")
    public List<ExamQuestion> addRoomUser(@RequestBody ExamQuestion rc) {
        List<ExamQuestion> lst = examQuestionRepo.CoutQSByExam(rc.getExam_id(), rc.getQuestion_id());
        if (lst.size() < 1) {
            examQuestionRepo.save(rc);
        }
        return lst;
    }

    @GetMapping("/questions-exam/{exam_id}")
    public List<ExamQuestion> ListByExam(@PathVariable Integer exam_id){
        List<ExamQuestion> exam= examQuestionRepo.ListByExam(exam_id);
        return exam;
    }
//    @GetMapping("/questions-qs-exam/{exam_id}")
//    public List<Object> ListQSByExam(@PathVariable Integer exam_id){
//        List<Object> exam= examQuestionRepo.ListQSByExam(exam_id);
//        return exam;
//    }
}