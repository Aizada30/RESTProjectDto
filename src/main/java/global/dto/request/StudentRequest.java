package global.dto.request;

import global.StudyFormal.StudyFormat;
import global.validation.Email;
import global.validation.PhoneNumberValid;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class StudentRequest {
    private String firstName;
    private String lastName;
    @PhoneNumberValid
    private String phoneNumber;
    @Email
    private String email;
    private StudyFormat studyFormat;
}