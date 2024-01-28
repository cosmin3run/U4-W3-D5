package it.library.classes;

import it.library.superclass.Library;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Table(name = "loan")

public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "loan_id", nullable = false)
    private int id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "loaned_element_id")
    private Library library;

    @Column(nullable = false)
    private LocalDate startLoan;
    private LocalDate dueReturnDate;
    private LocalDate actualReturnDate;

    public Loan() {
    }

    public Loan(User user, Library loanedItem, LocalDate startLoan, LocalDate actualReturnDate) {

        this.user = user;
        this.library = loanedItem;
        this.startLoan = startLoan;
        this.dueReturnDate = startLoan.plusDays(30);
        this.actualReturnDate = actualReturnDate;
    }

    //GETTERS AND SETTERS

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Library getLibrary() {
        return library;
    }

    public void setLibrary(Library library) {
        this.library = library;
    }

    public LocalDate getStartLoan() {
        return startLoan;
    }

    public void setStartLoan(LocalDate startLoan) {
        this.startLoan = startLoan;
    }

    public LocalDate getDueReturnDate() {
        return dueReturnDate;
    }

    public void setDueReturnDate(LocalDate dueReturnDate) {
        this.dueReturnDate = dueReturnDate;
    }

    public LocalDate getActualReturnDate() {
        return actualReturnDate;
    }

    public void setActualReturnDate(LocalDate actualReturnDate) {
        this.actualReturnDate = actualReturnDate;
    }


    //Tostring


    @Override
    public String toString() {
        return "Loan{" +
                "id=" + id +
                ", user=" + user +
                ", loanedItem=" + library +
                ", startLoan=" + startLoan +
                ", dueReturnDate=" + dueReturnDate +
                ", actualReturnDate=" + actualReturnDate +
                '}';
    }
}
