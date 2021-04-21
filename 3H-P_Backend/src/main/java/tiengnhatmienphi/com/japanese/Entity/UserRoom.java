package tiengnhatmienphi.com.japanese.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "user_room")
public class UserRoom {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "room_id")
    private Integer room_id;

    @Column(name = "user_id")
    private Integer user_id;



}
