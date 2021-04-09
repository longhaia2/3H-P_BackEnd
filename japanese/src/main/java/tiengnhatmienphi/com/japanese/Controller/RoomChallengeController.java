package tiengnhatmienphi.com.japanese.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tiengnhatmienphi.com.japanese.Entity.roomchallenge;
import tiengnhatmienphi.com.japanese.Repository.RoomChallengeRepo;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/challenge")
public class RoomChallengeController {

    @Autowired
    RoomChallengeRepo repo;

    @PostMapping(value = "/add")
    public void addRoom(@RequestBody roomchallenge rc){
        repo.save(rc);
    }
}
