package tiengnhatmienphi.com.japanese.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import tiengnhatmienphi.com.japanese.Entity.Lesson;
import tiengnhatmienphi.com.japanese.Entity.Roomchallenge;
import tiengnhatmienphi.com.japanese.Entity.UserRoom;
import tiengnhatmienphi.com.japanese.Repository.RoomChallengeRepo;
import tiengnhatmienphi.com.japanese.Repository.UserRoomRepository;

import java.util.List;
import java.util.NoSuchElementException;


@Controller
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/challenge")
public class RoomUserController {

    @Autowired
    RoomChallengeRepo repo;

    @Autowired
    private UserRoomRepository userRoomRepository;
    @PutMapping("/update-score/{id}")
    public ResponseEntity<?> update(@RequestBody UserRoom st, @PathVariable Integer id) {
        try{
            UserRoom userRoom= userRoomRepository.findById(id).get();
            userRoom.setScore(st.getScore());
            userRoom.setBanker(st.getBanker());
            userRoom.setStatus(st.getStatus());
            userRoomRepository.save(userRoom);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/update-status/{id}")
    public ResponseEntity<?> updateStatus(@RequestBody UserRoom st, @PathVariable Integer id) {
        try{
            UserRoom userRoom= userRoomRepository.findById(id).get();
            userRoom.setStatus(st.getStatus());
            userRoomRepository.save(userRoom);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PutMapping("/update-room/{id}")
    public ResponseEntity<?> updateRoom(@RequestBody Roomchallenge st, @PathVariable Integer id) {
        try{
            Roomchallenge room= repo.findById(id).get();
            room.setStatus(st.getStatus());
            repo.save(room);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/update-member/{id}")
    public ResponseEntity<?> updateMember(@RequestBody UserRoom st, @PathVariable Integer id) {
        try{
            UserRoom userRoom= userRoomRepository.findById(id).get();
            userRoom.setBanker(st.getBanker());
            userRoomRepository.save(userRoom);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


}
