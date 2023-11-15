package ru.hpclab.bd.module1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.hpclab.bd.module1.mapper.BookMapper;
import ru.hpclab.bd.module1.model.Book;
import ru.hpclab.bd.module1.service.BookService;


import java.util.List;
import java.util.stream.Collectors;

/**
 * Rest controller for books.
 */
@RestController
public class BookController {

    private final BookService bookService;

    /**
     * Builds new BookController.
     * @param bookService book service
     */
    @Autowired
    public BookController(final BookService bookService) {
        this.bookService = bookService;
    }

    /**
     * Returns all books.
     * @return list of books
     */
    @GetMapping("/books")
    public List<Book> getBooks() {
        return bookService.getAllBooks().stream()
                .map(BookMapper::entity2Book).collect(Collectors.toList());
    }

    /**
     * Returns book by isbn.
     * @param isbn book number
     * @return book
     */
    @GetMapping("/books/{isbn}")
    public Book getBookByIBSN(@PathVariable final Long isbn) {
        return BookMapper.entity2Book(bookService.getBookByIsbn(isbn));
    }

    /**
     * Deletes book by isbn.
     * @param isbn book number
     */
    @DeleteMapping("/books/{isbn}")
    public void deleteBook(@PathVariable final Long isbn) {
        bookService.deleteBook(isbn);
    }

    /**
     * Creates or updates book.
     * @param book book
     * @return saved book
     */
    @PostMapping(value = "/books")
    public Book saveBook(@RequestBody final Book book) {
        return BookMapper.entity2Book(bookService.saveBook(BookMapper.book2Entity(book)));
    }

    /**
     * Updates book.
     * @param isbn book number
     * @param book book's new attributes
     * @return updated book
     */
    @PutMapping(value = "/books/{isbn}")
    public Book updateBook(
            @PathVariable(required = false) final Long isbn,
            @RequestBody final Book book
    ) {
        return BookMapper.entity2Book(bookService.updateBook(isbn, BookMapper.book2Entity(book)));
    }
}
