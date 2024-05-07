package Java13.dao;

import Java13.entity.Course;

import java.util.List;

public interface CourseDao {
    String createCourse(Course course);
    Course getCourseById(Long courseId);
    String updateCourseName(String courseName, Long courseId);
    String deleteCourse(Long courseId);

    List<Course> getAllCourse();
    String assignStudentToCourse(Long studentId, Long courseId);
}
