package tiengnhatmienphi.com.japanese.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import tiengnhatmienphi.com.japanese.Entity.Exam;
import tiengnhatmienphi.com.japanese.Entity.Lesson;
import tiengnhatmienphi.com.japanese.Repository.ExamRepository;
import tiengnhatmienphi.com.japanese.Repository.LessonRepo;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/lesson")

public class LessonController {
    @Autowired
    private LessonRepo lessonrepo;
    @GetMapping("/all")
    public List<Lesson> findAll() {

//        List<Lesson> lessonList = lessonrepo.findByabcd("Bai1", "N1");
        return lessonrepo.findAll();
    }

    @GetMapping("/{level}/lesson/{idLesson}")
    public List<Lesson> findByidlessson(@PathVariable String level, @PathVariable String idLesson) {
        List<Lesson> lessonList = lessonrepo.findByidlessson(idLesson, level);
        return lessonList;
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PostMapping("/add")
    public void add(@RequestBody Lesson ls) {
        lessonrepo.save(ls);
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping("/{id}")
    public ResponseEntity<Lesson> get(@PathVariable Integer id) {
        try {
            Lesson ls = lessonrepo.findById(id).get();
            return new ResponseEntity<Lesson>(ls, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Lesson>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Integer id) {
        lessonrepo.deleteById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Lesson st, @PathVariable Integer id) {
        try {
            Lesson lss = lessonrepo.findById(id).get();
            lss.setId(st.getId());
            lss.setLesson(st.getLesson());
            lss.setTerm(st.getTerm());
            lss.setLevel(st.getLevel());
            lss.setDescription(st.getDescription());
            lss.setContent(st.getContent());
            lessonrepo.save(lss);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping(path = "/timkiem/{searchtext}")
    public List<Lesson> getfinbyLesson(@PathVariable String searchtext){
        String search = "%" + searchtext + "%";
        return lessonrepo.findByLesson(search);
    }

}
