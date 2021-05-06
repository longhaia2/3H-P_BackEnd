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
public class Result {
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


//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "user_id")
//    private User userResult;
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "exam_id")
//    private Exam exam_result;
}