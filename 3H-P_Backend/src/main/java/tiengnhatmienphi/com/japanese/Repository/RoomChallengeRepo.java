package tiengnhatmienphi.com.japanese.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tiengnhatmienphi.com.japanese.Entity.User;
import tiengnhatmienphi.com.japanese.Entity.roomchallenge;

import java.util.List;

public interface RoomChallengeRepo extends JpaRepository<roomchallenge, Integer> {

}
