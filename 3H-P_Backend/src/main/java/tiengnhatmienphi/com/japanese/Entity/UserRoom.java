package tiengnhatmienphi.com.japanese.Entity;

import javax.persistence.*;
import javax.transaction.Transactional;

@Entity
@Table(name = "user_room")
@Transactional
public class UserRoom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column(name = "room_id")
    private Integer room_id;

    @Column(name = "user_id")
    private Integer user_id;

    @Column(name = "score")
    private Integer score;

    @Column(name = "banker")
    private Integer banker;

    @Column(name = "status")
    private Integer status;


}
