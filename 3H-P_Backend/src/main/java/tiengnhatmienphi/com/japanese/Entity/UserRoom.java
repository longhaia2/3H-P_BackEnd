package tiengnhatmienphi.com.japanese.Entity;//package tiengnhatmienphi.com.japanese.Entity;
//
//import javax.persistence.*;
//
//@Entity
//@Table(name = "user_room")
//public class UserRoom {
//    @Id
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "user_id")
//    private User user_id;
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "room_id")
//    private roomchallenge room_id;
//    private int point;
//
//    public UserRoom() {
//    }
//
//    public User getUser_id() {
//        return user_id;
//    }
//
//    public void setUser_id(User user_id) {
//        this.user_id = user_id;
//    }
//
//    public roomchallenge getRoom_id() {
//        return room_id;
//    }
//
//    public void setRoom_id(roomchallenge room_id) {
//        this.room_id = room_id;
//    }
//
//    public int getPoint() {
//        return point;
//    }
//
//    public void setPoint(int point) {
//        this.point = point;
//    }
//
//    public UserRoom(User user_id, roomchallenge room_id, int point) {
//        this.user_id = user_id;
//        this.room_id = room_id;
//        this.point = point;
//    }
//}
