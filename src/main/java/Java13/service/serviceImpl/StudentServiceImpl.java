package Java13.service.serviceImpl;

import Java13.dao.StudentDao;
import Java13.dao.daoImpl.StudentDaoImpl;
import Java13.entity.Course;
import Java13.entity.Student;
import Java13.service.StudentService;

import java.util.List;

public class StudentServiceImpl implements StudentService {
    private final StudentDao dao = new StudentDaoImpl();

    @Override
    public String createStudent(Student newStudent) {
        return dao.createStudent(newStudent);
    }

    @Override
    public Student getStudentById(Long studentId) {
        return dao.getStudentById(studentId);
    }

    @Override
    public String updateStudentName(String name, Long studentId) {
        return dao.updateStudentName(name, studentId);
    }

    @Override
    public String deleteStudent(Long studentId) {
        return dao.deleteStudent(studentId);
    }

    @Override
    public List<Student> getCourseStudents(Long courseId) {
        return dao.getCourseStudents(courseId);
    }

    @Override
    public List<Student> getStudentsByRecentEnrollments() {
        return dao.getStudentsByRecentEnrollments();
    }
}
