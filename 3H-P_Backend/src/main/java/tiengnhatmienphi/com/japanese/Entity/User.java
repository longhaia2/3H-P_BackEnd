package tiengnhatmienphi.com.japanese.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
@Data
public class User extends Base{

    @Column
    private String username;

    @Column
    private String password;

    @Column
    private String fullname;

    @Column
    private String email;

    @Column
    private String phoneNumber;

    @Column
    private String gender;


    @Column
    private boolean enable = true;

    // mapping to Role
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(
            name = "role_id",
            foreignKey = @ForeignKey(name = "fk_user_role")
    )
    private Role role;

<<<<<<< HEAD
    @JsonIgnore
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
//    @JoinTable(name = "user_room",
//            joinColumns = @JoinColumn(name = "user_id"),
//            inverseJoinColumns = @JoinColumn(name = "room_id")
//    )
    private List<Roomchallenge>rooms;

    @JsonIgnore
    @OneToMany(mappedBy = "userResult",cascade = CascadeType.ALL)
    private List<Result> results;
=======
>>>>>>> 78910112e020a934e289d7c6656d71e94c33fca6

}
