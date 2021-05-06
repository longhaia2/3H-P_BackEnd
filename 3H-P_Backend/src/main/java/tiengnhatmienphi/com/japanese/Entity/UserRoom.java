package tiengnhatmienphi.com.japanese.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.transaction.Transactional;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "user_room")
@Transactional
public class UserRoom {

    @Id
    @GeneratedValue
    private Integer id;

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
