package global.service;

import global.dto.SimpleResponse;
import global.dto.request.CourseRequest;
import global.dto.response.CourseResponse;
import java.util.List;

public interface CourseService {

    SimpleResponse saveCourse(Long companyId,CourseRequest courseRequest);
    List<CourseResponse> getAllCourse();
    List<CourseResponse> getAllByCourseId(Long courseId);
    SimpleResponse updateCourse(Long courseId,CourseRequest courseRequest);
    CourseResponse getCourseById(Long courseId);
    SimpleResponse deleteCourse(Long courseId);
    List<CourseResponse>sortCourse(Long companyId,String word);
}