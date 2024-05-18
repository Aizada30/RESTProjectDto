package global.api;

import global.dto.SimpleResponse;
import global.dto.request.CourseRequest;
import global.dto.response.CourseResponse;
import global.service.CompanyService;
import global.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/course")
@RequiredArgsConstructor
public class CourseApi {

    private final CourseService courseService;

    @GetMapping
    public List<CourseResponse> getAllCourse(){
        return courseService.getAllCourse();
    }

    @PostMapping
    public SimpleResponse saveCourse(@RequestParam Long companyId, @RequestBody CourseRequest courseRequest){
       return courseService.saveCourse(companyId,courseRequest);
    }

    @GetMapping("/getByIdCourse")
    public CourseResponse getById(@RequestParam Long courseId){
        return courseService.getCourseById(courseId);
    }

    @GetMapping("/getBYCompanyId")
    public List<CourseResponse>getAllCourseByCompanyId(@RequestParam Long companyId){
        return courseService.getAllByCourseId(companyId);
    }

    @PostMapping("/updateCourse")
    public SimpleResponse updateCourse(@RequestParam Long courseId,@RequestBody CourseRequest courseRequest){
        return courseService.updateCourse(courseId,courseRequest);
    }


    @GetMapping("/deleteCourse")
    public SimpleResponse deleteCourse(@RequestParam Long courseId){
        return courseService.deleteCourse(courseId);
    }

    @GetMapping("/test")
    public SimpleResponse deleteTest(@RequestParam Long courseId){
        return courseService.deleteCourse(courseId);
    }

    @GetMapping("/getAll")
    public List<CourseResponse> getAllCourses( @RequestParam  Long companyId, @RequestParam String ascOrDesc) {
        return courseService.sortCourse(companyId,ascOrDesc);
    }
}