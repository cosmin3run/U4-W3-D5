package it.library;

import com.github.javafaker.Faker;

public class Application {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        Faker faker = new Faker();
        String fake = faker.code().isbn13();
        System.out.println(fake);
        String fake2 = faker.idNumber().valid();
        System.out.println(fake2);
    }
}
