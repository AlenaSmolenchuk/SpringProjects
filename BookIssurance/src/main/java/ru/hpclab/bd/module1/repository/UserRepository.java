package ru.hpclab.bd.module1.repository;

import org.springframework.stereotype.Repository;
import org.springframework.util.ObjectUtils;
import ru.hpclab.bd.module1.controller.exeption.UserException;
import ru.hpclab.bd.module1.model.User;

import java.util.*;

import static java.lang.String.format;

/**
 * Repository to access Users.
 */
@Repository
public class UserRepository {
    /**
     * User exception not found message.
     */
    public static final String USER_NOT_FOUND_MSG = "User with ID %s not found";

    /**
     * User already exists message.
     */
    public static final String USER_EXISTS_MSG = "User with ID %s is already exists";

    private final Map<UUID, User> users = new HashMap<>();

    /**
     * Fetches all users.
     * @return list of users
     */
    public List<User> findAll() {
        return new ArrayList<>(users.values());
    }

    /**
     * Fetches user by id.
     * @param idUser user id
     * @return user
     */
    public User findById(final UUID idUser) {
        final var user = users.get(idUser);
        if (user == null) {
            throw new UserException(format(USER_NOT_FOUND_MSG, idUser));
        }
        return user;
    }

    /**
     * Deletes user by id.
     * @param idUser user id
     */
    public void delete(final UUID idUser) {
        final var removed = users.remove(idUser);
        if (removed == null) {
            throw new UserException(format(USER_NOT_FOUND_MSG, idUser));
        }
    }

    /**
     * Creates or updates user.
     * @param user user to save
     * @return saved user
     */
    public User save(final User user) {
        if (ObjectUtils.isEmpty(user.getIdUser())) {
            user.setIdUser(UUID.randomUUID());
        }

        final var userData = users.get(user.getIdUser());
        if (userData != null) {
            throw new UserException(format(USER_EXISTS_MSG, user.getIdUser()));
        }

        users.put(user.getIdUser(), user);

        return user;
    }

    /**
     * Updates user.
     * @param user user to update
     * @return updated user
     */
    public User put(final User user) {
        final var userData = users.get(user.getIdUser());
        if (userData == null) {
            throw new UserException(format(USER_NOT_FOUND_MSG, user.getIdUser()));
        }

        final var removed = users.remove(user.getIdUser());
        if (removed != null) {
            users.put(user.getIdUser(), user);
        } else {
            throw new UserException(format(USER_NOT_FOUND_MSG, user.getIdUser()));
        }

        return user;
    }

    /**
     * Deletes all users.
     */
    public void clear() {
        users.clear();
    }
}
