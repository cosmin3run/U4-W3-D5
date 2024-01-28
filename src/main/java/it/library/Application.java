package it.library;

import com.github.javafaker.Book;
import com.github.javafaker.Faker;
import it.library.DAO.LibraryDAO;
import it.library.DAO.LoanDAO;
import it.library.DAO.UserDAO;
import it.library.classes.Books;
import it.library.classes.Loan;
import it.library.classes.Magazines;
import it.library.classes.User;
import it.library.enums.Periodicity;
import it.library.superclass.Library;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.util.Random;

public class Application {

    static Periodicity getRandomPeriodicity() {
        Periodicity[] per = Periodicity.values();
        int randNum = new Random().nextInt(per.length);
        return per[randNum];
    }
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("library");

    public static void main(String[] args) {
        System.out.println("Library");

        EntityManager em = emf.createEntityManager();
        Faker faker = new Faker();

        LoanDAO loanDAO = new LoanDAO(em);
        UserDAO userDAO = new UserDAO(em);
        LibraryDAO libraryDAO = new LibraryDAO(em);


        System.out.println("----- Save library items -----");

        //SAVING BOOKS
//        for (int i = 0; i < 5; i++){
//            Books books = new Books(faker.code().isbn13(), faker.book().title(), faker.number().numberBetween(1900, 2024), faker.number().numberBetween(20, 1000), faker.book().author(), faker.book().genre() );
//            libraryDAO.save(books);
//        }


        //SAVING MAGAZINES
//        for (int i = 0; i < 5; i++){
//            Magazines books = new Magazines(faker.code().isbn13(), faker.book().title(), faker.number().numberBetween(1900, 2024), faker.number().numberBetween(20, 300), getRandomPeriodicity());
//            libraryDAO.save(books);
//        }

        System.out.println("----- Deleting an item bu ISBN -----");
        libraryDAO.deleteByIsbn("9791873214724");

        System.out.println("----- Search by ISBN -----");
        System.out.println(libraryDAO.findByIsbnCode("9790960590291"));

        System.out.println("----- Search by publication year ------");
        libraryDAO.searchItemByYear(2002);

        System.out.println("----- Search by author -----");
        libraryDAO.searchItemByAuthor("Errol Langosh");

        System.out.println("----- Search by title or part of it -----");
        libraryDAO.searchItemByTitle("The Last Temptation");

        System.out.println("----- Search all loaned books to a user");
        loanDAO.searchLoanByRegistrationNumber("543881688150314");




        System.out.println("----- Register users -----");

//        for (int i = 0; i < 5; i++){
//            User users = new User(faker.code().imei(), faker.name().firstName(), faker.name().lastName(), faker.date().birthday());
//            userDAO.save(users);
//        }

        System.out.println("----- Registering loans -----");

        User userLoan1 = userDAO.findById("013662061403251");
        User userLoan2 = userDAO.findById("868165334348234");
        Library bookToLoan1 = libraryDAO.findByIsbnCode("9780071058353");
        Library bookToLoan2 = libraryDAO.findByIsbnCode("9790684880135");
        Loan loan1 = new Loan(userLoan1, bookToLoan1, LocalDate.of(2023,10,12), LocalDate.of(2023,12,15));
        Loan loan2 = new Loan(userLoan1, bookToLoan2, LocalDate.of(2023,11,25), LocalDate.of(2024, 1,26));
//        loanDAO.save(loan1);
//        loanDAO.save(loan2);




    }
}
