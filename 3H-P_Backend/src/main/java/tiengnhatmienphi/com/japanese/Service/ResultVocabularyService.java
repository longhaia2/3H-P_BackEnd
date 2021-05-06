package tiengnhatmienphi.com.japanese.Service;


import org.springframework.stereotype.Service;
import tiengnhatmienphi.com.japanese.payload.request.ResultVocabularyRequest;
import tiengnhatmienphi.com.japanese.payload.response.GenericResponse;


public interface ResultVocabularyService {
    GenericResponse create(ResultVocabularyRequest request);

    Object findById(Integer id);
}
