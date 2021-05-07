package tiengnhatmienphi.com.japanese.Entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "lesson")
public class Lesson {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String lesson;
    private String term;
    private String level;
    private String description;

    @Lob
    private String content;

}
