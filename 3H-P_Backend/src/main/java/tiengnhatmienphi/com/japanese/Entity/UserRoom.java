package tiengnhatmienphi.com.japanese.Entity;

import javax.persistence.*;

@Entity
@Table(name = "user_room")
public class UserRoom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column(name = "room_id")
    private Integer room_id;

    @Column(name = "user_id")
    private Integer user_id;

}
