package tiengnhatmienphi.com.japanese.payload.response;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ScoreReponse {
    private Integer examId;
    private Integer score;
    private String codeExam;
    private String content;
}
