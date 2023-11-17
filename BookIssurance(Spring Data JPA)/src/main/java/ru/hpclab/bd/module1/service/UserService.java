package ru.hpclab.bd.module1.service;

import org.springframework.stereotype.Service;
import ru.hpclab.bd.module1.controller.exeption.UserException;
import ru.hpclab.bd.module1.entity.UserEntity;
import ru.hpclab.bd.module1.repository.UserRepository;

import java.util.List;
import java.util.UUID;

import static java.lang.String.format;

/**
 * Service to control users.
 */
@Service
public class UserService {

    private final UserRepository userRepository;

    /**
     * A constant string representing the error message when a user with a specific ID is not found.
     *
     * @see java.lang.String#format(String, Object...)
     *
     * @param %s The placeholder for the ID in the error message.
     * @return The formatted error message indicating that a user with the specified ID was not found.
     */
    public static final String USER_NOT_FOUND_MSG = "User with ID %s not found";

    /**
     * Builds new UserService.
     * @param userRepository user repository
     */
    public UserService(final UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Fetches all user entities.
     * @return list of user entities
     */
    public List<UserEntity> getAllUsers() {
        return (List<UserEntity>) userRepository.findAll();
    }

    /**
     * Fetches user entity by id.
     * @param idUser user id
     * @return userEntity
     */
    public UserEntity getUserById(final UUID idUser) {
        return userRepository.findById(idUser)
                .orElseThrow(() -> new UserException(format(USER_NOT_FOUND_MSG, idUser)));
    }

    /**
     * Creates or updates user entity.
     * @param userEntity user entity to save
     * @return saved user entity
     */
    public UserEntity saveUser(final UserEntity userEntity) {
        userEntity.setIdUser(UUID.randomUUID());
        return userRepository.save(userEntity);
    }

    /**
     * Updates user entity.
     * @param idUser user entity id to update
     * @param userEntity user entity with new attributes
     * @return updated user entity
     */
    public UserEntity updateUser(final UUID idUser, final UserEntity userEntity) {
        userEntity.setIdUser(idUser);
        return userRepository.save(userEntity);
    }

    /**
     * Deletes user entity by id.
     * @param idUser user entity id
     */
    public void deleteUser(final UUID idUser) {
        userRepository.deleteById(idUser);
    }

    /**
     * Checks exist a user entity with a given libraryCardNumber or not.
     * @param libraryCardNumber user entity card in library to check
     * @return true if a user entity with given libraryCardNumber exists; otherwise, false
     */
    public boolean existsUser(final UUID libraryCardNumber) {
        return userRepository.existsByLibraryCardNumber(libraryCardNumber);
    }
}
