package global.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;
import java.util.List;
import static jakarta.persistence.CascadeType.*;
import static jakarta.persistence.CascadeType.REFRESH;

@Entity
@Table(name = "lessons")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Lesson {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "lesson_gen")
    @SequenceGenerator(
            name = "lesson_gen",
            sequenceName = "lesson_seq",
            allocationSize = 1)
    private Long id;
    private String lessonName;
    private LocalDate createdAt;
    @OneToMany(mappedBy = "lesson",cascade = ALL)
    private List<Task> tasks;
    @ManyToOne(cascade ={PERSIST,DETACH,REFRESH,MERGE})
    private Course course;
}