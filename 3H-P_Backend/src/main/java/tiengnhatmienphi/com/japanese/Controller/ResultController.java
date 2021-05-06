package tiengnhatmienphi.com.japanese.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tiengnhatmienphi.com.japanese.Entity.Result;
import tiengnhatmienphi.com.japanese.Entity.UserRoom;
import tiengnhatmienphi.com.japanese.Repository.ResultRepository;

import java.util.NoSuchElementException;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/result")
public class ResultController {


    @Autowired
    private ResultRepository repository;

    @PostMapping(value = "/save")
    public void addRoom(@RequestBody Result rc){
        repository.save(rc);
    }

//    @PutMapping("/update-score/{id}")
//    public ResponseEntity<?> update(@RequestBody Result st, @PathVariable Integer id) {
//        try{
//            UserRoom userRoom= userRoomRepository.findById(id).get();
//            userRoom.setId(st.getId());
//            userRoom.setRoom_id(st.getRoom_id());
//            userRoom.setUser_id(st.getUser_id());
//            userRoom.setScore(st.getScore());
//            userRoomRepository.save(userRoom);
//            return new ResponseEntity<>(HttpStatus.OK);
//        } catch (NoSuchElementException e) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }
}
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
