package app.daos;

import app.HibernateConfig;
import app.entities.Person;
import app.entities.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.TypedQuery;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class StudentDAO implements IDAO<Student> {

    private EntityManagerFactory emf = HibernateConfig.getEntityManagerFactory();


    @Override
    public Student getById(Integer id) {
        return null;
    }

    @Override
    public Set<Student> getAll() {
        try (EntityManager em = emf.createEntityManager()) {
            TypedQuery<Student> query = em.createQuery("SELECT u from Student u", Student.class);
            List<Student> studentList = query.getResultList();
            return studentList.stream().collect(Collectors.toSet());
        }
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
        try (EntityManager em = emf.createEntityManager()) {

            /*Student found = em.find(Student.class, student.getId());
            if(student.getName() != null ? found.getName().equals(student.getName()) : )*/

            em.getTransaction().begin();
            em.merge(student); //merge found bagefter
            em.getTransaction().commit();
        }
    }

    @Override
    public void delete(Student student) {

    }
}
