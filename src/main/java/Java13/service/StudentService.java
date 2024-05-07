package Java13.service;

import Java13.entity.Course;
import Java13.entity.Student;

import java.util.List;

public interface StudentService {
    String createStudent(Student newStudent);
    Student getStudentById(Long  studentId);
    String updateStudentName(String name, Long studentId);
    String deleteStudent(Long studentId);

    List<Student> getCourseStudents(Long courseId);
    List<Student> getStudentsByRecentEnrollments();
}
