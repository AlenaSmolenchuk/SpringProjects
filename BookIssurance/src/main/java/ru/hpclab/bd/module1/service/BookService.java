package ru.hpclab.bd.module1.service;

import org.springframework.stereotype.Service;
import ru.hpclab.bd.module1.model.Book;
import ru.hpclab.bd.module1.repository.BookRepository;

import java.util.List;
import java.util.UUID;

/**
 * Service to control books.
 */
public class BookService {
    private final BookRepository bookRepository;

    /**
     * Builds new BookService.
     * @param bookRepository book repository
     */
    public BookService(final BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    /**
     * Fetches all books.
     * @return list of books
     */
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    /**
     * Fetches book by isbn.
     * @param isbn book number
     * @return book
     */
    public Book getBookByISBN(final String isbn) {
        return bookRepository.findByIsbn(UUID.fromString(isbn));
    }

    /**
     * Creates or updates book.
     * @param book book to save
     * @return saved book
     */
    public Book saveBook(final Book book) {
        return bookRepository.save(book);
    }

    /**
     * Updates book.
     * @param isbn book number to update
     * @param book book with new attributes
     * @return updated book
     */
    public Book updateBook(final String isbn, final Book book) {
        book.setIsbn(UUID.fromString(isbn));
        return bookRepository.put(book);
    }

    /**
     * Deletes book by isbn.
     * @param isbn book number
     */
    public void deleteBook(final String isbn) {
        bookRepository.delete(UUID.fromString(isbn));
    }

    /**
     * Checks exist a book with a given ISBN or not.
     * @param isbn book number to check
     * @return true if a book with given ISBN exists; otherwise, false
     */
    public boolean existBook(final UUID isbn) {
        List<Book> books = bookRepository.findAll();

        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                return true;
            }
        }
        return false;
    }
}
