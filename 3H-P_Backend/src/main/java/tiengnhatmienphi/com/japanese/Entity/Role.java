package tiengnhatmienphi.com.japanese.Entity;

import lombok.Getter;
import lombok.Setter;
import tiengnhatmienphi.com.japanese.Entity.enums.ERole;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table
@Getter
@Setter
public class Role extends Base {
    @Column
    @Enumerated(EnumType.STRING)
    private ERole name;

    // Mapping to user
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "role")
    private Set<User> users;

    public Role(ERole name) {
        this.name = name;
    }

    public Role() {

    }
}
