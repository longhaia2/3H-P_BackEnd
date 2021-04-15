package tiengnhatmienphi.com.japanese.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tiengnhatmienphi.com.japanese.Entity.Exam;
import tiengnhatmienphi.com.japanese.Repository.ExamRepository;

import java.util.List;

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
    public void deleteex(@PathVariable Integer id){
        repo.deleteById(id);
    }
}
