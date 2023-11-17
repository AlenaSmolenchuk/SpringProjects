package ru.hpclab.bd.module1.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.hpclab.bd.module1.entity.BookEntity;
import ru.hpclab.bd.module1.entity.UserEntity;
import ru.hpclab.bd.module1.repository.BookRepository;
import ru.hpclab.bd.module1.repository.IssuranceRepository;
import ru.hpclab.bd.module1.repository.UserRepository;
import ru.hpclab.bd.module1.service.BookService;
import ru.hpclab.bd.module1.service.IssuranceService;
import ru.hpclab.bd.module1.service.UserService;

import java.util.ArrayList;
import java.util.Random;
import java.util.UUID;

/**
 * Provides services configuration.
 */
@Configuration
public class ServicesConfig {

    private static Random random = new Random();

    /**
     * Generate a random year.
     */
    private static final int MIN_YEAR = 1900;
    private static final int MAX_YEAR = 2100;
    private static final int RANDOM_YEAR = random.nextInt(MAX_YEAR - MIN_YEAR + 1) + MIN_YEAR;

    /**
     * Generate a random count of pages.
     */
    private static final int MIN_COUNT_OF_PAGES = 10;
    private static final int MAX_COUNT_OF_PAGES = 1000;
    private static final int RANDOM_COUNT_OF_PAGES = random.nextInt(MAX_COUNT_OF_PAGES - MIN_COUNT_OF_PAGES + 1)
            + MIN_COUNT_OF_PAGES;

    /**
     * Builds and inits new user service.
     *
     * @param userRepository user repository
     * @return new user service
     */
    @Bean
    public UserService userService(final UserRepository userRepository) {
        UserService userService = new UserService(userRepository);

        userRepository.save(
                new UserEntity(UUID.randomUUID(),
                        "Alena",
                        "2004-07-29",
                        UUID.randomUUID(),
                        new ArrayList<>()));
        userRepository.save(
                new UserEntity(UUID.randomUUID(),
                        "Mary",
                        "2002-07-21",
                        UUID.randomUUID(),
                        new ArrayList<>()));
        userRepository.save(
                new UserEntity(UUID.randomUUID(),
                        "Tanya",
                        "1999-01-05",
                        UUID.randomUUID(),
                        new ArrayList<>()));
        userRepository.save(
                new UserEntity(UUID.randomUUID(),
                        "super user",
                        "2000-12-12",
                        UUID.randomUUID(),
                        new ArrayList<>()));
        return userService;
    }

    /**
     * Builds and inits new book service.
     *
     * @param bookRepository book repository
     * @return new book service
     */
    @Bean
    public BookService bookService(final BookRepository bookRepository) {
        BookService bookService = new BookService(bookRepository);
        bookRepository.save(
                new BookEntity(UUID.randomUUID(),
                        "ABC",
                        "Albert Einstein",
                        String.valueOf(RANDOM_YEAR),
                        RANDOM_COUNT_OF_PAGES,
                        new ArrayList<>()));
        bookRepository.save(
                new BookEntity(UUID.randomUUID(),
                        "Billie Dshin",
                        "Asley Hyrru",
                        String.valueOf(RANDOM_YEAR),
                        RANDOM_COUNT_OF_PAGES,
                        new ArrayList<>()));
        return bookService;
    }

    /**
     * Builds and inits new issurance service.
     *
     * @param issuranceRepository issurance repository
     * @return new issurance service
     */
    @Bean
    public IssuranceService issueService(final IssuranceRepository issuranceRepository) {
        return new IssuranceService(issuranceRepository);
    }
}
