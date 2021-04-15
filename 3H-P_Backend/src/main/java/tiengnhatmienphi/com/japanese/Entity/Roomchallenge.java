package tiengnhatmienphi.com.japanese.Entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Roomchallenge {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int room_id;
    private String room_name;
    private String userCreate;
    private String level;
    private String pass;
    private String time;
    private int status;
    private int cout;

    @JsonIgnore
    @ManyToMany(mappedBy = "rooms")
    private List<User>users;
}
