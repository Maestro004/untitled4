package Java13.dao.daoImpl;

import Java13.config.HibernateConfig;
import Java13.dao.StudentDao;
import Java13.entity.Course;
import Java13.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoImpl implements StudentDao {
    private final EntityManagerFactory entityManagerFactory = HibernateConfig.entityManagerFactory();
    @Override
    public String createStudent(Student student) {

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(student);
            entityManager.getTransaction().commit();
            entityManager.close();
            return "Курс успешно создан.";
        } catch (Exception e) {
            if (entityManager.getTransaction().isActive())
                entityManager.getTransaction().rollback();
            entityManager.close();
            return "Ошибка при создании курса: " + e.getMessage();
        }
    }

    @Override
    public Student getStudentById(Long studentId) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
         Student foundStudent = null;
        try {
            Student student = entityManager.find(Student.class, studentId);
            if (student != null) {
                foundStudent = student;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            entityManager.close();
        }
        return foundStudent;
    }

    @Override
    public String updateStudentName(String name, Long studentId) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            Student student = entityManager.find(Student.class, studentId);
            student.setFullName(name);
            entityManager.merge(student);
            entityManager.getTransaction().commit();
            return "Курс успешно обновлен: " + student.getFullName();
        } catch (Exception e) {
            if (entityManager.getTransaction().isActive())
                entityManager.getTransaction().rollback();
            return "Ошибка при обновлении курса: " + e.getMessage();
        } finally {
            entityManager.close();
        }
    }

    @Override
    public String deleteStudent(Long studentId) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            Student student = entityManager.find(Student.class, studentId);
            entityManager.remove(student);
            entityManager.getTransaction().commit();
            return "Курс успешно удален.";
        } catch (Exception e) {
            if (entityManager.getTransaction().isActive())
                entityManager.getTransaction().rollback();
            return "Ошибка при удалении курса: " + e.getMessage();
        } finally {
            entityManager.close();
        }
    }

    @Override
    public List<Student> getCourseStudents(Long courseId) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        List<Student> students = new ArrayList<>();
        try {
            entityManager.getTransaction().begin();
            Course course = entityManager.find(Course.class, courseId);
            if (course != null) {
                students.addAll(course.getStudents());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            entityManager.close();
        }
        return students;
    }

    @Override
    public List<Student> getStudentsByRecentEnrollments() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        List<Student> students = new ArrayList<>();
        try {
            entityManager.getTransaction().begin();
            LocalDate cutoffDate = LocalDate.now().minusMonths(3);
            List<Student> list = entityManager.createQuery("select s from Student s",
                    Student.class).getResultList();
            for (Student student : list) {
                if (cutoffDate.isBefore(student.getEnrollmentDate())){
                    students.add(student);
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            entityManager.close();
        }
        return students;
    }
}
