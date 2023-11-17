package ru.hpclab.bd.module1.entity;

import jakarta.persistence.*;

import java.util.UUID;

/**
 * Issurance entity.
 */
@Entity
@Table(name = "Issurance")
public class IssuranceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_issurance")
    private UUID idIssurance;


    @Column(name = "card_number_of_user", insertable = false, updatable = false)
    private UUID cardNumberOfUser;


    @Column(name = "isbn_of_book", insertable = false, updatable = false)
    private UUID isbnOfBook;

    @Column(name = "date_of_issurance")
    private String dateOfIssurance;

    @Column(name = "period_of_usage")
    private String periodOfUsage;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.DETACH})
    @JoinColumn(name = "card_number_of_user", nullable = false)
    private UserEntity userEntity;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.DETACH})
    @JoinColumn(name = "isbn_of_book", nullable = false)
    private BookEntity bookEntity;

    /**
     * Empty contructor.
     */
    public IssuranceEntity() {
    }

    /**
     * Builds new issurance.
     * @param idIssurance issurance unique id
     * @param cardNumberOfUser user card in library
     * @param isbnOfBook book number
     * @param dateOfIssurance issurance date
     * @param periodOfUsage usage period
     * @param userEntity entity of user
     * @param bookEntity entity of book
     */
    public IssuranceEntity(final UUID idIssurance,
                           final UUID cardNumberOfUser,
                           final UUID isbnOfBook,
                           final String dateOfIssurance,
                           final String periodOfUsage,
                           final UserEntity userEntity,
                           final BookEntity bookEntity) {
        this.idIssurance = idIssurance;
        this.cardNumberOfUser = cardNumberOfUser;
        this.isbnOfBook = isbnOfBook;
        this.dateOfIssurance = dateOfIssurance;
        this.periodOfUsage = periodOfUsage;
        this.userEntity = userEntity;
        this.bookEntity = bookEntity;
    }

    /**
     * Returns issurance idIssurance.
     * @return issurance id
     */
    public UUID getIdIssurance() {
        return idIssurance;
    }

    /**
     * Sets new idIssurance for issurance.
     * @param idIssurance issurance id
     */
    public void setIdIssurance(final UUID idIssurance) {
        this.idIssurance = idIssurance;
    }

    /**
     * Returns issurance cardNumberOfUser.
     * @return issurance card number of user
     */
    public UUID getCardNumberOfUser() {
        return cardNumberOfUser;
    }

    /**
     * Sets new card number of user for issurance.
     * @param cardNumberOfUser user cardNumberOfUser
     */
    public void setCardNumberOfUser(final UUID cardNumberOfUser) {
        this.cardNumberOfUser = cardNumberOfUser;
    }

    /**
     * Returns issurance isbnOfBook.
     * @return issurance isbn of book
     */
    public UUID getIsbnOfBook() {
        return isbnOfBook;
    }

    /**
     * Sets new isbnOfBook for issurance.
     * @param isbnOfBook issurance isbn of book
     */
    public void setIsbnOfBook(final UUID isbnOfBook) {
        this.isbnOfBook = isbnOfBook;
    }

    /**
     * Returns issurance dateOfIssurance.
     * @return issurance date of issurance
     */
    public String getDateOfIssurance() {
        return dateOfIssurance;
    }

    /**
     * Sets new dateOfIssurance for issurance.
     * @param dateOfIssurance issurance dateOfIssurance
     */
    public void setDateOfIssurance(final String dateOfIssurance) {
        this.dateOfIssurance = dateOfIssurance;
    }

    /**
     * Returns issurance periodOfUsage.
     * @return issuranse period of usage
     */
    public String getPeriodOfUsage() {
        return periodOfUsage;
    }

    /**
     * Sets new periodOfUsage for issurance.
     * @param periodOfUsage issurance period of usage
     */
    public void setPeriodOfUsage(final String periodOfUsage) {
        this.periodOfUsage = periodOfUsage;
    }

    /**
     * Returns issurance user entity.
     * @return issuranse userEntity
     */
    public UserEntity getUserEntity() {
        return userEntity;
    }

    /**
     * Sets new user entity for issurance.
     * @param userEntity issurance user entity
     */
    public void setUserEntity(final UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    /**
     * Returns issurance book entity.
     * @return issuranse bookEntity
     */
    public BookEntity getBookEntity() {
        return bookEntity;
    }

    /**
     * Sets new book entity for issurance.
     * @param bookEntity issurance book
     */
    public void setBookEntity(final BookEntity bookEntity) {
        this.bookEntity = bookEntity;
    }

    /**
     * Returns string representation of the issurance entity.
     */
    @Override
    public String toString() {
        return "IssuranceEntity{"
                + "idIssurance="
                + idIssurance
                + ", cardNumberOfUser="
                + cardNumberOfUser
                + ", isbnOfBook="
                + isbnOfBook
                + ", dateOfIssurance='"
                + dateOfIssurance
                + '\''
                + ", periodOfUsage='"
                + periodOfUsage
                + '\''
                + ", userEntity="
                + userEntity
                + ", bookEntity="
                + bookEntity
                + '}';
    }
}
