package tiengnhatmienphi.com.japanese.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tiengnhatmienphi.com.japanese.Entity.Lesson;

import java.util.List;

public interface LessonRepo extends JpaRepository<Lesson, Integer> {
    @Query("SELECT L FROM Lesson L WHERE L.lesson = :lesson AND L.level = :level")
    List<Lesson>findByidlessson(@Param("lesson") String lesson, @Param("level") String level);
}