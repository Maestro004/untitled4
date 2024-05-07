package Java13.dao.daoImpl;

import Java13.config.HibernateConfig;
import Java13.dao.CourseDao;
import Java13.entity.Course;
import Java13.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

import java.util.ArrayList;
import java.util.List;

public class CourseDaoImpl implements CourseDao {

    private final EntityManagerFactory entityManagerFactory = HibernateConfig.entityManagerFactory();
    @Override
    public String createCourse(Course course) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(course);
            entityManager.getTransaction().commit();
            entityManager.close();
            return "Студент успешно создан.";
        } catch (Exception e) {
            if (entityManager.getTransaction().isActive())
                entityManager.getTransaction().rollback();
            entityManager.close();
            return "Ошибка при создании студента: " + e.getMessage();
        }
    }

    @Override
    public Course getCourseById(Long courseId) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Course foundCourse = null;
        try {
            entityManager.getTransaction().begin();
            Course course = entityManager.find(Course.class, courseId);
            if (course != null) {
                foundCourse = course;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            entityManager.close();
        }
        return foundCourse;
    }

    @Override
    public String updateCourseName(String courseName, Long courseId) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            Course course = entityManager.find(Course.class, courseId);
            course.setName(courseName);
            entityManager.merge(course);
            entityManager.getTransaction().commit();
            return "Имя студента успешно обновлено: " + course.getName();
        } catch (Exception e) {
            if (entityManager.getTransaction().isActive())
                entityManager.getTransaction().rollback();
            return "Ошибка при обновлении имени студента: " + e.getMessage();
        } finally {
            entityManager.close();
        }
    }

    @Override
    public String deleteCourse(Long courseId) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            Course course = entityManager.find(Course.class, courseId);
            entityManager.remove(course);
            entityManager.getTransaction().commit();
            return "Студент успешно удален.";
        } catch (Exception e) {
            if (entityManager.getTransaction().isActive())
                entityManager.getTransaction().rollback();
            return "Ошибка при удалении студента: " + e.getMessage();
        } finally {
            entityManager.close();
        }
    }

    @Override
    public List<Course> getAllCourse() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.createQuery("select c from Course c",)
        }
    }

    @Override
    public String assignStudentToCourse(Long studentId, Long courseId) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            Student student = entityManager.find(Student.class, studentId);
            Course course = entityManager.find(Course.class, courseId);
            if (student != null && course != null) {
                course.addStudent(student);
                student.addCourse(course);
                entityManager.getTransaction().commit();
                return "Студент успешно добавлен к курсу.";
            } else {
                return "Студент или курс не найден.";
            }
        } catch (Exception e) {
            if (entityManager.getTransaction().isActive())
                entityManager.getTransaction().rollback();
            return "Ошибка при добавлении студента к курсу: " + e.getMessage();
        } finally {
            entityManager.close();
        }
    }
}
