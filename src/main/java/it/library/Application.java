package it.library;

import com.github.javafaker.Faker;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("library");

    public static void main(String[] args) {
        System.out.println("Hello World!");
        Faker faker = new Faker();
        String fake = faker.code().isbn13();
        System.out.println(fake);
        String fake2 = faker.idNumber().valid();
        System.out.println(fake2);

        EntityManager em = emf.createEntityManager();


    }
}
