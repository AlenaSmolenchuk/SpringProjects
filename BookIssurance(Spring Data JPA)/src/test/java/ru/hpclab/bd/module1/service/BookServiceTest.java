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
import ru.hpclab.bd.module1.entity.BookEntity;
import ru.hpclab.bd.module1.repository.BookRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {BookServiceTest.BookServiceTestConfiguration.class})
public class BookServiceTest {

    private static final int SIMPLE_AMOUNT_OF_PAGES = 200;

    @Autowired
    private BookService bookService;

    @Autowired
    private BookRepository bookRepository;

    @Test
    public void testCreateAndGet() {
        //create
        BookEntity bookEntity = new BookEntity(
                UUID.randomUUID(),
                "name",
                "29072004",
                "A, B, C",
                SIMPLE_AMOUNT_OF_PAGES,
                new ArrayList<>());

        BookEntity savedBook = bookService.saveBook(bookEntity);

        Assertions.assertEquals(bookEntity.getName(), savedBook.getName());
        Mockito.verify(bookRepository, Mockito.times(1)).save(bookEntity);

        //getAll
        List<BookEntity> bookList = bookService.getAllBooks();

        Assertions.assertEquals("name1", bookList.get(0).getName());
        Assertions.assertEquals("name3", bookList.get(1).getName());
        Mockito.verify(bookRepository, Mockito.times(1)).findAll();

    }

    @Configuration
    static class BookServiceTestConfiguration {

        @Bean
        BookRepository bookRepository() {
            BookRepository bookRepository = mock(BookRepository.class);
            when(bookRepository.save(any())).thenReturn(new BookEntity(
                    UUID.randomUUID(),
                    "name",
                    "29072004",
                    "A, B, C",
                    SIMPLE_AMOUNT_OF_PAGES,
                    new ArrayList<>()));
            when(bookRepository.findAll())
                    .thenReturn(Arrays.asList(new BookEntity(
                            UUID.randomUUID(),
                            "name1",
                            "29072004",
                            "A, B, C",
                            SIMPLE_AMOUNT_OF_PAGES,
                            new ArrayList<>()),
                            new BookEntity(UUID.randomUUID(),
                                    "name3",
                                    "29072004",
                                    "A, B, C",
                                    SIMPLE_AMOUNT_OF_PAGES,
                                    new ArrayList<>())));
            return bookRepository;
        }

        @Bean
        BookService BookService(final BookRepository bookRepository) {
            return new BookService(bookRepository);
        }
    }
}
