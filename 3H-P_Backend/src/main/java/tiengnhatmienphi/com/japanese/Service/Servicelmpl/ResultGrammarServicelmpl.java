package tiengnhatmienphi.com.japanese.Service.Servicelmpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import tiengnhatmienphi.com.japanese.Entity.Exam;
import tiengnhatmienphi.com.japanese.Entity.Question;
import tiengnhatmienphi.com.japanese.Entity.ResultGrammar;
import tiengnhatmienphi.com.japanese.Entity.User;
import tiengnhatmienphi.com.japanese.Repository.ExamRepository;
import tiengnhatmienphi.com.japanese.Repository.ResultGrammarReponsitory;
import tiengnhatmienphi.com.japanese.Repository.UserRepository;
import tiengnhatmienphi.com.japanese.Service.ResultGrammarService;
import tiengnhatmienphi.com.japanese.payload.request.ResultGrammarRequest;
import tiengnhatmienphi.com.japanese.payload.response.GenericResponse;
import tiengnhatmienphi.com.japanese.payload.response.ResultGrammarReponse;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@Transactional
public class ResultGrammarServicelmpl implements ResultGrammarService {

    @Autowired
    private ResultGrammarReponsitory resultGrammarReponsitory;

    @Autowired
    private ExamRepository examRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public GenericResponse create(ResultGrammarRequest request) {
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
        ResultGrammar resultGrammar = new ResultGrammar();
        resultGrammar.setExam_id(examId);
        resultGrammar.setUser_id(userId);
        resultGrammar.setScore(score);
        resultGrammar.setListAnsCorect(listAnsCorrect);
        resultGrammar.setListAnsSelect(listAnsSelect);

        resultGrammar = resultGrammarReponsitory.save(resultGrammar);

        return new GenericResponse("Thêm thành công", resultGrammar.getId());
    }

    @Override
    public Object findById(Integer id) {
        ResultGrammar resultGrammar = resultGrammarReponsitory.findById(id).orElse(null);
        if (resultGrammar == null) {
            return new GenericResponse(HttpStatus.BAD_REQUEST.toString(), "Không tồn tại id: " + id);
        }
        ResultGrammarReponse reponse = new ResultGrammarReponse();
        reponse.setId(resultGrammar.getId());
        reponse.setScore(resultGrammar.getScore());
        reponse.setExamId(resultGrammar.getExam_id());
        List<String> lstAnsSelect = Arrays.asList(resultGrammar.getListAnsSelect().split(","));
        List<String> lstAnsCorrect = Arrays.asList(resultGrammar.getListAnsCorect().split(","));
        reponse.setAnsSelects(lstAnsSelect);
        reponse.setAnsCorrects(lstAnsCorrect);

        return reponse;
    }
}
