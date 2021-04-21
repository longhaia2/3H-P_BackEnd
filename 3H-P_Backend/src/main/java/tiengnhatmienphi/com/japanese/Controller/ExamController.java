package tiengnhatmienphi.com.japanese.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tiengnhatmienphi.com.japanese.Entity.Exam;
import tiengnhatmienphi.com.japanese.Entity.Lesson;
import tiengnhatmienphi.com.japanese.Repository.ExamRepository;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/exam")
public class ExamController {

    @Autowired
    private ExamRepository repo;

    @PostMapping(value = "/add")
    public void addRoom(@RequestBody Exam rc){
        repo.save(rc);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Exam> get(@PathVariable Integer id) {
        try {
            Exam ex = repo.findById(id).get();
            return new ResponseEntity<Exam>(ex, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Exam>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/all/exam")
    public List<Exam> getlistExamOrderByIdDesc() {
        List<Exam> ExamList = repo.getlistExamOrderByIdDesc();
        return ExamList;
    }
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public List<Exam> getAll(){
        return repo.findAll();
    }

    @DeleteMapping(value = "delete/{id}")
    public void delete(@PathVariable Integer id){
        repo.deleteById(id);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Exam exx, @PathVariable Integer id) {
        try {
            Exam ex = repo.findById(id).get();
            ex.setId(exx.getId());
            ex.setCodeExam(exx.getCodeExam());
            ex.setContent(exx.getContent());
            ex.setLevel(exx.getLevel());
            ex.setStatus(exx.getStatus());
            ex.setTerm(exx.getTerm());
            ex.setTimeOut(exx.getTimeOut());
            ex.setTitle(exx.getTitle());
            ex.setTotalQuestion(exx.getTotalQuestion());
            repo.save(ex);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
