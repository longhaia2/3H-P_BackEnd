package tiengnhatmienphi.com.japanese.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import tiengnhatmienphi.com.japanese.Entity.Role;
import tiengnhatmienphi.com.japanese.Entity.User;
import tiengnhatmienphi.com.japanese.Entity.enums.ERole;
import tiengnhatmienphi.com.japanese.Repository.RoleRepository;
import tiengnhatmienphi.com.japanese.Repository.UserRepository;
import tiengnhatmienphi.com.japanese.payload.request.AuthRequest;
import tiengnhatmienphi.com.japanese.payload.response.GenericResponse;
import tiengnhatmienphi.com.japanese.payload.response.LoginResponse;
import tiengnhatmienphi.com.japanese.security.JwtTokenProvider;
import tiengnhatmienphi.com.japanese.security.MyUserDetails;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/api/auth")
public class AuthController {
    @Autowired
    UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private RoleRepository roleRepository;

    @CrossOrigin
    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody() AuthRequest loginRequest) {
        try {
            Authentication authentication;
            authentication =
                    authenticationManager.authenticate(
                            new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));


            // Set th??ng tin authentication v??o Security Context
            SecurityContextHolder.getContext().setAuthentication(authentication);
            // Tr??? v??? jwt cho ng?????i d??ng.
            MyUserDetails userDetails = (MyUserDetails) authentication.getPrincipal();
            String jwt = jwtTokenProvider.generateToken(userDetails);

            return  ResponseEntity.ok(new LoginResponse(
                    userDetails.getUsername(),
                    jwt,
                    userDetails.getAuthorities().stream().findFirst().get().toString(),
                    userDetails.getUserId()
            ));
        } catch (RuntimeException exception) {
            return  ResponseEntity.ok(new GenericResponse(HttpStatus.FORBIDDEN.toString(),"T??n ????ng nh???p ho???c m???t kh???u kh??ng ????ng"));
        }
    }

    @CrossOrigin
    @PostMapping("/signup")
    public ResponseEntity<Object> signup(@RequestBody AuthRequest registerRequest) {
        GenericResponse response = new GenericResponse();
        if (userRepository.findByUsername(registerRequest.getUsername()).orElse(null) != null) {
            return ResponseEntity.ok(new GenericResponse(HttpStatus.BAD_REQUEST.toString(), "???? t???n t???i t??n t??i kho???n n??y!"));
        }
        User user = new User();
        user.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
        user.setUsername(registerRequest.getUsername());

        // Set role member cho user, m???c ?????nh t???t c??? user m???i ????ng k?? ?????u c?? Role Member
        Role role = roleRepository.findByName(ERole.ROLE_MEMBER).get();
        if (role == null) {
            return ResponseEntity.ok(new GenericResponse("ROLE_MEMBER kh??ng t???n t???i!"));
        }
        user.setRole(role);
        userRepository.save(user);

        return ResponseEntity.ok(new GenericResponse("T???o t??i kho???n th??nh c??ng!"));
    }

}
