package Java13.service.serviceImpl;

import Java13.dao.CourseDao;
import Java13.dao.daoImpl.CourseDaoImpl;
import Java13.entity.Course;
import Java13.service.CourseService;

import java.util.List;

public class CourseServiceImpl implements CourseService {
    private final CourseDao dao = new CourseDaoImpl();

    @Override
    public String createCourse(Course course) {
        return dao.createCourse(course);
    }

    @Override
    public Course getCourseById(Long courseId) {
        return dao.getCourseById(courseId);
    }

    @Override
    public String updateCourseName(String courseName, Long courseId) {
        return dao.updateCourseName(courseName, courseId);
    }

    @Override
    public String deleteCourse(Long courseId) {
        return dao.deleteCourse(courseId);
    }

    @Override
    public List<Course> getAllCourses() {
        return dao.getAllCourse();
    }

    @Override
    public String assignStudentToCourse(Long studentId, Long courseId) {
        return dao.assignStudentToCourse(studentId, courseId);
    }
}
