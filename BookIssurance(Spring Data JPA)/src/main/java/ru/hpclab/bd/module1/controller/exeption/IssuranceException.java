package ru.hpclab.bd.module1.controller.exeption;

/**
 * Generic exception related to issurances resource.
 */
public class IssuranceException extends RuntimeException {

    /**
     * Builds new IssuranceException from the given message.
     * @param message exception message
     */
    public IssuranceException(final String message) {
        super(message);
    }
}
