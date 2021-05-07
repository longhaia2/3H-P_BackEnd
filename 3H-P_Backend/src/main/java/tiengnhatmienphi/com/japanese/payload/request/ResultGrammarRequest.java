package tiengnhatmienphi.com.japanese.payload.request;
import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;
@Data
@AllArgsConstructor
public class ResultGrammarRequest {
    private Integer user_id;
    private Integer exam_id;
    private List<String> ansSelects;
}