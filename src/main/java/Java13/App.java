package Java13;

import Java13.entity.Course;
import Java13.service.CourseService;
import Java13.service.StudentService;
import Java13.service.serviceImpl.CourseServiceImpl;
import Java13.service.serviceImpl.StudentServiceImpl;

import java.util.Scanner;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!");

        StudentService studentService = new StudentServiceImpl();
        CourseService courseService = new CourseServiceImpl();
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("""
        1.course
        2.student
        """);
            switch (scanner.nextInt()){
                case 1:
                    boolean while1= true;
                    while(while1){
                        System.out.println("""
                                1.Add course
                                2.Get course by id
                                3.Update course by id
                                4.Delete course by id
                                5.Get all courses
                                6.Assign student to course
                                0.Exit
                                """);
                       switch (scanner.nextInt()){
                           case 1->System.out.println(courseService.createCourse(new Course("Peaksoft", "good")));
                           case 2-> System.out.println(courseService.getCourseById(1L));
                           case 3-> System.out.println(courseService.updateCourseName("PIPI", 1L));
                           case 4-> System.out.println(courseService.deleteCourse(1L));
                           case 5-> System.out.println(courseService.getAllCourses());
                       }
                    }
                case 2:
            }
        }

    }
}
