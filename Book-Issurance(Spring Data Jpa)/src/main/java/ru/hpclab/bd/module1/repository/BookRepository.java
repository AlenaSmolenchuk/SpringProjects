package ru.hpclab.bd.module1.repository;

import org.springframework.data.repository.CrudRepository;
import ru.hpclab.bd.module1.entity.BookEntity;

import java.util.*;

/**
 * Repository to access Books.
 */
public interface BookRepository extends CrudRepository<BookEntity, Long> {

    /**
     * Fetches book by isbn.
     * @param isbn book number
     * @return book
     */
    Optional<BookEntity> findByIsbn(Long isbn);

    /**
     * Deletes book by isbn.
     * @param isbn book number
     */
    void deleteByIsbn(Long isbn);

    /**
     * Checks if a book with the given isbn exists in the repository.
     *
     * @param isbn The number to check for existence.
     * @return {@code true} if a book with isbn exists, {@code false} otherwise.
     */
    boolean existsByIsbn(Long isbn);
}
