package tiengnhatmienphi.com.japanese.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tiengnhatmienphi.com.japanese.Entity.*;
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
    public Integer addRoom(@RequestBody Roomchallenge rc){
        rc =  repo.save(rc);
        return rc.getRoom_id();
    }

    @PostMapping(value = "/room-user")
    public List<UserRoom> addRoomUser(@RequestBody UserRoom rc) {
        List<UserRoom> lst = userRoomRepository.ListByRoomAndUser(rc.getRoom_id(), rc.getUser_id());
        if (lst.size() < 1) {
            userRoomRepository.save(rc);
        }
        return lst;
    }


    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public List<Roomchallenge> getAll(){
        return repo.GetRoom();
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


    @GetMapping("/dem/{id}")
    public Integer Dem(@PathVariable int id){
        return roomChallengeRepo.DemNguoi(id);
    }
    @GetMapping("/user-banker/{room_id}")
    public List<UserRoom> userRoomList(@PathVariable Integer room_id){
        List<UserRoom> us= userRoomRepository.ListByRoom(room_id);
        return us;
    }
    @GetMapping("/room-list-user/{room_id}")
    public List<UserRoom> getUsersRoomList(@PathVariable Integer room_id){
        List<UserRoom> us= userRoomRepository.ListUsersByRoom(room_id);
        return us;
    }

    //    @GetMapping("/user-by-score/{room_id}")
//    public List<UserRoom> getListUsersByScore(@PathVariable Integer room_id){
//        List<UserRoom> userRooms= userRoomRepository.ListUsersByScore(room_id);
//        return userRooms;
//    }
    @GetMapping("/user-by-score/{room_id}")
    public List<Object> getRoombyScore(@PathVariable Integer room_id){
        return userRoomRepository.UsersByScore(room_id);
    }
    @GetMapping("user-room/{room_id}/{id}")
    public List<UserRoom> getUser(@PathVariable Integer room_id,@PathVariable Integer id ) {
        return userRoomRepository.ListByRoomAndUser(room_id, id);
    }

    @GetMapping("/top")
    public List<Object> getTopHighByDesc() {
        return userRoomRepository.getTopHighScoreByScore();
//        return topList;
    }


}