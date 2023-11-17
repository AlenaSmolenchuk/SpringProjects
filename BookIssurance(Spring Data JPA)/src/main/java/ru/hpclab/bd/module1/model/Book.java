package ru.hpclab.bd.module1.model;

import org.springframework.lang.NonNull;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Book model.
 */
public class Book {

    @NonNull
    private UUID isbn;

    @NonNull
    private String name;

    @NonNull
    private String allAuthors;

    @NonNull
    private String year;

    @NonNull
    private int amountOfPages;

    @NonNull
    private List<Issurance> issurancesWithBook = new ArrayList<>();

    /**
     * Empty contructor.
     */
    public Book() {
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
    public Book(@NonNull final UUID isbn,
                @NonNull final String name,
                @NonNull final String allAuthors,
                final String year,
                final int amountOfPages,
                final List<Issurance> issurancesWithBook) {
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
    @NonNull
    public UUID getIsbn() {
        return isbn;
    }

    /**
     * Sets new isbn for book.
     * @param isbn book number
     */
    public void setIsbn(@NonNull final UUID isbn) {
        this.isbn = isbn;
    }

    /**
     * Returns book name.
     * @return book name
     */
    @NonNull
    public String getName() {
        return name;
    }

    /**
     * Sets new name for book.
     * @param name book name
     */
    public void setName(@NonNull final String name) {
        this.name = name;
    }

    /**
     * Returns book's authors.
     * @return book allAuthors
     */
    @NonNull
    public String getAllAuthors() {
        return allAuthors;
    }

    /**
     * Sets new authors for book.
     * @param allAuthors book allAuthors
     */
    public void setAllAuthors(@NonNull final String allAuthors) {
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
    @NonNull
    public List<Issurance> getIssurancesWithBook() {
        return issurancesWithBook;
    }

    /**
     * Sets new list of issurances for book.
     * @param issurancesWithBook book issurances
     */
    public void setIssurancesWithBook(@NonNull final List<Issurance> issurancesWithBook) {
        this.issurancesWithBook = issurancesWithBook;
    }

    /**
     * Returns string representation of the book.
     */
    @Override
    public String toString() {
        return "Book{"
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
