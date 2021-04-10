package tiengnhatmienphi.com.japanese.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

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
}
