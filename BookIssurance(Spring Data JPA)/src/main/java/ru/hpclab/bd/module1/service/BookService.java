package ru.hpclab.bd.module1.service;

import org.springframework.stereotype.Service;
import ru.hpclab.bd.module1.controller.exeption.BookException;
import ru.hpclab.bd.module1.entity.BookEntity;
import ru.hpclab.bd.module1.repository.BookRepository;

import java.util.List;
import java.util.UUID;

import static java.lang.String.format;

/**
 * Service to control books.
 */
@Service
public class BookService {
    private final BookRepository bookRepository;

    /**
     * A constant string representing the error message when a book with a specific ISBN is not found.
     *
     * @see java.lang.String#format(String, Object...)
     *
     * @param %s The placeholder for the ISBN in the error message.
     * @return The formatted error message indicating that a book with the specified ISBN was not found.
     */
    public static final String BOOK_NOT_FOUND_MSG = "Book with ISBN %s not found";

    /**
     * Builds new BookService.
     * @param bookRepository book repository
     */
    public BookService(final BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    /**
     * Fetches all books entity.
     *
     * @return list of books entity
     */
    public List<BookEntity> getAllBooks() {
        return (List<BookEntity>) bookRepository.findAll();
    }

    /**
     * Fetches book entity by isbn.
     * @param isbn book entity number
     * @return book entity
     */
    public BookEntity getBookByIsbn(final UUID isbn) {
        return bookRepository.findByIsbn(isbn)
                .orElseThrow(() -> new BookException(format(BOOK_NOT_FOUND_MSG, isbn)));
    }

    /**
     * Creates or updates book entity.
     * @param bookEntity book entity to save
     * @return saved book entity
     */
    public BookEntity saveBook(final BookEntity bookEntity) {
        bookEntity.setIsbn(UUID.randomUUID());
        return bookRepository.save(bookEntity);
    }

    /**
     * Updates book entity.
     * @param isbn book entity number to update
     * @param bookEntity book entity with new attributes
     * @return updated book entity
     */
    public BookEntity updateBook(final UUID isbn, final BookEntity bookEntity) {
        bookEntity.setIsbn(isbn);
        return bookRepository.save(bookEntity);
    }

    /**
     * Deletes book entity by isbn.
     * @param isbn book entity number
     */
    public void deleteBook(final UUID isbn) {
        bookRepository.deleteByIsbn(isbn);
    }

    /**
     * Checks exist a book entity with a given ISBN or not.
     * @param isbn book entity number to check
     * @return true if a book entity with given ISBN exists; otherwise, false
     */
    public boolean existBook(final UUID isbn) {
        return  bookRepository.existsByIsbn(isbn);
    }
}
