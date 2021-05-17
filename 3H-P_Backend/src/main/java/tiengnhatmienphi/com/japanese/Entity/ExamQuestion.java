package tiengnhatmienphi.com.japanese.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.transaction.Transactional;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "exam_question")
@Transactional
public class ExamQuestion {
    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "exam_id")
    private Integer exam_id;
    @Column(name = "question_id")
    private Integer room_id;


}
