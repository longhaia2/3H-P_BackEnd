package tiengnhatmienphi.com.japanese.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
@Data
public class User extends Base{

    @Column(unique = true)
    private String username;;

    @Column
    private String password;

    @Column
    private String fullName;

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

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @EqualsAndHashCode.Exclude
    @JoinTable(name="user_room" ,joinColumns = @JoinColumn(name = "user_id"),
    inverseJoinColumns = @JoinColumn(name = "room_id")
    )
    private Collection<roomchallenge> roomchallenges;

    @OneToMany(mappedBy = "userResult",cascade = CascadeType.ALL)
    private List<Result> results;
}
