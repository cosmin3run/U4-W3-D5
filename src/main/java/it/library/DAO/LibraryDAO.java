package it.library.DAO;

import it.library.superclass.Library;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class LibraryDAO {
    private final EntityManager em;
    public LibraryDAO(EntityManager em) {this.em = em;}

    public void save(Library library){
        EntityTransaction transaction = em.getTransaction();

        transaction.begin();

        em.persist(library);

        transaction.commit();

        System.out.println("Element " + library.getTitle() + " added");
    }

    public Library findByIsbnCode(String isbnCode){
        return em.find(Library.class, isbnCode);
    }

    public void deleteByIsbn(String isbnCode){
        Library found = this.findByIsbnCode(isbnCode);
        if(found != null){
            EntityTransaction transaction = em.getTransaction();

            transaction.begin();

            em.remove(found);

            transaction.commit();

            System.out.println("Element " + found.getTitle() + " deleted");
        } else {
            System.out.println("Element with ISBN '"
            + isbnCode + "' not found");
        }
    }
}
