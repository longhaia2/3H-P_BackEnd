package tiengnhatmienphi.com.japanese.Entity;


import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class roomchallenge {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int room_id;
    private String room_name;
    private String userCreate;
    private String level;
    private String pass;
    private String time;
    private int status;

//    @ManyToMany(mappedBy = "roomchallenges")
//    @EqualsAndHashCode.Exclude
//    @ToString.Exclude
//    private List<User> users;
}
