package global.service;

import global.dto.SimpleResponse;
import global.dto.request.StudentRequest;
import global.dto.response.StudentResponse;
import java.util.List;

public interface StudentService {
    SimpleResponse saveStudent(StudentRequest studentRequest);
    List<StudentResponse> getAllStudent();
    StudentResponse getById(Long studentId);
    SimpleResponse deleteStudent(Long studentId);
    SimpleResponse updateStudent(Long studentId,StudentRequest studentRequest);
    SimpleResponse assignToGroup(Long groupId,Long studentId);
    SimpleResponse blockStudent(Boolean word,Long studentId);
    List<StudentResponse> getFilter(String studyFormat);
}