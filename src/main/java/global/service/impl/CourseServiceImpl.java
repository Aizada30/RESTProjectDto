package global.service.impl;

import global.dto.SimpleResponse;
import global.dto.request.CourseRequest;
import global.dto.response.CourseResponse;
import global.entity.Company;
import global.entity.Course;
import global.repo.CompanyRepo;
import global.repo.CourseRepo;
import global.service.CourseService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@Transactional
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {

    private final CourseRepo courseRepo;
    private final CompanyRepo companyRepo;

    @Override
    public SimpleResponse saveCourse(Long companyId, CourseRequest courseRequest) {
        Course course = new Course();
        Company company = companyRepo.getBYId(companyId);
        course.setCourseName(courseRequest.getCourseName());
        course.setDateOfStart(courseRequest.getDateOfStart());
        course.setDescription(courseRequest.getDescription());
        course.setCompany(company);
        company.getCourses().add(course);
        courseRepo.save(course);
        companyRepo.save(company);
        return new SimpleResponse(
                HttpStatus.OK,
                String.format("Company with id: %s successfully saved in company " + companyId, course.getId())
        );
    }

    @Override
    public List<CourseResponse> getAllCourse() {
        return courseRepo.getAllCourse();
    }

    @Override
    public List<CourseResponse> getAllByCourseId(Long companyId) {
        return courseRepo.getCoursesByCompanyId(companyId);
    }


    @Override
    public SimpleResponse updateCourse(Long courseId, CourseRequest courseRequest) {
        Course course = courseRepo.getCourseBYIdNot(courseId);
        course.setCourseName(courseRequest.getCourseName());
        course.setDateOfStart(courseRequest.getDateOfStart());
        course.setDescription(courseRequest.getDescription());
        courseRepo.save(course);
        return new SimpleResponse(
                HttpStatus.OK,
                String.format("Course with id:%s successfully updated", course.getId())
        );
    }

    @Override
    public CourseResponse getCourseById(Long courseId) {
        return courseRepo.getCourseById(courseId).orElseThrow(
                () -> new NoSuchElementException(
                        "Course with id: " + courseId + " not found"
                ));
    }

    @Override
    public SimpleResponse deleteCourse(Long courseId) {
        courseRepo.deleteCourseById(courseId);
        return new SimpleResponse(
                HttpStatus.OK,
                String.format("Course with id:%s successfully deleted", courseId)
        );
    }

    @Override
    public List<CourseResponse> sortCourse(Long companyId, String ascOrDesc) {
        if (ascOrDesc.equalsIgnoreCase("asc")) {
            return courseRepo.getAllSortedCourseAsc(companyId);
        } else if (ascOrDesc.equalsIgnoreCase("desc")) {
            return courseRepo.getAllSortedCourseDesc(companyId);
        } else {
            throw new NullPointerException("is empty");
        }
    }
}