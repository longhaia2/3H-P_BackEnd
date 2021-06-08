package tiengnhatmienphi.com.japanese.payload.request;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class ResultVocabularyRequest {
    private Integer user_id;
    private Integer exam_id;
    private List<String> ansSelects;
    private String date_test;
}
