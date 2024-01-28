package it.library.DAO;

import it.library.superclass.Library;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

public class LibraryDAO {
    private final EntityManager em;

    public LibraryDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Library library) {
        EntityTransaction transaction = em.getTransaction();

        transaction.begin();

        em.persist(library);

        transaction.commit();

        System.out.println("Element " + library.getTitle() + " added");
    }

    public Library findByIsbnCode(String isbnCode) {
        return em.find(Library.class, isbnCode);
    }

    public void deleteByIsbn(String isbnCode) {
        Library found = this.findByIsbnCode(isbnCode);
        if (found != null) {
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

    public List<Library> searchItemByYear(int year) {
        TypedQuery<Library> query = em.createQuery("SELECT i FROM Library i WHERE i.year =:year", Library.class);
        query.setParameter("year", year);
        List<Library> searchedItem = query.getResultList();
        if (searchedItem.isEmpty()) {
            System.out.println("There are no Items with this pubblication year: " + year);
        } else {
            System.out.println("Items found: ");
            for (Library item : searchedItem) {
                System.out.println(item);
            }
        }
        return searchedItem;
    }

    public List<Library> searchItemByAuthor(String author) {
        TypedQuery<Library> query = em.createQuery("SELECT i FROM Books i WHERE i.author=:author", Library.class);
        query.setParameter("author", author);
        List<Library> searchedItem = query.getResultList();
        if (searchedItem.isEmpty()) {
            System.out.println("There are no items with the author you're searching for");
        } else {
            System.out.println("Items found: ");
            for (Library item : searchedItem) {
                System.out.println(item);
            }
        }
        return searchedItem;
    }

    public List<Library> searchItemByTitle(String title) {
        TypedQuery<Library> query = em.createQuery("SELECT t FROM Library t WHERE LOWER(t.title) LIKE LOWER(:title)", Library.class);
        query.setParameter("title", title);
        List<Library> searchedItem = query.getResultList();
        if (searchedItem.isEmpty()) {
            System.out.println("There are no items with the title you're searching for");
        } else {
            System.out.println("Items found: ");
            for (Library item : searchedItem) {
                System.out.println(item);
            }
        }
        return searchedItem;
    }


}
