package app.daos;

import app.HibernateConfig;
import app.entities.Course;
import app.entities.Person;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.TypedQuery;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


public class CourseDAO implements IDAO<Course> {
    private EntityManagerFactory emf = HibernateConfig.getEntityManagerFactory();

    @Override
    public Course getById(Integer id) {
        try (EntityManager em = emf.createEntityManager()) {
            return em.find(Course.class, id);
        }
    }

    @Override
    public Set<Course> getAll() {
        try (EntityManager em = emf.createEntityManager()) {
            TypedQuery<Course> query = em.createQuery("SELECT c FROM Course c", Course.class);
            List<Course> courseList = query.getResultList();
            return courseList.stream().collect(Collectors.toSet());
        }

    }

    @Override
    public void create(Course course) {
        try (EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            em.persist(course);
            em.getTransaction().commit();
        }

    }

    @Override
    public void update(Course course) {
        try (EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            em.merge(course);
            em.getTransaction().commit();

        }

    }

    @Override
    public void delete(Course course) {
        try (EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            em.remove(course);
            em.getTransaction().commit();

        }
    }

    public static void main(String[] args) {

        CourseDAO dao = new CourseDAO();
        dao.create(
                Course.builder()
                        .courseName("How not to be noob")
                        .teacherName("Chad")
                        .semester(2)
                        .classroom(69)
                        .date(LocalDateTime.of(2024, 8, 28, 13, 30, 0))
                        .build()
        );

        dao.update(
                Course.builder()
                        .courseName("How not to be noob")
                        .teacherName("Chad")
                        .semester(2)
                        .classroom(69)
                        .date(LocalDateTime.of(2024, 8, 28, 12, 30, 0))
                        .build()

        );

        /*
        Course c1 = dao.getById(1);
        dao.delete(c1);
         */
    }
}


