package tiengnhatmienphi.com.japanese.Entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table
public class Lesson {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String lesson;
    private String term;
    private String level;
    private String description;

    @Lob
    private String content;

}
