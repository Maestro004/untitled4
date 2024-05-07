package Java13.service;

import Java13.entity.Course;

import java.util.List;

public interface CourseService {
    String createCourse(Course course);
    Course getCourseById(Long courseId);
    String updateCourseName(String courseName, Long courseId);
    String deleteCourse(Long courseId);

    List<Course> getAllCourses();
    String assignStudentToCourse(Long studentId, Long courseId);
}
