package tiengnhatmienphi.com.japanese.Entity;


import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name="room_challenge")
public class roomchallenge {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int room_id;
    private String room_name;
    private String level;
    private String pass;
    private LocalDateTime time;

    public roomchallenge(int room_id, String room_name, String level, String pass, LocalDateTime time, int user_id) {
        this.room_id = room_id;
        this.room_name = room_name;
        this.level = level;
        this.pass = pass;
        this.time = time;
        this.user_id = user_id;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    private int user_id;

    public roomchallenge() {
    }

    public int getRoom_id() {
        return room_id;
    }

    public void setRoom_id(int room_id) {
        this.room_id = room_id;
    }

    public String getRoom_name() {
        return room_name;
    }

    public void setRoom_name(String room_name) {
        this.room_name = room_name;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }


    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

}
