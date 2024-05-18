package global.repo;

import global.dto.response.InstructorResponse;
import global.entity.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface InstructorRepo extends JpaRepository<Instructor, Long> {

    @Query("SELECT NEW global.dto.response.InstructorResponse(i.id,i.firstName,i.lastName,i.phoneNumber,i.specialization,i.createdAt) FROM Instructor i")
    List<InstructorResponse> getAllInstructors();

    @Query("SELECT NEW global.dto.response.InstructorResponse(i.id,i.firstName,i.lastName,i.phoneNumber,i.specialization,i.createdAt) FROM Instructor i WHERE i.id=:instructorId")
    InstructorResponse getInstructorResponseById(Long instructorId);

    Instructor getInstructorById(Long instructorId);

    @Query("select (count(s)) from Instructor i join i.companies c join c.courses co join co.groups g join g.students s where i.id =:instructorId")
    int getAllCount(@Param("instructorId") Long instructorId);
}