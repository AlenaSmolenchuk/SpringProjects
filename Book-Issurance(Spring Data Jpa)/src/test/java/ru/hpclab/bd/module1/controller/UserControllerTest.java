package ru.hpclab.bd.module1.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.containers.wait.strategy.Wait;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import ru.hpclab.bd.module1.Module1Application;
import ru.hpclab.bd.module1.entity.BookEntity;
import ru.hpclab.bd.module1.entity.IssuranceEntity;
import ru.hpclab.bd.module1.entity.UserEntity;
import ru.hpclab.bd.module1.mapper.UserMapper;
import ru.hpclab.bd.module1.repository.UserRepository;

import java.util.Arrays;
import java.util.UUID;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = Module1Application.class)
@AutoConfigureMockMvc
@TestPropertySource("classpath:application-test.properties")
@Testcontainers
public class UserControllerTest {
    private ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    private MockMvc mvc;

    @Autowired
    private UserRepository userRepository;

    @Container
    private static final PostgreSQLContainer<?> POSTGRES_CONTAINER
            = (PostgreSQLContainer) new PostgreSQLContainer("postgres:15.2-alpine")
            .withDatabaseName("module1")
            .withUsername("postgres")
            .withPassword("minis123")
            .waitingFor(Wait.forListeningPort());

    @DynamicPropertySource
    static void dataSourceProperties(final DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", POSTGRES_CONTAINER::getJdbcUrl);
        registry.add("spring.datasource.username", POSTGRES_CONTAINER::getUsername);
        registry.add("spring.datasource.password", POSTGRES_CONTAINER::getPassword);
    }

    @Test
    public void get_should_returnUser_when_userExists() throws Exception {
        userRepository.deleteAll();
        UserEntity userEntity = new UserEntity();
        userEntity.setIdUser(Long.valueOf(UUID.randomUUID().toString()));
        userEntity.setFio("FIO");
        userEntity.setDateOfBirth("29-07-2004");
        userEntity.setLibraryCardNumber(Long.valueOf(UUID.randomUUID().toString()));
        IssuranceEntity issuranceEntity = new IssuranceEntity();
        issuranceEntity.setIdIssurance(Long.valueOf(UUID.randomUUID().toString()));
        issuranceEntity.setPeriodOfUsage("10");
        issuranceEntity.setDateOfIssurance("10-10-2023");
        issuranceEntity.setIsbnOfBook(Long.valueOf(UUID.randomUUID().toString()));
        issuranceEntity.setCardNumberOfUser(Long.valueOf(UUID.randomUUID().toString()));
        issuranceEntity.setBookEntity(new BookEntity());
        issuranceEntity.setUserEntity(userEntity);
        userEntity.setIssurancesWithUser(Arrays.asList(issuranceEntity));

        UserEntity savedUserEntity = userRepository.save(userEntity);
        String expectedJson = objectMapper.writeValueAsString(UserMapper.entity2User(savedUserEntity));


        mvc.perform(get("/users/" + userEntity.getIdUser()).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(expectedJson));
    }
}
