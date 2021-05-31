package tiengnhatmienphi.com.japanese.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import tiengnhatmienphi.com.japanese.Helper.ExcelHelper;
import tiengnhatmienphi.com.japanese.Messege.ResponseMessage;
import tiengnhatmienphi.com.japanese.Entity.Question;
import tiengnhatmienphi.com.japanese.Service.ExcelService;

import java.util.List;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/question")
public class ExcelController {
    @Autowired
    ExcelService fileService;
    @PostMapping("/upload")
    public ResponseEntity<ResponseMessage> uploadFile(@RequestBody MultipartFile file) {
        String message = "";

        if (ExcelHelper.hasExcelFormat(file)) {
            try {
                fileService.save(file);
                message = "Uploaded the file successfully: " + file.getOriginalFilename();

                return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
            } catch (Exception e) {
                return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body( new ResponseMessage( e.getMessage()));            }
        }

        message = "Please upload an excel file!";

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage(message));

    }


//    @GetMapping("/tutorials")
//    public ResponseEntity<List<Question>> getAllTutorials() {
//        try {
//            List<Question> tutorials = fileService.getAllTutorials();
//
//            if (tutorials.isEmpty()) {
//                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//            }
//
//            return new ResponseEntity<>(tutorials, HttpStatus.OK);
//        } catch (Exception e) {
//            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
}