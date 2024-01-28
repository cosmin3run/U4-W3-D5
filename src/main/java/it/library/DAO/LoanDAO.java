package it.library.DAO;

import it.library.classes.Loan;
import it.library.classes.User;
import it.library.superclass.Library;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

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

    public List<Library> searchLoanByRegistrationNumber(String registrationNumber) {
        TypedQuery<Library> query = em.createQuery("SELECT i FROM Library i JOIN i.loans l WHERE l.user.registrationNumber =:registrationNumber AND l.actualReturnDate IS NULL", Library.class);
        query.setParameter("registrationNumber", registrationNumber);
        List<Library> searchedItem = query.getResultList();
        if (searchedItem.isEmpty()) {
            System.out.println("There are no items loaned to this user");
        } else {
            System.out.println("Items loaned to the user: ");
            for (Library item : searchedItem) {
                System.out.println(item);
            }
        }
        return searchedItem;
    }

    public List<Loan> searchExpiredLoans() {
        TypedQuery<Loan> query = em.createQuery("SELECT l FROM Loan l WHERE l.dueReturnDate<NOW() AND l.actualReturnDate IS NULL", Loan.class);

        List<Loan> searchedItem = query.getResultList();
        if (searchedItem.isEmpty()) {
            System.out.println("There are no expired loans");
        } else {
            System.out.println("Expired loans: ");
            for (Loan item : searchedItem) {
                System.out.println(item);
            }
        }
        return searchedItem;
    }

}
