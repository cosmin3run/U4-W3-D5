package it.library.DAO;

import it.library.classes.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class UserDAO {

    private final EntityManager em;

    public UserDAO(EntityManager em){this.em=em;}

    public void save(User user){
        EntityTransaction transaction = em.getTransaction();

        transaction.begin();

        em.persist(user);

        transaction.commit();

        System.out.println("User " + user.getName() + " added");
    }

    public User findById(String registrationNumber){
        return em.find(User.class, registrationNumber);
    }

    public void deleteByRegistration(String registrationNumber){
        User found = this.findById(registrationNumber);

        if (found != null){
            EntityTransaction transaction = em.getTransaction();

            transaction.begin();

            em.remove(found);

            transaction.commit();

            System.out.println("User" + registrationNumber + " has been deleted");

        }else {
            System.out.println("User " + registrationNumber + " does not exist");
        }
    }
}
