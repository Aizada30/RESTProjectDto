package global.api;

import global.dto.SimpleResponse;
import global.dto.request.StudentRequest;
import global.dto.response.StudentResponse;
import global.service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RequestMapping("/api/student")
@RestController
@RequiredArgsConstructor
public class StudentApi {

    private final StudentService studentService;

    @GetMapping
    public List<StudentResponse> getAllStudent(){
        return studentService.getAllStudent();
    }

    @PostMapping
    public SimpleResponse saveStudent(@RequestBody @Valid StudentRequest studentRequest){
        return studentService.saveStudent(studentRequest);
    }

    @GetMapping("/getById")
    public StudentResponse getById(@RequestParam Long studentId){
        return studentService.getById(studentId);
    }

    @DeleteMapping
    public SimpleResponse deleteStudent(@RequestParam Long studentId){
        return studentService.deleteStudent(studentId);
    }

    @GetMapping("/update")
    public SimpleResponse updateStudent(@RequestParam Long studentId,@RequestBody StudentRequest studentRequest){
        return studentService.updateStudent(studentId,studentRequest);
    }

    @PostMapping("/assign")
    public SimpleResponse assign(@RequestParam Long groupId,@RequestParam Long studentId){
        return studentService.assignToGroup(groupId,studentId);
    }

    @PostMapping("/block")
    public SimpleResponse blockStudent(@PathVariable Boolean word,@PathVariable Long studentId){
        return studentService.blockStudent(word,studentId);
    }

    @GetMapping("/filter")
    public List<StudentResponse> getFilterStudent(@RequestParam String studyFormat){
        return studentService.getFilter(studyFormat);
    }
}