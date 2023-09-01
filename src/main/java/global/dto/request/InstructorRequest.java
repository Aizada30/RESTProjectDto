package global.dto.request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class InstructorRequest {
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String specialization;

}
