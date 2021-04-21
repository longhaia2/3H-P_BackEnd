//package tiengnhatmienphi.com.japanese.Controller;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import tiengnhatmienphi.com.japanese.Entity.Roomchallenge;
//import tiengnhatmienphi.com.japanese.Entity.User;
//import tiengnhatmienphi.com.japanese.Repository.RoomChallengeRepo;
//
//import java.util.List;
//import java.util.NoSuchElementException;
//
//@Controller
//@CrossOrigin(origins = "http://localhost:4200")
//@RequestMapping(value = "/challenge")
//public class RoomUserController {
//
//    @Autowired
//    private RoomChallengeRepo roomChallengeRepo;
//
//    @GetMapping("request/{id}")
//    public ResponseEntity<Object> get(@PathVariable(name = "id") Integer id){
//        try {
//            Roomchallenge room =roomChallengeRepo.findById(id).get();
//            List<User> users = room.getUsers();
//            return ResponseEntity.ok(users);
//        } catch (NoSuchElementException e) {
//            return ResponseEntity.ok("không tìm thấy!");
//        }
//        }
//    }
