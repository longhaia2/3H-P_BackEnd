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

    Exam findByLevelAndId(String level, Integer id);

    Exam findByCodeExamAndId(String code_exam, Integer id);
    //dang suy nghi dm

    @Query("SELECT E FROM Exam E WHERE E.level = :level AND  E.term='Đề JPLT'order by E.id desc ")
    List<Exam>findBylevelCodeExam(@Param("level") String level);

    @Query("SELECT u from Exam  u where u.term='Đề JPLT' order by u.id desc ")
    List<Exam> getlistExamOrderByJLPTDesc();

    @Query("SELECT u from Exam  u  order by u.id desc ")
    List<Exam> getlistExamOrderByIdDesc();

    //@Query(value = "select  * from exam where code_exam like %:examCode% or subject_id like %:subjectId% or class_id like %:classId%",nativeQuery = true)
    @Query(value = "select  * from exam where (:examCode IS NULL or code_exam like %:examCode% ) " +
            "and (:subjectId IS NULL OR subject_id = :subjectId) " +
            "and (:classId IS NULL OR class_id  = :classId)",nativeQuery = true)
    Page<Exam> searchExam(@Param("examCode") String examCode, @Param("subjectId") String subjectId, @Param("classId") String classId, Pageable pageable);

    @Query("SELECT u from Exam  u where u.status=1 order by u.id desc ")
    List<Exam> getlistExamNew();

    @Query(value ="select * from Exam ex where  ex.code_exam like ?1", nativeQuery = true)
    List<Exam> findByCodeExam(String searchText);

    @Query("SELECT L FROM Exam L WHERE  L.level = :level  AND L.term = :term")
    List<Exam>findByLevelTerm(@Param("level") String level, @Param("term") String term);

}
