package global.dto.request;


import global.StudyFormal.StudyFormat;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
public class StudentRequest {

    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private StudyFormat studyFormat;


}