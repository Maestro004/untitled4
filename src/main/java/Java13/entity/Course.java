package Java13.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table( name = "courses")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Course {
    @Id
    @GeneratedValue(generator = "course_id", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "course_id", sequenceName = "course_id"
            , allocationSize = 1)
    private Long id;
    @Column (unique = true)
    private String name;
    private String description;

    @ManyToMany
    private List<Student> students;

    public void addStudent(Student student) {
        if (this.students == null) this.students = new ArrayList<>();
        this.students.add(student);
    }

    public Course(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
