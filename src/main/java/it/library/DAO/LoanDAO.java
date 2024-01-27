package it.library.DAO;

import it.library.classes.Loan;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class LoanDAO {
    private final EntityManager em;

    public LoanDAO(EntityManager em){this.em = em;}

    public void save(Loan loan){
        EntityTransaction transaction = em.getTransaction();

        transaction.begin();

        em.persist(loan);

        transaction.commit();

        System.out.println("Loan " + loan.getLibrary().getTitle() + " added");
    }

    public Loan findById(int id){
        return em.find(Loan.class, id);
    }

    public void deleteById(int id) {

        Loan found = this.findById(id);

        if (found != null){
            EntityTransaction transaction = em.getTransaction();

            transaction.begin();

            em.remove(found);

            transaction.commit();

            System.out.println("Loan " + found.getLibrary().getTitle() + " deleted");
        } else {
            System.out.println("Loan " + id + " didn't found");
        }
    }

}
