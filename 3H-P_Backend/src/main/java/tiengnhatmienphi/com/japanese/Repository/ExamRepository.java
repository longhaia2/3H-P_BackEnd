package tiengnhatmienphi.com.japanese.Repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tiengnhatmienphi.com.japanese.Entity.Exam;

import javax.transaction.Transactional;
import java.util.List;

public interface ExamRepository extends JpaRepository<Exam,Integer> {


    @Query("SELECT u from Exam  u where u.status=1 order by u.id desc ")
    List<Exam> getlistExamOrderByIdDesc();


    //@Query(value = "select  * from exam where code_exam like %:examCode% or subject_id like %:subjectId% or class_id like %:classId%",nativeQuery = true)
    @Query(value = "select  * from exam where (:examCode IS NULL or code_exam like %:examCode% ) " +
            "and (:subjectId IS NULL OR subject_id = :subjectId) " +
            "and (:classId IS NULL OR class_id  = :classId)",nativeQuery = true)
    Page<Exam> searchExam(@Param("examCode") String examCode, @Param("subjectId") String subjectId, @Param("classId") String classId, Pageable pageable);


//    @Modifying
    @Transactional
    @Query("update Exam ex set ex.status=0 where ex.id =:examId")
    void disableExam(@Param("examId") Integer examId);

    @Modifying
    @Transactional
    @Query("update Exam ex set ex.status=:status where ex.id=:examId")
    void updateStatus(@Param("examId") Integer examId, @Param("status") Integer status);

    @Query("SELECT u from Exam  u where u.status=1 order by u.id desc ")
    List<Exam> getlistExamNew();

}
