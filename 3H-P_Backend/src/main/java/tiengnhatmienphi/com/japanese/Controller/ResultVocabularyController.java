package tiengnhatmienphi.com.japanese.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tiengnhatmienphi.com.japanese.Entity.Lesson;
import tiengnhatmienphi.com.japanese.Entity.ResultVocabulary;
import tiengnhatmienphi.com.japanese.Repository.ResultVocabularyReponsitory;
import tiengnhatmienphi.com.japanese.Service.ResultVocabularyService;
import tiengnhatmienphi.com.japanese.payload.request.ResultVocabularyRequest;

import java.util.NoSuchElementException;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/result-vocabulary")
public class ResultVocabularyController {

    @Autowired
    private ResultVocabularyService resultVocabularyService;

    @Autowired
    private ResultVocabularyReponsitory resultVocabularyReponsitory;

    @PostMapping(value = "/add")
    public ResponseEntity<?> addResults(@RequestBody ResultVocabularyRequest rc){
        return ResponseEntity.ok(resultVocabularyService.create(rc));
    }
    @PutMapping("/add-date/{id}")
    public ResponseEntity<?> update(@RequestBody ResultVocabulary st, @PathVariable Integer id) {
        try {
            ResultVocabulary lss = resultVocabularyReponsitory.findById(id).get();
           lss.setId(st.getId());
            lss.setDate_test(st.getDate_test());
            resultVocabularyReponsitory.save(lss);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getResults(@PathVariable Integer id) {
        return ResponseEntity.ok(resultVocabularyService.findById(id));
    }
}