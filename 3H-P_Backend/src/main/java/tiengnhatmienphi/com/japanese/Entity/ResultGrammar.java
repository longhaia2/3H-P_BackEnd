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
public class ResultGrammar {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "score")
    private Integer score;

    @Column(name="user_id")
    private Integer user_id;

    @Column(name="exam_id")
    private Integer exam_id;

    @Column(name = "listAnsSelect", columnDefinition="TEXT")
    private String listAnsSelect;

    @Column(name = "listAnsCorect", columnDefinition="TEXT")
    private String listAnsCorect;
}