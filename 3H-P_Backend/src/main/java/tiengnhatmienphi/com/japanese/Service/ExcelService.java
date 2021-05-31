package tiengnhatmienphi.com.japanese.Service;


import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import tiengnhatmienphi.com.japanese.Helper.ExcelHelper;
import tiengnhatmienphi.com.japanese.Entity.Question;
import tiengnhatmienphi.com.japanese.Repository.QuestionRepository;

@Service
public class ExcelService {
    @Autowired
    QuestionRepository repo;

    public void save(MultipartFile file) {
        try {
            List<Question> questions = ExcelHelper.excelToTutorials(file.getInputStream());
            repo.saveAll(questions);
        } catch (IOException e) {
            throw new RuntimeException("fail to store excel data: " + e.getMessage());
        }
    }

    public List<Question> getAllTutorials() {
        return repo.findAll();
    }
}
