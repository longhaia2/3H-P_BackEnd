package tiengnhatmienphi.com.japanese.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tiengnhatmienphi.com.japanese.Entity.Roomchallenge;

public interface RoomChallengeRepo extends JpaRepository<Roomchallenge, Integer> {
    @Query(value = "select count(*) from user_room where room_id=?1",nativeQuery = true)
    Integer DemNguoi(int room_id);
}
