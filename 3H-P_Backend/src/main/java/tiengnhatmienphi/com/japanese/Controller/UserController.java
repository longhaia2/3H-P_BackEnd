package tiengnhatmienphi.com.japanese.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tiengnhatmienphi.com.japanese.Entity.User;
import tiengnhatmienphi.com.japanese.Repository.UserRepository;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private UserRepository userRepo;
    @RequestMapping(value = "/all",
            produces = "application/json",
            method=RequestMethod.GET)

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
}