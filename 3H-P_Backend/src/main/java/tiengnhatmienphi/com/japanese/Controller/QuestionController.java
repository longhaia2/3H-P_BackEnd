package tiengnhatmienphi.com.japanese.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tiengnhatmienphi.com.japanese.Entity.Exam;
import tiengnhatmienphi.com.japanese.Entity.Question;
import tiengnhatmienphi.com.japanese.Repository.ExamRepository;
import tiengnhatmienphi.com.japanese.Repository.QuestionRepository;

import java.util.List;
import java.util.NoSuchElementException;

/**
 * Phan Thi Dieu Hien
 **/

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/question")
public class QuestionController {

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private ExamRepository examRepository;

    @GetMapping("/all")
    public List<Question> findAll() {return questionRepository.findAll(); }

    @PostMapping("/add")
    public void add(@RequestBody Question qs) {questionRepository.save(qs); }

    @GetMapping("/{id}")
    public ResponseEntity<Question> get(@PathVariable Integer id){
        try {
            Question qs = questionRepository.findById(id).get();
            return new ResponseEntity<Question>(qs, HttpStatus.OK);
        } catch (NoSuchElementException e){
            return new ResponseEntity<Question>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Integer id) { questionRepository.deleteById(id);}
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Question qs, @PathVariable Integer id) {
        try {
            Question qss = questionRepository.findById(id).get();
            qss.setId(qs.getId());
            qss.setTerm(qs.getTerm());
            qss.setLevel(qs.getLevel());
            qss.setContent(qs.getContent());
            qss.setAnsA(qs.getAnsA());
            qss.setAnsB(qs.getAnsB());
            qss.setAnsC(qs.getAnsC());
            qss.setAnsD(qs.getAnsD());
            qss.setAnsCorrect(qs.getAnsCorrect());
            questionRepository.save(qss);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/list/{id}")
    public ResponseEntity<Object> getList(@PathVariable(name = "id") Integer id) {
        try {
            Exam exam = examRepository.findById(id).get();
//                List<ExamQuestion> examQuestions = examQRepository.findByExamQuestion(exam);
            List<Question> questions = exam.getQuestions();
            return ResponseEntity.ok(questions);
        } catch (NoSuchElementException e) {
            return ResponseEntity.ok("Kh??ng t??m th???y!");
        }
    }
    @GetMapping("/{level}/testjnpt/{id}")
    public ResponseEntity<Object> getQuestionByLevelAndIdd(@PathVariable(name = "level") String level, @PathVariable(name = "id") Integer id) {
        try {
            Exam exams = examRepository.findByLevelAndId(level,id);
            List<Question> questions = exams.getQuestions();
            return ResponseEntity.ok(questions);
        } catch (NoSuchElementException e) {
            return ResponseEntity.ok("Kh??ng t??m th???y!");
        }
    }
}

