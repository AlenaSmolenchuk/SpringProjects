package ru.hpclab.bd.module1.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.hpclab.bd.module1.entity.BookEntity;

import java.util.*;

/**
 * Repository to access Books.
 */
@Repository
public interface BookRepository extends CrudRepository<BookEntity, UUID> {

    /**
     * Fetches book by isbn.
     * @param isbn book number
     * @return book
     */
    Optional<BookEntity> findByIsbn(UUID isbn);

    /**
     * Deletes book by isbn.
     * @param isbn book number
     */
    void deleteByIsbn(UUID isbn);

    /**
     * Checks if a book with the given isbn exists in the repository.
     *
     * @param isbn The number to check for existence.
     * @return {@code true} if a book with isbn exists, {@code false} otherwise.
     */
    boolean existsByIsbn(UUID isbn);
}
