package global.dto.request;

import global.validation.PhoneNumberValid;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class InstructorRequest {
    private String firstName;
    private String lastName;
    @PhoneNumberValid
    private String phoneNumber;
    private String specialization;
}