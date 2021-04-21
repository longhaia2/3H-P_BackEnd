package tiengnhatmienphi.com.japanese.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tiengnhatmienphi.com.japanese.Entity.roomchallenge;
import tiengnhatmienphi.com.japanese.Repository.RoomChallengeRepo;

import java.util.List;

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

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public List<roomchallenge> getAll(){
        return repo.findAll();
    }
}
