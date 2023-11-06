package ru.hpclab.bd.module1.repository;

import org.springframework.stereotype.Repository;
import ru.hpclab.bd.module1.controller.exeption.IssuranceException;
import ru.hpclab.bd.module1.model.Issurance;
import ru.hpclab.bd.module1.service.BookService;
import ru.hpclab.bd.module1.service.UserService;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static java.lang.String.format;

/**
 * Repository to access Issurances.
 */
@Repository
public class IssuranceRepository {
    private final BookService bookService;

    private final UserService userService;

    /**
     * Book or user exception not found message.
     */
    public static final String BOOK_OR_USER_NOT_FOUND_MSG =
            "Book with ISBN %s is not found or User with library card number %s is not found";

    /**
     * Issurance not found message.
     * */
    public static final String ISSURANCE_NOT_FOUND_MSG =
            "Issurance with ID %s is not found";

    private final List<Issurance> issurances = new ArrayList<>();

    /**
     * Create a new IssuranceRepository class.
     * @param bookService responsible for managing books
     * @param userService responsible for user management
     */
    public IssuranceRepository(final BookService bookService, final UserService userService) {
        this.bookService = bookService;
        this.userService = userService;
    }

    /**
     * Fetches all issurances.
     * @return list of issurances
     */
    public List<Issurance> findAll() {
        return issurances;
    }

    /**
     * Fetches issurances by card number of user.
     * @param cardNumberOfUser card number of user
     * @return list of issurances
     */
    public List<Issurance> findByCardNumberOfUser(final UUID cardNumberOfUser) {
        List<Issurance> userIssurances = new ArrayList<>();
        for (Issurance issurance : issurances) {
            if (issurance.getCardNumberOfUser().equals(cardNumberOfUser)) {
                userIssurances.add(issurance);
            }
        }
        return userIssurances;
    }

    /**
     * Deletes issurance by idIssurance.
     * @param idIssurance issurance id
     */
    public void delete(final UUID idIssurance) {
        Issurance issueToRemove = null;
        for (Issurance issurance : issurances) {
            if (issurance.getIdIssurance().equals(idIssurance)) {
                issueToRemove = issurance;
            }
        }

        if (issueToRemove != null) {
            issurances.remove(issueToRemove);
        } else {
            throw new IssuranceException(format(ISSURANCE_NOT_FOUND_MSG, idIssurance));
        }

    }

    /**
     * Creates or updates issurance.
     * @param issurance issurance to save
     * @return saved issurance
     */
    public Issurance save(final Issurance issurance) {
        UUID isbnOfBook = issurance.getIsbnOfBook();
        UUID cardNumberOfUser = issurance.getCardNumberOfUser();
        if (bookService.existBook(isbnOfBook) && userService.existUser(cardNumberOfUser)) {
            issurances.add(issurance);
            return issurance;
        } else {
            throw new IssuranceException(format(BOOK_OR_USER_NOT_FOUND_MSG, isbnOfBook, cardNumberOfUser));
        }

    }

    /**
     * Updates issurance.
     * @param issurance issurance to update
     * @return updated issurance
     */
    public Issurance put(final Issurance issurance) {
        UUID idIssurance = issurance.getIdIssurance();

        for (Issurance existingIssue : issurances) {
            if (existingIssue.getIdIssurance().equals(idIssurance)) {
                existingIssue.setIsbnOfBook(issurance.getIsbnOfBook());
                existingIssue.setCardNumberOfUser(issurance.getCardNumberOfUser());
                existingIssue.setDateOfIssurance(issurance.getDateOfIssurance());
                existingIssue.setPeriodOfUsage(issurance.getPeriodOfUsage());
                return existingIssue;
            }
        }
        throw new IssuranceException(format(ISSURANCE_NOT_FOUND_MSG, idIssurance));
    }
}
