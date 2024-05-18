package global.repo;

import global.dto.response.LessonResponse;
import global.entity.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface LessonRepo extends JpaRepository<Lesson, Long> {

    @Query("SELECT NEW global.dto.response.LessonResponse(l.id,l.lessonName,l.createdAt)FROM Lesson l")
    List<LessonResponse> getAllLessonResponse();

    @Query("SELECT NEW global.dto.response.LessonResponse(l.id,l.lessonName,l.createdAt)FROM Lesson l WHERE l.id=:lessonId")
    LessonResponse getLessonById(Long lessonId);
}