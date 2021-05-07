package tiengnhatmienphi.com.japanese;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;
import tiengnhatmienphi.com.japanese.Entity.Role;
import tiengnhatmienphi.com.japanese.Entity.User;
import tiengnhatmienphi.com.japanese.Entity.enums.ERole;
import tiengnhatmienphi.com.japanese.Repository.RoleRepository;
import tiengnhatmienphi.com.japanese.Repository.RoomChallengeRepo;
import tiengnhatmienphi.com.japanese.Repository.UserRepository;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class JapaneseApplication {

    public static void main(String[] args) {
        SpringApplication.run(JapaneseApplication.class, args);
    }

    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostConstruct
    public void init() {
        if(roleRepository.findByName(ERole.ROLE_MEMBER).orElse(null) == null) {
            Role roleMember = new Role(ERole.ROLE_MEMBER);
            roleRepository.save(roleMember);
        }
        if(roleRepository.findByName(ERole.ROLE_ADMIN).orElse(null) == null) {
            Role roleAdmin = new Role(ERole.ROLE_ADMIN);
            roleRepository.save(roleAdmin);
        }

//        User user = new User();
//        user.setEnable(true);
//        user.setUsername("admin");
//        user.setPassword(passwordEncoder.encode("12345"));
//        user.setRole(roleRepository.findByName(ERole.ROLE_ADMIN).get());
//
//        userRepository.save(user);
    }
}
