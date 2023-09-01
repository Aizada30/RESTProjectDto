package global.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

import static jakarta.persistence.CascadeType.*;

@Entity
@Table(name = "groups")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Group {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "group_gen")
    @SequenceGenerator(
            name = "group_gen",
            sequenceName = "group_seq",
            allocationSize = 1)
    private Long id;
    private String groupName;
    private String imageLink;
    private String description;
    private LocalDate createdAt;

    @ManyToMany(mappedBy = "groups", cascade = {PERSIST, DETACH, REFRESH, MERGE})
    private List<Course> courses;

    @OneToMany(mappedBy = "group", cascade = ALL)
    private List<Student> students;


}
