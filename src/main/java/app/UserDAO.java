package app;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.TypedQuery;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class UserDAO  implements IDAO<User> {

    private EntityManagerFactory emf = HibernateConfig.getEntityManagerFactory();


    @Override
    public User getUserId(Integer id) {
        return null;
    }

    @Override
    public Set<User> getAll() {
        try(EntityManager em = emf.createEntityManager()){
            TypedQuery<User> query = em.createQuery("select u FROM User u", User.class);
            List<User> userList = query.getResultList();
            return userList.stream().collect(Collectors.toSet());
        }
    }

    @Override
    public void create(User user) {
        try
            (EntityManager em = emf.createEntityManager()){
            em.getTransaction().begin();
            em.persist(user);
            em.getTransaction().commit();

        }
    }

    @Override
    public void update(User user) {
        try(EntityManager em = emf.createEntityManager()){
            em.getTransaction().begin();
            em.merge(user);
        }

    }

    @Override
    public void delete(User user) {

    }

    public static void main(String[] args){
        UserDAO userDAO = new UserDAO();
        userDAO.create(
                User
                        .builder()
                        .name("user1")
                        .password("mom")
                        .email("hghgh@hfhf.dk")
                        .build()
        );

        userDAO.getAll().forEach(System.out::println);

    ;}

}
