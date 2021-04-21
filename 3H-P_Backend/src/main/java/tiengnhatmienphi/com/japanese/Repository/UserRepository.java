package tiengnhatmienphi.com.japanese.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tiengnhatmienphi.com.japanese.Entity.User;

import java.util.Optional;

/**
 * Phan Thi Dieu Hien
 **/

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByUsername(String userName);
}
