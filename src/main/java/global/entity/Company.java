package global.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import global.validation.PhoneNumberValid;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;
import java.util.List;
import static jakarta.persistence.CascadeType.*;

@Entity
@Table(name = "companies")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Company {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "company_gen")
    @SequenceGenerator(
            name = "company_gen",
            sequenceName = "company_seq",
            allocationSize = 1)
    private Long id;
    @Column(unique = true)
    private String name;
    private String country;
    private String address;
    @PhoneNumberValid
    private String phoneNumber;
    private LocalDate createdAt;
    @ManyToMany(cascade ={PERSIST,DETACH,REFRESH,MERGE})
    @JsonIgnore
    private List<Instructor> instructors;
    @OneToMany(mappedBy = "company",cascade=ALL)
    @JsonIgnore
    private List<Course>courses;
}