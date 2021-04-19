package tiengnhatmienphi.com.japanese.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tiengnhatmienphi.com.japanese.Entity.Lesson;
import tiengnhatmienphi.com.japanese.Entity.User;
import tiengnhatmienphi.com.japanese.Entity.enums.ERole;
import tiengnhatmienphi.com.japanese.Repository.RoleRepository;
import tiengnhatmienphi.com.japanese.Repository.UserRepository;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private UserRepository userRepo;
//    @Autowired
//    private RoleRepository roleRepo;
    @GetMapping("/all")
    public List<User> findAll() {
        return userRepo.findAll();
    }
    @PostMapping("/add")
    public void add(@RequestBody User us) {
        userRepo.save(us);
    }
    @GetMapping("/{id}")
    public ResponseEntity<User> get(@PathVariable Integer id) {
        try {
            User us = userRepo.findById(id).get();
            return new ResponseEntity<User>(us, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Integer id) {
        userRepo.deleteById(id);
    }
    @RequestMapping(value = "/{id}",
            produces = "application/json",
            method=RequestMethod.PUT)
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody User uss, @PathVariable Integer id) {
        try {
            User us = userRepo.findById(id).get();
            us.setId(uss.getId());
            us.setUsername(uss.getUsername());
            us.setEmail(uss.getEmail());
            us.setPhoneNumber(uss.getPhoneNumber());
            us.setGender(uss.getGender());
            us.setFullName(uss.getFullName());
            us.setImage(uss.getImage());
            userRepo.save(us);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}