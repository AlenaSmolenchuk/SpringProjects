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
import ru.hpclab.bd.module1.entity.UserEntity;
import ru.hpclab.bd.module1.repository.UserRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {UserServiceTest.UserServiceTestConfiguration.class})
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    private static final Long SIMPLE_NUMBER = 4L;

    @Test
    public void testCreateAndGet() {
        //create
        UserEntity userEntity = new UserEntity(SIMPLE_NUMBER,
                "name",
                "29-07-2004",
                SIMPLE_NUMBER,
                new ArrayList<>());

        UserEntity savedUser = userService.saveUser(userEntity);

        Assertions.assertEquals(userEntity.getFio(), savedUser.getFio());
        Mockito.verify(userRepository, Mockito.times(1)).save(userEntity);

        //getAll
        List<UserEntity> userList = userService.getAllUsers();

        Assertions.assertEquals("name1", userList.get(0).getFio());
        Assertions.assertEquals("name2", userList.get(1).getFio());
        Mockito.verify(userRepository, Mockito.times(1)).findAll();

    }

    @Configuration
    static class UserServiceTestConfiguration {

        @Bean
        UserRepository userRepository() {
            UserRepository userRepository = mock(UserRepository.class);
            when(userRepository.save(any())).thenReturn(new UserEntity(SIMPLE_NUMBER,
                    "name",
                    "29-07-2004",
                    SIMPLE_NUMBER,
                    new ArrayList<>()));
            when(userRepository.findAll())
                    .thenReturn(Arrays.asList(new UserEntity(SIMPLE_NUMBER,
                            "name1",
                            "29-07-2004",
                                    SIMPLE_NUMBER,
                            new ArrayList<>()),
                            new UserEntity(SIMPLE_NUMBER,
                                    "name2",
                                    "29-07-2004",
                                    SIMPLE_NUMBER,
                                    new ArrayList<>())));
            return userRepository;
        }

        @Bean
        UserService UserService(final UserRepository userRepository) {
            return new UserService(userRepository);
        }
    }
}
