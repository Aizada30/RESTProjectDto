package global.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import global.StudyFormal.StudyFormat;
import global.validation.Email;
import global.validation.PhoneNumberValid;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;
import static jakarta.persistence.CascadeType.*;
import static jakarta.persistence.CascadeType.REFRESH;
@Entity
@Table(name = "students")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_gen")
    @SequenceGenerator(
            name = "student_gen",
            sequenceName = "student_seq",
            allocationSize = 1)
    private Long id;
    private String firstName;
    private String lastName;
    @PhoneNumberValid
    private String phoneNumber;
    @Column(unique = true)
    @Email
    private String email;
    private StudyFormat studyFormat;
    private LocalDate createdAt;
    private Boolean isBlocked;
    @ManyToOne(cascade ={PERSIST,DETACH,REFRESH,MERGE})
    @JsonIgnore
    private Group group;
}