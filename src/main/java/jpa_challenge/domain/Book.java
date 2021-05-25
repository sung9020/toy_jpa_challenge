package jpa_challenge.domain;

import javax.persistence.Entity;

/*
 *
 * @author snow
 * @since 2021/05/22
 */
@Entity
public class Book extends Item {
    private String author;
    private String isbn;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
}
