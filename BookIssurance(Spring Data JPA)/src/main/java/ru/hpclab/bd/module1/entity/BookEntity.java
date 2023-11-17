package ru.hpclab.bd.module1.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Book entity.
 */
@Entity
@Table(name = "book")
public class BookEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "isbn")
    private UUID isbn;

    @Column(name = "name")
    private String name;

    @Column(name = "all_authors")
    private String allAuthors;

    @Column(name = "year")
    private String year;

    @Column(name = "amount_of_pages")
    private int amountOfPages;

    @OneToMany(mappedBy = "bookEntity", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<IssuranceEntity> issurancesWithBook = new ArrayList<>();


    /**
     * Empty contructor.
     */
    public BookEntity() {
    }

    /**
     * Builds new book.
     * @param isbn book unique number
     * @param name book name
     * @param allAuthors book's authors
     * @param year book year of publishing
     * @param amountOfPages book pages
     * @param issurancesWithBook book issurances
     */
    public BookEntity(final UUID isbn,
                      final String name,
                      final String allAuthors,
                      final String year,
                      final int amountOfPages,
                      final List<IssuranceEntity> issurancesWithBook) {
        this.isbn = isbn;
        this.name = name;
        this.allAuthors = allAuthors;
        this.year = year;
        this.amountOfPages = amountOfPages;
        this.issurancesWithBook = issurancesWithBook;
    }

    /**
     * Returns book unique number.
     * @return book ISBN
     */
    public UUID getIsbn() {
        return isbn;
    }

    /**
     * Sets new isbn for book.
     * @param isbn book number
     */
    public void setIsbn(final UUID isbn) {
        this.isbn = isbn;
    }

    /**
     * Returns book name.
     * @return book name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets new name for book.
     * @param name book name
     */
    public void setName(final String name) {
        this.name = name;
    }

    /**
     * Returns book's authors.
     * @return book allAuthors
     */
    public String getAllAuthors() {
        return allAuthors;
    }

    /**
     * Sets new authors for book.
     * @param allAuthors book allAuthors
     */
    public void setAllAuthors(final String allAuthors) {
        this.allAuthors = allAuthors;
    }

    /**
     * Returns book year of publishing.
     * @return book year
     */
    public String getYear() {
        return year;
    }

    /**
     * Sets new year for book.
     * @param year book year
     */
    public void setYear(final String year) {
        this.year = year;
    }

    /**
     * Returns book pages.
     * @return book amountOfPages
     */
    public int getAmountOfPages() {
        return amountOfPages;
    }

    /**
     * Sets new amount of pages for book.
     * @param amountOfPages book amountOfPages
     */
    public void setAmountOfPages(final int amountOfPages) {
        this.amountOfPages = amountOfPages;
    }

    /**
     * Returns book issurances.
     * @return book issurances
     */
    public List<IssuranceEntity> getIssurancesWithBook() {
        return issurancesWithBook;
    }

    /**
     * Sets new list of issurances for book.
     * @param issurancesWithBook book issurances
     */
    public void setIssurancesWithBook(final List<IssuranceEntity> issurancesWithBook) {
        this.issurancesWithBook = issurancesWithBook;
    }

    /**
     * Returns string representation of the book entity.
     */
    @Override
    public String toString() {
        return "BookEntity{"
                + "isbn="
                + isbn
                + ", name='"
                + name
                + '\''
                + ", allAuthors='"
                + allAuthors
                + '\''
                + ", year='"
                + year
                + '\''
                + ", amountOfPages="
                + amountOfPages
                + ", issurancesWithBook="
                + issurancesWithBook
                + '}';
    }
}
