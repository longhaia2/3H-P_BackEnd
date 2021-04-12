package tiengnhatmienphi.com.japanese.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tiengnhatmienphi.com.japanese.Entity.User;
import tiengnhatmienphi.com.japanese.Entity.roomchallenge;
import tiengnhatmienphi.com.japanese.Repository.RoomChallengeRepo;
import tiengnhatmienphi.com.japanese.Repository.UserRepository;
import tiengnhatmienphi.com.japanese.payload.response.ChallengeReponse;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/challenge")
public class RoomChallengeController {

    @Autowired
    RoomChallengeRepo repo;

    @Autowired
    private UserRepository userRepository;

    @PostMapping(value = "/add")
    public void addRoom(@RequestBody roomchallenge rc){
        repo.save(rc);
    }

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public List<roomchallenge> getAll(){
        return repo.findAll();
    }

//    @RequestMapping(value = "/demo/{username}", method = RequestMethod.GET)
//    public List<roomchallenge> findByUserName(@PathVariable String username) {
//        User user = userRepository.findByUsername(username).get();
//        return repo.findAllByUsers(user);
//    }
}
