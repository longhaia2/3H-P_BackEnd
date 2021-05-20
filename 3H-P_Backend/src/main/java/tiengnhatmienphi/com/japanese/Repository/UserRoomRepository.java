package tiengnhatmienphi.com.japanese.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tiengnhatmienphi.com.japanese.Entity.Lesson;
import tiengnhatmienphi.com.japanese.Entity.UserRoom;

import java.util.List;

public interface UserRoomRepository extends JpaRepository<UserRoom,Integer> {

    @Query("SELECT UR FROM UserRoom UR WHERE  UR.room_id=:room_id and UR.banker=1")
    List<UserRoom> ListByRoom(@Param("room_id") Integer room_id);

    @Query("SELECT UR FROM UserRoom UR WHERE  UR.room_id=:room_id and UR.user_id=:user_id")
    List<UserRoom> ListByRoomAndUser(@Param("room_id") Integer room_id,@Param("user_id") Integer user_id);

    @Query("SELECT UR FROM UserRoom UR WHERE  UR.room_id=:room_id order by UR.id asc")
    List<UserRoom> ListUsersByRoom(@Param("room_id") Integer room_id);

    @Query("SELECT U.username, UR.score FROM User U, UserRoom UR WHERE (UR.room_id = ?1 and UR.user_id=U.id) order by UR.score desc")
       List<Object> UsersByScore(Integer room_id);

    @Query("select u.username,max(ur.score),e.content from User u ,UserRoom ur ,Exam e where u.id=ur.user_id and ur.exam_id=e.id group by  u.username")
    List<Object> getTopHighScoreByScore();

}
