package it.library.classes;

import java.time.LocalDate;

public class Loan {
    User user;
    Archive loanedItem;
    LocalDate startLoan;
    LocalDate dueReturnDate;
    LocalDate actualReturnDate;

    public Loan() {
    }

    public Loan(User user, Archive loanedItem, LocalDate startLoan, LocalDate actualReturnDate) {
        this.user = user;
        this.loanedItem = loanedItem;
        this.startLoan = startLoan;
        this.dueReturnDate = startLoan.plusDays(30);
        this.actualReturnDate = actualReturnDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Archive getLoanedItem() {
        return loanedItem;
    }

    public void setLoanedItem(Archive loanedItem) {
        this.loanedItem = loanedItem;
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
                "user=" + user +
                ", loanedItem=" + loanedItem +
                ", startLoan=" + startLoan +
                ", dueReturnDate=" + dueReturnDate +
                ", actualReturnDate=" + actualReturnDate +
                '}';
    }
}
