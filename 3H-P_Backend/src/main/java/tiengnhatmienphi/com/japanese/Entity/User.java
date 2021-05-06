package tiengnhatmienphi.com.japanese.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

/**
 * Phan Thi Dieu Hien
 **/

@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
@Data
public class User extends Base{

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true)
    private String username;;

    @Column
    private String password;

    @Column
    private String fullName;

    @Column
    private String email;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public List<Roomchallenge> getRooms() {
        return rooms;
    }

    public void setRooms(List<Roomchallenge> rooms) {
        this.rooms = rooms;
    }

    public List<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }

    @Column
    private String phoneNumber;

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }
    @Lob
    @Column
    private String Image;

    @Column
    private String gender;

    @Column
    private boolean enable = true;


    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(
            name = "role_id",
            foreignKey = @ForeignKey(name = "fk_user_role")
    )
    private Role role;

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

}
