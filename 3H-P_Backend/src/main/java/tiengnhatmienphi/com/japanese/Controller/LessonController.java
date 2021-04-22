package tiengnhatmienphi.com.japanese.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tiengnhatmienphi.com.japanese.Entity.Lesson;
import tiengnhatmienphi.com.japanese.Repository.LessonRepo;

import java.util.List;
import java.util.NoSuchElementException;

/**
 * author: ThuanHa
 * Tạo các api
 */
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/lesson")
public class LessonController {
    @Autowired
    private LessonRepo lessonrepo;

    /**
     * Api lấy tất cả danh sách
     * @return
     */
    @GetMapping("/all")
    public List<Lesson> findAll() {

        return lessonrepo.findAll();
    }

    /**
     * Api lấy danh sách theo trình độ và bài học
     * @return
     */
    @GetMapping("/{level}/lesson/{idLesson}")
    public List<Lesson> findByidlessson(@PathVariable String level, @PathVariable String idLesson) {
        List<Lesson> lessonList = lessonrepo.findByidlessson(idLesson, level);
        return lessonList;
    }
    @GetMapping("/{level}/{term}")
    public List<Lesson> findByidlevel(@PathVariable String level,@PathVariable String term) {
        List<Lesson> lessonList = lessonrepo.findByidlevel(level, term);
        return lessonList;
    }

    @GetMapping("/all/baimoi")
    public List<Lesson> getLessonByDesc() {
        List<Lesson> lessonList = lessonrepo.getLessonByDesc();
        return lessonList;
    }
    /**
     * Api thêm mới
     * @param ls
     */
    @PostMapping("/add")
    public void add(@RequestBody Lesson ls) {
        lessonrepo.save(ls);
    }
    /**
     * Api lấy theo Id
     * @param id
     * @return
     */

    @GetMapping("/{id}")
    public ResponseEntity<Lesson> get(@PathVariable Integer id) {
        try {
            Lesson ls = lessonrepo.findById(id).get();
            return new ResponseEntity<Lesson>(ls, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Lesson>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * APi xóa
     * @param id
     */
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Integer id) {
        lessonrepo.deleteById(id);
    }

    /**
     * Api Update
     * @param st
     * @param id
     * @return
     */
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
}
