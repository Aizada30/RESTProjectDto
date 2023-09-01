package global.dto.response;

import global.StudyFormal.StudyFormat;
import global.entity.Group;
import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@Builder
public class StudentResponse {
    private Long id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private StudyFormat studyFormat;
    private LocalDate createdAt;
    private Boolean isBlocked;

    public StudentResponse(Long id, String firstName, String lastName,
                           String phoneNumber, String email, StudyFormat studyFormat,
                           LocalDate createdAt, Boolean isBlocked) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.studyFormat = studyFormat;
        this.createdAt = createdAt;
        this.isBlocked = isBlocked;
    }
}
