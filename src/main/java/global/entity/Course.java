package global.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;
import java.util.List;
import static jakarta.persistence.CascadeType.*;

@Entity
@Table(name = "courses")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Course {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "course_gen")
    @SequenceGenerator(
            name = "course_gen",
            sequenceName = "course_seq",
            allocationSize = 1)
    private Long id;
    private String courseName;
    private LocalDate dateOfStart;
    private String description;
    @ManyToOne(cascade ={PERSIST,DETACH,REFRESH,MERGE})
    private Instructor instructor;
    @ManyToOne(cascade ={PERSIST,DETACH,REFRESH,MERGE})
    @JsonIgnore
    private Company company;
    @ManyToMany(cascade ={PERSIST,DETACH,REFRESH,MERGE})
    private List<Group> groups;
    @OneToMany(mappedBy = "course",cascade = ALL)
    private List<Lesson> lessons;
}