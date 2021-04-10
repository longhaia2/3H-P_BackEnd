package tiengnhatmienphi.com.japanese.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import tiengnhatmienphi.com.japanese.Entity.User;
import tiengnhatmienphi.com.japanese.Repository.UserRepository;

@Component
public class MyUserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(s).orElse(null);
        if (user == null) {
            throw new UsernameNotFoundException("Could not find by user!");
        }
        return new MyUserDetails(user);
    }
}
