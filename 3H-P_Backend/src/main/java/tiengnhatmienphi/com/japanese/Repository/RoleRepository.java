package tiengnhatmienphi.com.japanese.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tiengnhatmienphi.com.japanese.Entity.Role;
import tiengnhatmienphi.com.japanese.Entity.enums.ERole;

import java.util.Optional;

/**
 * Phan Thi Dieu Hien
 **/

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
    Optional<Role> findByName(ERole role);
}
