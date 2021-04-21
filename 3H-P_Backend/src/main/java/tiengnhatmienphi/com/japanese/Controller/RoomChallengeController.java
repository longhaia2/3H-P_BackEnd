package tiengnhatmienphi.com.japanese.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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
            Roomchallenge room =repo.findById(id).get();
            List<User> users = room.getUsers();
            return ResponseEntity.ok(users);
        } catch (NoSuchElementException e) {
            return ResponseEntity.ok("không tìm thấy!");
        }
    }


}
