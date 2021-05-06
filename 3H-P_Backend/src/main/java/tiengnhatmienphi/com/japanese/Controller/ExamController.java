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
    @GetMapping("/all")
    public List<Exam> findAll() {
//        List<Exam> examList = ExamRepository.findBylevel( "De");
        return repo.findAll();
    }

    @GetMapping("pp/{level}")
    public List<Exam> findBylevel(@PathVariable String level) {
        List<Exam> examList = repo.findBylevel(level);
        return examList;
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
}
