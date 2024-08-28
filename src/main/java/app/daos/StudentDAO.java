package app.daos;

import app.HibernateConfig;
import app.entities.Person;
import app.entities.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

import java.util.Set;

public class StudentDAO implements IDAO<Student>{

    private EntityManagerFactory emf = HibernateConfig.getEntityManagerFactory();



    @Override
    public Student getById(Integer id) {
        return null;
    }

    @Override
    public Set<Student> getAll() {
        return null;
    }

    @Override
    public void create(Student student) {
        try (EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            em.persist(student);
            em.getTransaction().commit();
        }
    }

    @Override
    public void update(Student student) {

    }

    @Override
    public void delete(Student student) {

    }
}
