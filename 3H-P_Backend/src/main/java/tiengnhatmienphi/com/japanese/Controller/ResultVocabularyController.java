package tiengnhatmienphi.com.japanese.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tiengnhatmienphi.com.japanese.Repository.ResultVocabularyReponsitory;
import tiengnhatmienphi.com.japanese.Service.ResultVocabularyService;
import tiengnhatmienphi.com.japanese.payload.request.ResultVocabularyRequest;

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

    @GetMapping("/{id}")
    public ResponseEntity<?> getResults(@PathVariable Integer id) {
        return ResponseEntity.ok(resultVocabularyService.findById(id));
    }
}