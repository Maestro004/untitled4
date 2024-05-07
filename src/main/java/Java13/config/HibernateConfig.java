package Java13.config;

import Java13.entity.Course;
import Java13.entity.Student;
import jakarta.persistence.EntityManagerFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import java.util.Properties;

public class HibernateConfig {
    public static Properties getSessionFactory() {
        Properties properties = new Properties();
        properties.put(Environment.DRIVER, "org.postgresql.Driver");
        properties.put(Environment.URL, "jdbc:postgresql://localhost:5432/postgres");
        properties.put(Environment.USER, "postgres");
        properties.put(Environment.PASS, "1234");
        properties.put(Environment.HBM2DDL_AUTO, "create");
        properties.put(Environment.DIALECT, "org.hibernate.dialect.PostgreSQLDialect");
        properties.put(Environment.SHOW_SQL, "true");
        return properties;

    }

    public static EntityManagerFactory entityManagerFactory() {

        Configuration configuration = new Configuration();
        configuration.addProperties(getSessionFactory());
        configuration.addAnnotatedClass(Course.class);
        configuration.addAnnotatedClass(Student.class);
        System.out.println("Successfully connected to database");
        return configuration.buildSessionFactory().unwrap(EntityManagerFactory.class);


    }
}
