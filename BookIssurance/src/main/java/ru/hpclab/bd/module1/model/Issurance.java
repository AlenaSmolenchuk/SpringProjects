package ru.hpclab.bd.module1.model;

import org.springframework.lang.NonNull;

import java.util.Date;
import java.util.UUID;

/**
 * Issurance model.
 */
public class Issurance {

    @NonNull
    private UUID idIssurance;

    @NonNull
    private UUID cardNumberOfUser;

    @NonNull
    private UUID isbnOfBook;

    @NonNull
    private Date dateOfIssurance;

    @NonNull
    private String periodOfUsage;

    /**
     * Empty contructor.
     */
    public Issurance() {
    }

    /**
     * Builds new issurance.
     * @param idIssurance issurance unique id
     * @param cardNumberOfUser user card in library
     * @param isbnOfBook book number
     * @param dateOfIssurance issurance date
     * @param periodOfUsage usage period
     */
    public Issurance(@NonNull final UUID idIssurance,
                     @NonNull final UUID cardNumberOfUser,
                     @NonNull final UUID isbnOfBook,
                     @NonNull final Date dateOfIssurance,
                     @NonNull final String periodOfUsage) {
        this.idIssurance = idIssurance;
        this.cardNumberOfUser = cardNumberOfUser;
        this.isbnOfBook = isbnOfBook;
        this.dateOfIssurance = dateOfIssurance;
        this.periodOfUsage = periodOfUsage;
    }

    /**
     * Returns issurance idIssurance.
     * @return issurance id
     */
    @NonNull
    public UUID getIdIssurance() {
        return idIssurance;
    }

    /**
     * Sets new idIssurance for issurance.
     * @param idIssurance issurance id
     */
    public void setIdIssurance(@NonNull final UUID idIssurance) {
        this.idIssurance = idIssurance;
    }

    /**
     * Returns issurance cardNumberOfUser.
     * @return issurance card number of user
     */
    @NonNull
    public UUID getCardNumberOfUser() {
        return cardNumberOfUser;
    }

    /**
     * Sets new card number of user for issurance.
     * @param cardNumberOfUser user cardNumberOfUser
     */
    public void setCardNumberOfUser(@NonNull final UUID cardNumberOfUser) {
        this.cardNumberOfUser = cardNumberOfUser;
    }

    /**
     * Returns issurance isbnOfBook.
     * @return issurance isbn of book
     */
    @NonNull
    public UUID getIsbnOfBook() {
        return isbnOfBook;
    }

    /**
     * Sets new isbnOfBook for issurance.
     * @param isbnOfBook issurance isbn of book
     */
    public void setIsbnOfBook(@NonNull final UUID isbnOfBook) {
        this.isbnOfBook = isbnOfBook;
    }

    /**
     * Returns issurance dateOfIssurance.
     * @return issurance date of issurance
     */
    @NonNull
    public Date getDateOfIssurance() {
        return dateOfIssurance;
    }

    /**
     * Sets new dateOfIssurance for issurance.
     * @param dateOfIssurance issurance dateOfIssurance
     */
    public void setDateOfIssurance(@NonNull final Date dateOfIssurance) {
        this.dateOfIssurance = dateOfIssurance;
    }

    /**
     * Returns issurance periodOfUsage.
     * @return issuranse period of usage
     */
    @NonNull
    public String getPeriodOfUsage() {
        return periodOfUsage;
    }

    /**
     * Sets new periodOfUsage for issurance.
     * @param periodOfUsage issurance period of usage
     */
    public void setPeriodOfUsage(@NonNull final String periodOfUsage) {
        this.periodOfUsage = periodOfUsage;
    }

    /**
     * Returns string representation of the issurance.
     */
    @Override
    public String toString() {
        return "Issurance{"
                + "idIssurance="
                + idIssurance
                + ", cardNumberOfUser="
                + cardNumberOfUser
                + ", isbnOfBook="
                + isbnOfBook
                + ", dateOfIssurance="
                + dateOfIssurance
                + ", periodOfUsage='"
                + periodOfUsage
                + '\''
                + '}';
    }
}
