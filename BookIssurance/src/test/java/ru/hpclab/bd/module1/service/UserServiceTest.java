package ru.hpclab.bd.module1.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ru.hpclab.bd.module1.model.User;
import ru.hpclab.bd.module1.repository.UserRepository;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {UserServiceTest.UserServiceTestConfiguration.class})
public final class UserServiceTest {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testCreateAndGet() {
        //create
        User user = new User(UUID.randomUUID(), "name1",
                "2000-12-12", UUID.randomUUID());

        User savedUser = userService.saveUser(user);

        Assertions.assertEquals(user.getFio(), savedUser.getFio());
        Mockito.verify(userRepository, Mockito.times(1)).save(user);

        //getAll
        List<User> userList = userService.getAllUsers();

        Assertions.assertEquals("name1", userList.get(0).getFio());
        Assertions.assertEquals("name2", userList.get(1).getFio());
        Mockito.verify(userRepository, Mockito.times(1)).findAll();

    }

    @Configuration
    static class UserServiceTestConfiguration {

        @Bean
        UserRepository userRepository() {
            UserRepository userRepository = mock(UserRepository.class);
            when(userRepository.save(any())).thenReturn(new User(UUID.randomUUID(),
                    "name1", "2000-12-12", UUID.randomUUID()));
            when(userRepository.findAll())
                    .thenReturn(Arrays.asList(new User(UUID.randomUUID(),
                                    "name1", "2000-12-12", UUID.randomUUID()),
                            new User(UUID.randomUUID(), "name2",
                                    "1990-02-12", UUID.randomUUID())));
            return userRepository;
        }

        @Bean
        UserService userService(final UserRepository userRepository) {
            return new UserService(userRepository);
        }
    }
}
