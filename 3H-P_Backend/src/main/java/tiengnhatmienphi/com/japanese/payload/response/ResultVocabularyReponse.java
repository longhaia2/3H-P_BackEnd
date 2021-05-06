package tiengnhatmienphi.com.japanese.payload.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResultVocabularyReponse {

    private Integer id;
    private Integer examId;
    private Integer score;
    private List<String> ansSelects;
    private List<String> ansCorrects;
}
