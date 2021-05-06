package tiengnhatmienphi.com.japanese.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tiengnhatmienphi.com.japanese.Entity.Lesson;
import tiengnhatmienphi.com.japanese.Entity.Roomchallenge;
import tiengnhatmienphi.com.japanese.Entity.User;
import tiengnhatmienphi.com.japanese.Entity.UserRoom;
import tiengnhatmienphi.com.japanese.Repository.RoomChallengeRepo;
import tiengnhatmienphi.com.japanese.Repository.UserRoomRepository;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
        @RequestMapping(value = "/challenge")
public class RoomChallengeController {

    @Autowired
    RoomChallengeRepo repo;

    @Autowired
    private UserRoomRepository userRoomRepository;

    @Autowired
    private RoomChallengeRepo roomChallengeRepo;


    @PostMapping(value = "/add")
    public void addRoom(@RequestBody Roomchallenge rc){
        repo.save(rc);
    }

    @PostMapping(value = "/room-user")
    public void addUserRoom(@RequestBody UserRoom rc){
        userRoomRepository.save(rc);
    }

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public List<Roomchallenge> getAll(){
        return repo.findAll();
    }

    @GetMapping("/room/{id}")
    public ResponseEntity<Object> get(@PathVariable(name = "id") Integer id){
        try {
            Roomchallenge room =roomChallengeRepo.findById(id).get();
            List<User> users = room.getUsers();
            return ResponseEntity.ok(users);
        } catch (NoSuchElementException e) {
            return ResponseEntity.ok("không tìm thấy!");
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<Roomchallenge> getroom(@PathVariable Integer id) {
        try {
            Roomchallenge rc = repo.findById(id).get();
            return new ResponseEntity<Roomchallenge>(rc, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Roomchallenge>(HttpStatus.NOT_FOUND);
        }
    }

    

    @PutMapping("update-score/{id}")
    public ResponseEntity<?> update(@RequestBody UserRoom st, @PathVariable Integer id) {
        try {
            UserRoom lss = userRoomRepository.findById(id).get();
            lss.setScore(st.getScore());
            userRoomRepository.save(lss);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
