package global.service.impl;

import global.dto.SimpleResponse;
import global.dto.request.LessonRequest;
import global.dto.response.LessonResponse;
import global.entity.Course;
import global.entity.Lesson;
import global.repo.CourseRepo;
import global.repo.LessonRepo;
import global.service.LessonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class LessonServiceImpl implements LessonService {

    private final LessonRepo lessonRepo;
    private final CourseRepo courseRepo;


    @Override
    public SimpleResponse saveLesson(Long courseId, LessonRequest lessonRequest) {
        Course course = courseRepo.getCourseBYIdNot(courseId);
        Lesson lesson = new Lesson();
        lesson.setLessonName(lessonRequest.getLessonName());
        lesson.setCreatedAt(LocalDate.now());
        course.getLessons().add(lesson);
        lesson.setCourse(course);
        lessonRepo.save(lesson);
        return new SimpleResponse(HttpStatus.OK,String.format("Lesson with id:%s successfully saved",lesson.getId()));
    }

    @Override
    public List<LessonResponse> getAllLessons() {
        return lessonRepo.getAllLessonResponse();
    }

    @Override
    public LessonResponse getLessonById(Long lessonId) {
        return lessonRepo.getLessonById(lessonId);
    }

    @Override
    public SimpleResponse deleteLesson(Long lessonId) {
        lessonRepo.deleteById(lessonId);
        return new SimpleResponse(
                HttpStatus.OK,
                String.format("Lesson with id:%s successfully deleted",lessonId)
        );
    }

    @Override
    public SimpleResponse updateLesson(Long lessonId, LessonRequest lessonRequest) {
        Lesson lesson = lessonRepo.getReferenceById(lessonId);
        lesson.setLessonName(lessonRequest.getLessonName());
        lessonRepo.save(lesson);
        return new SimpleResponse(
                HttpStatus.OK,
                String.format("Lesson with id:%s successfully updated",lesson.getId())
        );
    }
}