package tiengnhatmienphi.com.japanese.Service.Servicelmpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import tiengnhatmienphi.com.japanese.Entity.*;
import tiengnhatmienphi.com.japanese.Repository.ExamRepository;
import tiengnhatmienphi.com.japanese.Repository.ResultVocabularyReponsitory;
import tiengnhatmienphi.com.japanese.Repository.UserRepository;
import tiengnhatmienphi.com.japanese.Service.ResultVocabularyService;
import tiengnhatmienphi.com.japanese.payload.request.ResultVocabularyRequest;
import tiengnhatmienphi.com.japanese.payload.response.GenericResponse;
import tiengnhatmienphi.com.japanese.payload.response.ResultGrammarReponse;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;

@Service
@Transactional
public class ResultVocabularyServiceImpl implements ResultVocabularyService {


    @Autowired
    private ResultVocabularyReponsitory resultVocabularyReponsitory;

    @Autowired
    private ExamRepository examRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public GenericResponse create(ResultVocabularyRequest request) {
        Integer examId = request.getExam_id();
        Integer userId = request.getUser_id();
        Exam exam = examRepository.findById(examId).orElse(null);
        if (exam == null) {
            return new GenericResponse(HttpStatus.BAD_REQUEST.toString(), "Không tồn tại exam id: " + examId);
        }
        User user = userRepository.findById(userId).orElse(null);
        if (user == null) {
            return new GenericResponse(HttpStatus.BAD_REQUEST.toString(), "Không tồn tại user id: " + userId);
        }

        List<Question> questions = exam.getQuestions();
        String listAnsSelect = new String();
        String listAnsCorrect = new String();
        Integer score = 0;


        for (int i = 0; i < questions.size(); i++) {
            String ansCorrect = questions.get(i).getAnsCorrect();
            String ansSelect = request.getAnsSelects().get(i);

            if (ansCorrect.equals(ansSelect)) {
                score += 1;
            }

            listAnsSelect += ansSelect;
            listAnsSelect += ",";

            listAnsCorrect += ansCorrect;
            listAnsCorrect += ",";
        }
        ResultVocabulary resultVocabulary = new ResultVocabulary();
        resultVocabulary.setExam_id(examId);
        resultVocabulary.setUser_id(userId);
        resultVocabulary.setScore(score);
        resultVocabulary.setListAnsCorect(listAnsCorrect);
        resultVocabulary.setListAnsSelect(listAnsSelect);

        resultVocabulary = resultVocabularyReponsitory.save(resultVocabulary);

        return new GenericResponse("Thêm thành công", resultVocabulary.getId());
    }

    @Override
    public Object findById(Integer id) {
        ResultVocabulary resultVocabulary = resultVocabularyReponsitory.findById(id).orElse(null);
        if (resultVocabulary == null) {
            return new GenericResponse(HttpStatus.BAD_REQUEST.toString(), "Không tồn tại id: " + id);
        }
        ResultGrammarReponse reponse = new ResultGrammarReponse();
        reponse.setId(resultVocabulary.getId());
        reponse.setScore(resultVocabulary.getScore());
        reponse.setExamId(resultVocabulary.getExam_id());
        List<String> lstAnsSelect = Arrays.asList(resultVocabulary.getListAnsSelect().split(","));
        List<String> lstAnsCorrect = Arrays.asList(resultVocabulary.getListAnsCorect().split(","));
        reponse.setAnsSelects(lstAnsSelect);
        reponse.setAnsCorrects(lstAnsCorrect);

        return reponse;
    }
}