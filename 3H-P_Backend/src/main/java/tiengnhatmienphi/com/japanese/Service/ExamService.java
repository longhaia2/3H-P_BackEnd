package tiengnhatmienphi.com.japanese.Service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import tiengnhatmienphi.com.japanese.Entity.Exam;

import java.util.List;
import java.util.Optional;

public interface ExamService {
    Optional<Exam> findByExamId(Integer examId);
    List<Exam> getListExam();
    Page<Exam> getAllListExam(Pageable pageable);
    List<Exam> getListExamBySubjectAndClass(Integer subjectId, Integer classId);
    Exam updateExam(Exam exam);
    void createExam(Exam exam);
    void disableExam(Integer examId);
    void deleteExam(Exam exam);
    Page<Exam> searchExam(String examCode, String subjectId, String classId, Pageable pageable);
    Page<Exam> getListExamByClass(Integer classId,Pageable pageable);
    void updateStatus(Integer examId, Integer status);
    List<Exam> getListExamNew();
    List<Exam> getlistExamByClass(Integer classId);
    List<Exam> getlistExamOrdedByIDDesc();
    long countExam();
}
