package global.service;

import global.dto.SimpleResponse;
import global.dto.request.LessonRequest;
import global.dto.response.LessonResponse;

import java.util.List;

public interface LessonService {

    SimpleResponse saveLesson(Long courseId, LessonRequest lessonRequest);
    List<LessonResponse> getAllLessons();
    LessonResponse getLessonById(Long lessonId);
    SimpleResponse deleteLesson(Long lessonId);
    SimpleResponse updateLesson(Long lessonId, LessonRequest lessonRequest);


}
