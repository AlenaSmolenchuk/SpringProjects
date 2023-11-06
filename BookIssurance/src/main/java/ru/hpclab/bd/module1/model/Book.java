package ru.hpclab.bd.module1.model;

import org.springframework.lang.NonNull;

import java.time.Year;
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
    private Year year;

    @NonNull
    private int amountOfPages;

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
     */
    public Book(@NonNull final UUID isbn,
                @NonNull final String name,
                @NonNull final String allAuthors,
                final Year year,
                final int amountOfPages) {
        this.isbn = isbn;
        this.name = name;
        this.allAuthors = allAuthors;
        this.year = year;
        this.amountOfPages = amountOfPages;
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
    public Year getYear() {
        return year;
    }

    /**
     * Sets new year for book.
     * @param year book year
     */
    public void setYear(final Year year) {
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
                + ", year="
                + year
                + ", amountOfPages="
                + amountOfPages
                + '}';
    }
}
