package ru.hpclab.bd.module1.repository;

import org.springframework.data.repository.CrudRepository;
import ru.hpclab.bd.module1.entity.UserEntity;

import java.util.*;

/**
 * Repository to access Users.
 */
public interface UserRepository extends CrudRepository<UserEntity, Long> {

    /**
     * Fetches user by id.
     *
     * @param id user id
     * @return user
     */
    Optional<UserEntity> findById(Long id);

    /**
     * Deletes user by id.
     * @param id user id
     */
    void deleteById(Long id);

    /**
     * Checks if a user with the given library card number exists in the repository.
     *
     * @param libraryCardNumber The library card number to check for existence.
     * @return {@code true} if a user with the specified library card number exists, {@code false} otherwise.
     */
    boolean existsByLibraryCardNumber(Long libraryCardNumber);
}
