package tiengnhatmienphi.com.japanese.Service;

import tiengnhatmienphi.com.japanese.payload.request.ResultGrammarRequest;
import tiengnhatmienphi.com.japanese.payload.response.GenericResponse;

public interface ResultGrammarService {
    GenericResponse create(ResultGrammarRequest request);

    Object findById(Integer id);
}
