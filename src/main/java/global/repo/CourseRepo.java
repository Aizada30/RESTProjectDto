package global.repo;

import global.dto.response.CourseResponse;
import global.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CourseRepo extends JpaRepository<Course, Long> {

    @Query("SELECT NEW global.dto.response.CourseResponse(r.id,r.courseName,r.dateOfStart,r.description) FROM Course r")
    List<CourseResponse> getAllCourse();


    @Query("SELECT NEW global.dto.response.CourseResponse(r.id,r.courseName,r.dateOfStart,r.description) FROM Course r WHERE r.id=:courseId")
    Optional<CourseResponse> getCourseById(Long courseId);

    @Query("SELECT c FROM Course c WHERE c.id=:courseId")
    Course getCourseBYIdNot(Long courseId);

    @Query("SELECT NEW global.dto.response.CourseResponse(r.id,r.courseName,r.dateOfStart,r.description) FROM Course r WHERE r.company.id=:companyId")
    List<CourseResponse> getCoursesByCompanyId(Long companyId);


    void deleteCourseById(Long courseId);

    @Query("select new global.dto.response.CourseResponse(c.id, c.courseName, c.dateOfStart, c.description) from Course c where c.company.id = :companyId order by c.dateOfStart asc ")
    List<CourseResponse> getAllSortedCourseAsc(Long companyId);

    @Query("select new global.dto.response.CourseResponse(c.id, c.courseName, c.dateOfStart, c.description) from Course c where c.company.id = :companyId order by c.dateOfStart desc ")
    List<CourseResponse> getAllSortedCourseDesc(Long companyId);


}
