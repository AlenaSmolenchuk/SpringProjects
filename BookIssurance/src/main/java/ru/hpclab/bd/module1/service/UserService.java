package ru.hpclab.bd.module1.service;

import org.springframework.stereotype.Service;
import ru.hpclab.bd.module1.model.User;
import ru.hpclab.bd.module1.repository.UserRepository;

import java.util.List;
import java.util.UUID;

/**
 * Service to control users.
 */
public class UserService {

    private final UserRepository userRepository;

    /**
     * Builds new UserService.
     * @param userRepository user repository
     */
    public UserService(final UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Fetches all users.
     * @return list of users
     */
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    /**
     * Fetches user by id.
     * @param idUser user id
     * @return user
     */
    public User getUserById(final String idUser) {
        return userRepository.findById(UUID.fromString(idUser));
    }

    /**
     * Creates or updates user.
     * @param user user to save
     * @return saved user
     */
    public User saveUser(final User user) {
        return userRepository.save(user);
    }

    /**
     * Updates user.
     * @param idUser user id to update
     * @param user user with new attributes
     * @return updated user
     */
    public User updateUser(final String idUser, final User user) {
        user.setIdUser(UUID.fromString(idUser));
        return userRepository.put(user);
    }

    /**
     * Deletes user by id.
     * @param idUser user id
     */
    public void deleteUser(final String idUser) {
        userRepository.delete(UUID.fromString(idUser));
    }

    /**
     * Checks exist a user with a given libraryCardNumber or not.
     * @param libraryCardNumber user card in library to check
     * @return true if a user with given libraryCardNumber exists; otherwise, false
     */
    public boolean existUser(final UUID libraryCardNumber) {
        List<User> users = userRepository.findAll();

        for (User user : users) {
            if (user.getLibraryCardNumber().equals(libraryCardNumber)) {
                return true;
            }
        }
        return false;
    }
}
