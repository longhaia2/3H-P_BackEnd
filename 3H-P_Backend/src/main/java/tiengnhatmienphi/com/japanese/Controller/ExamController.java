package tiengnhatmienphi.com.japanese.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import tiengnhatmienphi.com.japanese.Entity.Exam;
import tiengnhatmienphi.com.japanese.Repository.ExamRepository;
import java.util.List;
import java.util.Optional;

@Component
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
    @GetMapping(path = "/timkiem/{searchtext}")
    public List<Exam> getfinIdBytext(@PathVariable String searchtext){
        String search = "%" + searchtext + "%";
        return repo.findByCodeExam(search);
    }
    @GetMapping("/{level}/ontap/{term}")
    public List<Exam> findByLevelTerm(@PathVariable String level,@PathVariable String term) {
        List<Exam> examList = repo.findByLevelTerm(level, term);
        return examList;
    }


}
