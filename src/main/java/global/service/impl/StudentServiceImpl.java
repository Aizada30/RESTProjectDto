package global.service.impl;

import global.dto.SimpleResponse;
import global.dto.request.StudentRequest;
import global.dto.response.StudentResponse;
import global.entity.Group;
import global.entity.Student;
import global.repo.GroupRepo;
import global.repo.InstructorRepo;
import global.repo.StudentRepo;
import global.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
@Transactional
public class StudentServiceImpl implements StudentService {

    private final StudentRepo studentRepo;
    private final GroupRepo groupRepo;

    @Override
    public SimpleResponse saveStudent(StudentRequest studentRequest) {
        Student student = new Student();
        student.setFirstName(studentRequest.getFirstName());
        student.setLastName(studentRequest.getLastName());
        student.setPhoneNumber(studentRequest.getPhoneNumber());
        student.setEmail(studentRequest.getEmail());
        student.setStudyFormat(studentRequest.getStudyFormat());
        student.setCreatedAt(LocalDate.now());
        studentRepo.save(student);
        return new SimpleResponse(
                HttpStatus.OK,
                String.format("Student with id:%s successfully saved",student.getId())
        );
    }

    @Override
    public List<StudentResponse> getAllStudent() {
        return studentRepo.getAllStudents();
    }

    @Override
    public StudentResponse getById(Long studentId) {
        return studentRepo.getBYIdQ(studentId);
    }

    @Override
    public SimpleResponse deleteStudent(Long studentId) {
        studentRepo.deleteById(studentId);
        return new SimpleResponse(
                HttpStatus.OK,
                String.format("Student with id:%s successfully deleted",studentId)
        );
    }

    @Override
    public SimpleResponse updateStudent(Long studentId, StudentRequest studentRequest) {
        Student student = studentRepo.findById(studentId).orElseThrow(() -> new NoSuchElementException("Not found"));
        student.setFirstName(studentRequest.getFirstName());
        student.setLastName(studentRequest.getLastName());
        student.setPhoneNumber(studentRequest.getPhoneNumber());
        student.setEmail(studentRequest.getEmail());
        student.setStudyFormat(studentRequest.getStudyFormat());
        studentRepo.save(student);
        return new SimpleResponse(
                HttpStatus.OK,
                String.format("Student with id:%s successfully updated",studentId)
        );
    }

    @Override
    public SimpleResponse assignToGroup(Long groupId, Long studentId) {
        Group group = groupRepo.findGroup(groupId);
        Student student = studentRepo.getReferenceById(studentId);
        group.getStudents().add(student);
        student.setGroup(group);
        return new SimpleResponse(
                HttpStatus.OK,
                String.format("Student with id:%s successfully assigned to group with id:%s",studentId,groupId)
        );
    }

    @Override
    public SimpleResponse blockStudent(Boolean word, Long studentId) {
        Student student = studentRepo.findById(studentId).orElseThrow(
                () -> new NoSuchElementException(
                        "Student with id: " + studentId + " not found"
                )
        );
        student.setIsBlocked(word);
        return new SimpleResponse(
                HttpStatus.OK,
                String.format("Student with id:%s successfully blocked",studentId)
        );
    }

    @Override
    public List<StudentResponse> getFilter(String studyFormat) {
        Student student = new Student();
        if (studyFormat.equals("ONLINE")) {
            return studentRepo.getFilterOnLine();
        } else if (studyFormat.equals("OFFLINE")) {
            return studentRepo.getFilterOffLine();
        }
        return Collections.singletonList(StudentResponse.builder().
                id(student.getId())
                .firstName(student.getFirstName())
                .lastName(student.getLastName())
                .email(student.getEmail())
                .phoneNumber(student.getPhoneNumber())
                .isBlocked(student.getIsBlocked())
                .studyFormat(student.getStudyFormat())
                .build());
    }
}