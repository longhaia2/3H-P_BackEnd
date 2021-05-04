package tiengnhatmienphi.com.japanese.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tiengnhatmienphi.com.japanese.Entity.Lesson;
import tiengnhatmienphi.com.japanese.Entity.ResultGrammar;
import tiengnhatmienphi.com.japanese.Repository.ResultGrammarReponsitory;
import tiengnhatmienphi.com.japanese.Repository.ResultRepository;
import tiengnhatmienphi.com.japanese.Service.ResultGrammarService;
import tiengnhatmienphi.com.japanese.payload.request.ResultGrammarRequest;

import javax.xml.transform.Result;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/result-grammar")
public class ResultGrammarController {

    @Autowired
    private ResultGrammarService resultGrammarService;

    @Autowired
    private ResultGrammarReponsitory resultGrammarReponsitory;

    @PostMapping(value = "/add")
    public ResponseEntity<?> addResult(@RequestBody ResultGrammarRequest rc){
        return ResponseEntity.ok(resultGrammarService.create(rc));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getResult(@PathVariable Integer id) {
        return ResponseEntity.ok(resultGrammarService.findById(id));
    }
}