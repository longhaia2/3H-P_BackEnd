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
    // /score/grammar?username= ????  thì ghi s?
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

    @GetMapping("/all")
    public ResponseEntity<?> get(@RequestParam(name = "username") String username){
        User user = userRepository.findByUsername(username).orElse(null);
        if (user == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        List<ScoreReponse> scores = new ArrayList<>();
        for (ResultGrammar resultGrammar: resultGrammarReponsitory.findAllByUser_id(user.getId())) {
            ScoreReponse score = new ScoreReponse();
            score.setExamId(resultGrammar.getExam_id());
            score.setScore(resultGrammar.getScore());
            Exam exam = examRepository.findById(resultGrammar.getExam_id()).get();
            score.setCodeExam(exam.getCodeExam());
            score.setContent(exam.getContent());

            scores.add(score);
        }
        for (ResultVocabulary resultVocabulary : resultVocabularyReponsitory.findAllByUser_id(user.getId())) {
            ScoreReponse score = new ScoreReponse();
            score.setExamId(resultVocabulary.getExam_id());
            score.setScore(resultVocabulary.getScore());
            Exam exam = examRepository.findById(resultVocabulary.getExam_id()).get();
            score.setCodeExam(exam.getCodeExam());
            score.setContent(exam.getContent());

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
}
