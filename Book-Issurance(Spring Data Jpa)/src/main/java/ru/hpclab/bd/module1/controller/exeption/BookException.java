package ru.hpclab.bd.module1.controller.exeption;

/**
 * Generic exception related to books resource.
 */
public class BookException extends RuntimeException {

    /**
     * Builds new BookException from the given message.
     * @param message exception message
     */
    public BookException(final String message) {
        super(message);
    }
}
