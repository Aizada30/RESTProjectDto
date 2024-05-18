package global.service;

import global.dto.SimpleResponse;
import global.dto.request.InstructorRequest;
import global.dto.response.InstructorResponse;
import java.util.List;

public interface InstructorService {

    SimpleResponse saveInstructor(InstructorRequest instructorRequest);
    List<InstructorResponse> getAllInstructors();
    SimpleResponse deleteInstructor(Long instructorId);
    SimpleResponse updateInstructor(Long instructorId,InstructorRequest instructorRequest);
    InstructorResponse getInstructorById(Long instructorId);
    SimpleResponse assignWithCompany(Long companyId,Long instructorId);
    StudentCountResponse getCountStudent(Long id);
}