package tiengnhatmienphi.com.japanese.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import tiengnhatmienphi.com.japanese.Entity.Result;
import tiengnhatmienphi.com.japanese.Repository.ResultRepository;
import java.util.NoSuchElementException;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/result")
public class ResultController {
    @Autowired
    private ResultRepository resultRepository;

    @PostMapping(value = "/add")
    public Integer addResult(@RequestBody Result rc){
        rc = resultRepository.save(rc);
        return rc.getId();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Result> getResult(@PathVariable Integer id) {
        try {
            Result result = resultRepository.findById(id).get();
            return new ResponseEntity<Result>(result, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Result>(HttpStatus.NOT_FOUND);
        }
    }
}