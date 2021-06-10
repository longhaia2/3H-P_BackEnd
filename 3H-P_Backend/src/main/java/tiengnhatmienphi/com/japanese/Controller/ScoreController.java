package tiengnhatmienphi.com.japanese.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tiengnhatmienphi.com.japanese.Entity.*;
import tiengnhatmienphi.com.japanese.Repository.*;
import tiengnhatmienphi.com.japanese.payload.response.GenericResponse;
import tiengnhatmienphi.com.japanese.payload.response.ScoreReponse;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/score")
public class ScoreController {

    @Autowired
    private ResultGrammarReponsitory resultGrammarReponsitory;

    @Autowired
    private ExamRepository examRepository;

    @Autowired
    private ResultVocabularyReponsitory resultVocabularyReponsitory;

    @Autowired
    ResultRepository resultRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/all-grammar")
    public ResponseEntity<?> get(@RequestParam(name = "username") String username){
        User user = userRepository.findByUsername(username).orElse(null);
        if (user == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        List<ScoreReponse> scores = new ArrayList<>();
        for (ResultGrammar resultGrammar: resultGrammarReponsitory.findAllByUser_id(user.getId())) {
            ScoreReponse score = new ScoreReponse();
            score.setId(resultGrammar.getId());
            score.setExamId(resultGrammar.getExam_id());
            score.setScore(resultGrammar.getScore());
            Exam exam = examRepository.findById(resultGrammar.getExam_id()).get();
            score.setCodeExam(exam.getCodeExam());
            score.setContent(exam.getContent());
            score.setDate_test(resultGrammar.getDate_test());
            score.setTotal_question(exam.getTotalQuestion());
            scores.add(score);
        }
        for (Result result : resultRepository.findAllByUserResult(user.getId())) {
            ScoreReponse score = new ScoreReponse();
            score.setExamId(result.getExam_result().getId());
            score.setScore(result.getScore().intValue());
            Exam exam = result.getExam_result();
            score.setCodeExam(exam.getCodeExam());
            score.setContent(exam.getContent());

            scores.add(score);
        }
        return ResponseEntity.ok(new GenericResponse("Thành công", scores));
    }

    @GetMapping("/all-voca")
    public ResponseEntity<?> getVoca(@RequestParam(name = "username") String username){
        User user = userRepository.findByUsername(username).orElse(null);
        if (user == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        List<ScoreReponse> scores = new ArrayList<>();
        for (ResultVocabulary resultVocabulary : resultVocabularyReponsitory.findAllByUser_id(user.getId())) {
            ScoreReponse score = new ScoreReponse();
            score.setId(resultVocabulary.getId());
            score.setExamId(resultVocabulary.getExam_id());
            score.setScore(resultVocabulary.getScore());
            Exam exam = examRepository.findById(resultVocabulary.getExam_id()).get();
            score.setCodeExam(exam.getCodeExam());
            score.setContent(exam.getContent());
            score.setTotal_question(exam.getTotalQuestion());
            score.setDate_test(resultVocabulary.getDate_test());

            scores.add(score);
        }
        for (Result result : resultRepository.findAllByUserResult(user.getId())) {
            ScoreReponse score = new ScoreReponse();
            score.setExamId(result.getExam_result().getId());
            score.setScore(result.getScore().intValue());
            Exam exam = result.getExam_result();
            score.setCodeExam(exam.getCodeExam());
            score.setContent(exam.getContent());

            scores.add(score);
        }
        return ResponseEntity.ok(new GenericResponse("Thành công", scores));
    }

    @GetMapping("/result-all")
    public List<Object> getAllResult(){
        List<Object> allresult = resultGrammarReponsitory.getAllResult();
        return allresult;
    }
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Integer id) {
        resultGrammarReponsitory.deleteById(id);
    }

    @GetMapping("/result-voca-all")
    public List<Object> getAllResultVoCa(){
        List<Object> allresult = resultVocabularyReponsitory.getAllResult();
        return allresult;
    }
    @DeleteMapping("/delete-voca/{id}")
    public void deleteVoca(@PathVariable Integer id) {
        resultVocabularyReponsitory.deleteById(id);
    }


}
