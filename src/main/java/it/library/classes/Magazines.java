package it.library.classes;

import it.library.enums.Periodicity;
import it.library.superclass.Library;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
@DiscriminatorValue("magazines")

public class Magazines extends Library {
    @Enumerated(EnumType.STRING)
    private Periodicity periodicity;


    //CONSTRUCTORS


    public Magazines() {
    }

    public Magazines(String isbnCode, String title, int year, int pagesNumber, Periodicity periodicity) {
        super(isbnCode, title, year, pagesNumber);
        this.periodicity = periodicity;
    }

    public Periodicity getPeriodicity() {
        return periodicity;
    }

    public void setPeriodicity(Periodicity periodicity) {
        this.periodicity = periodicity;
    }

    //TOSTRING


    @Override
    public String toString() {
        return "Magazines{" +
                "periodicity=" + periodicity +
                ", isbnCode='" + isbnCode + '\'' +
                ", title='" + title + '\'' +
                ", year=" + year +
                ", pagesNumber=" + pagesNumber +
                "} " + super.toString();
    }
}
