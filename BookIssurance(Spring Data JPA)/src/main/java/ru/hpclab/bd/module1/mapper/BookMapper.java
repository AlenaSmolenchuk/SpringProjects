package ru.hpclab.bd.module1.mapper;

import ru.hpclab.bd.module1.entity.BookEntity;
import ru.hpclab.bd.module1.entity.IssuranceEntity;
import ru.hpclab.bd.module1.model.Book;
import ru.hpclab.bd.module1.model.Issurance;

import java.util.ArrayList;
import java.util.List;

/**
 * Mapper for book.
 */
public final class BookMapper {

    /**
     * Empty contructor.
     */
    private BookMapper() {

    }

    /**
     * Converts a Book object to a BookEntity object.
     *
     * @param book The Book object to be converted.
     * @return The corresponding BookEntity object.
     */
    public static BookEntity book2Entity(final Book book) {
        BookEntity bookEntity = new BookEntity();
        bookEntity.setIsbn(book.getIsbn());
        bookEntity.setName(book.getName());
        bookEntity.setAllAuthors(book.getAllAuthors());
        bookEntity.setYear(book.getYear());
        bookEntity.setAmountOfPages(book.getAmountOfPages());

        List<IssuranceEntity> issuranceEntityList = new ArrayList<>();
        for (Issurance issurance : book.getIssurancesWithBook()) {
            IssuranceEntity issuranceEntity = IssuranceMapper.issurance2Entity(issurance);
            issuranceEntityList.add(issuranceEntity);
        }
        bookEntity.setIssurancesWithBook(issuranceEntityList);

        return bookEntity;
    }

    /**
     * Converts a BookEntity object to a Book object.
     *
     * @param bookEntity The BookEntity object to be converted.
     * @return The corresponding Book object.
     */
    public static Book entity2Book(final BookEntity bookEntity) {
        Book book = new Book();
        book.setIsbn(bookEntity.getIsbn());
        book.setName(bookEntity.getName());
        book.setAllAuthors(bookEntity.getAllAuthors());
        book.setYear(bookEntity.getYear());
        book.setAmountOfPages(bookEntity.getAmountOfPages());

        List<Issurance> issuranceList = new ArrayList<>();
        for (IssuranceEntity issuranceEntity : bookEntity.getIssurancesWithBook()) {
            Issurance issurance = IssuranceMapper.entity2Issurance(issuranceEntity);
            issuranceList.add(issurance);
        }
        book.setIssurancesWithBook(issuranceList);

        return book;
    }
}
