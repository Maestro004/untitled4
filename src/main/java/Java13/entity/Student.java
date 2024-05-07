package Java13.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table( name = "student")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Student {
    @Id
    @GeneratedValue(generator = "student_id", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "student_id", sequenceName = "student_id"
            , allocationSize = 1)
    private Long id;
    private String fullName;
    @Column (unique = true)
    private String email;
    private LocalDate enrollmentDate;

    @ManyToMany
    private List<Course> courses;

    public String getName() {

        return "";
    }

    public void addCourse(Course course) {
        if (this.courses == null) this.courses = new ArrayList<>();
        this.courses.add(course);
    }
}
