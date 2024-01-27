package it.library.classes;

import it.library.superclass.Library;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("books")

public class Books extends Library {
    @Column
    private String author;
    @Column
    private String genre;

    //CONSTRUCTORS

    public Books() {
    }

    public Books(String isbnCode, String title, int year, int pagesNumber, String author, String genre) {
        super(isbnCode, title, year, pagesNumber);
        this.author = author;
        this.genre = genre;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    //TOSTRING


    @Override
    public String toString() {
        return "Books{" +
                "author='" + author + '\'' +
                ", genre='" + genre + '\'' +
                ", isbnCode='" + isbnCode + '\'' +
                ", title='" + title + '\'' +
                ", year=" + year +
                ", pagesNumber=" + pagesNumber +
                "} ";
    }
}
