package Java13.dao;

import Java13.entity.Student;

import java.util.List;

public interface StudentDao {
    String createStudent(Student newStudent);
    Student getStudentById(Long  studentId);
    String updateStudentName(String name, Long studentId);
    String deleteStudent(Long studentId);

    List<Student> getCourseStudents(Long courseId);
    List<Student> getStudentsByRecentEnrollments();
}
