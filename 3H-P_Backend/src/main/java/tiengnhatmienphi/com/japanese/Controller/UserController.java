package tiengnhatmienphi.com.japanese.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import tiengnhatmienphi.com.japanese.Entity.User;
import tiengnhatmienphi.com.japanese.Entity.enums.ERole;
import tiengnhatmienphi.com.japanese.Repository.RoleRepository;
import tiengnhatmienphi.com.japanese.Repository.UserRepository;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Phan Thi Dieu Hien
 **/

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private UserRepository userRepo;
    @Autowired
    private RoleRepository roleRepo;
    @GetMapping("/all")
    public List<User> findAll() {
        return userRepo.findAll();
    }
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
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
    @GetMapping
    public ResponseEntity<?> updateRoleAdmin(@RequestParam(name = "username") String username) {
        try {
            User us = userRepo.findByUsername(username).get();
            us.setRole(roleRepo.findByName(ERole.ROLE_ADMIN).get());
            userRepo.save(us);
            return new ResponseEntity<User>(us, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
        }
    }
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Integer id) {
        userRepo.deleteById(id);
    }
}