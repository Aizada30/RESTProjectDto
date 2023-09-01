package global.api;

import global.dto.SimpleResponse;
import global.dto.request.InstructorRequest;
import global.dto.response.InstructorResponse;
import global.service.InstructorService;
import global.service.StudentCountResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/instructor")
@RestController
@RequiredArgsConstructor
public class InstructorApi {

    private final InstructorService instructorService;

    @GetMapping
    public List<InstructorResponse> getAll(){
        return instructorService.getAllInstructors();
    }

    @PostMapping
    public SimpleResponse saveInstructor(@RequestBody  InstructorRequest instructorRequest){
        return instructorService.saveInstructor(instructorRequest);
    }

    @GetMapping("/deleteIn")
    public SimpleResponse deleteInstructor(@RequestParam Long instructorId){
        return instructorService.deleteInstructor(instructorId);
    }

    @GetMapping("/getById")
    public InstructorResponse getInstructorById(@RequestParam Long instructorId){
        return instructorService.getInstructorById(instructorId);
    }

    @PostMapping("/assign")
    public SimpleResponse assign(@RequestParam Long companyId,@RequestParam Long instructorId){
        return instructorService.assignWithCompany(companyId,instructorId);
    }

    @GetMapping("/updateIn")
    public SimpleResponse update(@RequestParam Long instructorId,@RequestBody InstructorRequest instructorRequest){
        return instructorService.updateInstructor(instructorId,instructorRequest);
    }

    @GetMapping("/count")
    public StudentCountResponse getCount(@RequestParam Long id){
        return instructorService.getCountStudent(id);
    }
}
