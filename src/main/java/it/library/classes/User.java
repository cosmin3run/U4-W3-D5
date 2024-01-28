package it.library.classes;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "user")
public class User {
    @Id
    @Column(name = "registration_number", nullable = false)
    String registrationNumber;
    @Column(nullable = false)
    String name;
    @Column(nullable = false)
    String surname;
    Date dateOfBirth;

    @OneToMany(mappedBy = "user")
    private Set<Loan> loans;

    //CONSTRUCTORS


    public User() {
    }

    public User(String registrationNumber, String name, String surname, Date dateOfBirth) {
        this.registrationNumber = registrationNumber;
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
    }

    //GETTER AND SETTERS

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Set<Loan> getLoans() {
        return loans;
    }

    public void setLoans(Set<Loan> loans) {
        this.loans = loans;
    }

    //TOSTRING

    @Override
    public String toString() {
        return "User{" +
                "registrationNumber='" + registrationNumber + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", loans=" + loans +
                '}';
    }
}
