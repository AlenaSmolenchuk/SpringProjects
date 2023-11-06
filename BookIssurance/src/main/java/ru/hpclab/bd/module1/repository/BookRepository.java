package ru.hpclab.bd.module1.repository;

import org.springframework.stereotype.Repository;
import org.springframework.util.ObjectUtils;
import ru.hpclab.bd.module1.controller.exeption.BookException;
import ru.hpclab.bd.module1.controller.exeption.UserException;
import ru.hpclab.bd.module1.model.Book;

import java.util.*;

import static java.lang.String.format;

/**
 * Repository to access Books.
 */
@Repository
public class BookRepository {
    /**
     * Book exception not found message.
     */
    public static final String BOOK_NOT_FOUND_MSG = "Book with ISBN %s not found";

    /**
     * Book already exists message.
     */
    public static final String BOOK_EXISTS_MSG = "User with ISBN %s is already exists";

    private final Map<UUID, Book> books = new HashMap<>();

    /**
     * Fetches all books.
     * @return list of books
     */
    public List<Book> findAll() {
        return new ArrayList<>(books.values());
    }

    /**
     * Fetches book by isbn.
     * @param isbn book number
     * @return book
     */
    public Book findByIsbn(final UUID isbn) {
        final var book = books.get(isbn);
        if (book == null) {
            throw new BookException(format(BOOK_NOT_FOUND_MSG, isbn));
        }
        return book;
    }

    /**
     * Deletes book by isbn.
     * @param isbn book number
     */
    public void delete(final UUID isbn) {
        final var removedBook = books.remove(isbn);
        if (removedBook == null) {
            throw new UserException(format(BOOK_NOT_FOUND_MSG, isbn));
        }
    }

    /**
     * Creates or updates book.
     * @param book book to save
     * @return saved book
     */
    public Book save(final Book book) {
        if (ObjectUtils.isEmpty(book.getIsbn())) {
            book.setIsbn(UUID.randomUUID());
        }

        final var bookData = books.get(book.getIsbn());
        if (bookData != null) {
            throw new BookException(format(BOOK_EXISTS_MSG, book.getIsbn()));
        }

        books.put(book.getIsbn(), book);

        return book;
    }

    /**
     * Updates book.
     * @param book book to update
     * @return updated book
     */
    public Book put(final Book book) {
        final var bookData = books.get(book.getIsbn());
        if (bookData == null) {
            throw new UserException(format(BOOK_NOT_FOUND_MSG, book.getIsbn()));
        }

        final var removed = books.remove(book.getIsbn());
        if (removed != null) {
            books.put(book.getIsbn(), book);
        } else {
            throw new UserException(format(BOOK_NOT_FOUND_MSG, book.getIsbn()));
        }

        return book;
    }

    /**
     * Deletes all books.
     */
    public void clear() {
        books.clear();
    }
}
