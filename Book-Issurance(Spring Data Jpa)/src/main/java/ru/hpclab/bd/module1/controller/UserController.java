package ru.hpclab.bd.module1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.hpclab.bd.module1.mapper.UserMapper;
import ru.hpclab.bd.module1.model.User;
import ru.hpclab.bd.module1.service.UserService;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Rest controller for users.
 */
@RestController
public class UserController {

    private final UserService userService;

    /**
     * Builds new UserController.
     * @param userService user service
     */
    @Autowired
    public UserController(final UserService userService) {
        this.userService = userService;
    }

    /**
     * Returns all users.
     * @return list of users
     */
    @GetMapping("/users")
    public List<User> getUsers() {
        return userService.getAllUsers().stream()
                .map(UserMapper::entity2User).collect(Collectors.toList());
    }

    /**
     * Returns user by id.
     * @param id user id
     * @return user
     */
    @GetMapping("/users/{id}")
    public User getUserById(@PathVariable final Long id) {
        return UserMapper.entity2User(userService.getUserById(id));
    }

    /**
     * Deletes user by id.
     * @param id user id
     */
    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable final Long id) {
        userService.deleteUser(id);
    }

    /**
     * Creates or updates user.
     * @param client user
     * @return saved user
     */
    @PostMapping(value = "/users")
    public User saveUser(@RequestBody final User client) {
        return UserMapper.entity2User(userService.saveUser(UserMapper.user2Entity(client)));
    }

    /**
     * Updates user.
     * @param id user id
     * @param user user's new attributes
     * @return updated user
     */
    @PutMapping(value = "/users/{id}")
    public User updateUser(
        @PathVariable(required = false) final Long id,
        @RequestBody final User user
    ) {
        return UserMapper.entity2User(userService.updateUser(id, UserMapper.user2Entity(user)));
    }
}
