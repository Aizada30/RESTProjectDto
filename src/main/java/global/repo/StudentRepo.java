package global.repo;

import global.dto.response.StudentResponse;
import global.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentRepo extends JpaRepository<Student,Long> {

    @Query("SELECT NEW global.dto.response.StudentResponse(s.id,s.firstName,s.lastName,s.phoneNumber,s.email,s.studyFormat,s.createdAt,s.isBlocked)FROM Student s")
    List<StudentResponse> getAllStudents();


    @Query("SELECT NEW global.dto.response.StudentResponse(s.id,s.firstName,s.lastName,s.phoneNumber,s.email,s.studyFormat,s.createdAt,s.isBlocked)FROM Student s WHERE s.id=:studentId")
    StudentResponse getBYIdQ(Long studentId);

    @Query("SELECT new global.dto.response.StudentResponse(s.id,s.firstName,s.lastName,s.phoneNumber,s.email,s.studyFormat,s.createdAt,s.isBlocked) FROM Student s WHERE s.studyFormat='ONLINE'")
    List<StudentResponse> getFilterOnLine();
    @Query("SELECT new global.dto.response.StudentResponse(s.id,s.firstName,s.lastName,s.phoneNumber,s.email,s.studyFormat,s.createdAt,s.isBlocked) FROM Student s WHERE s.studyFormat='OFFLINE'")
    List<StudentResponse> getFilterOffLine();
}
