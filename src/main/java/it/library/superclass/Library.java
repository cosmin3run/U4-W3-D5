package it.library.superclass;

import it.library.classes.Loan;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "library")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "category")


public abstract class Library {
    @Id
    @Column(name = "isbn_code", nullable = false)
    private String isbnCode;
    private String title;
    private int year;
    private int pagesNumber;

    @OneToMany(mappedBy = "library")
    private Set<Loan> loans;



    //CONSTRUCTORS
    public Library() {
    }

    public Library(String isbnCode, String title, int year, int pagesNumber) {
        this.isbnCode = isbnCode;
        this.title = title;
        this.year = year;
        this.pagesNumber = pagesNumber;
    }

    public String getIsbnCode() {
        return isbnCode;
    }

    public void setIsbnCode(String isbnCode) {
        this.isbnCode = isbnCode;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getPagesNumber() {
        return pagesNumber;
    }

    public void setPagesNumber(int pagesNumber) {
        this.pagesNumber = pagesNumber;
    }

}


