package ru.hpclab.bd.module1.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * User entity.
 */
@Entity
@Table(name = "t_user")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    private UUID idUser;

    @Column(name = "fio")
    private String fio;

    @Column(name = "date_of_birth")
    private String dateOfBirth;

    @Column(name = "library_card_number")
    private UUID libraryCardNumber;

    @OneToMany(mappedBy = "userEntity",  cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<IssuranceEntity> issurancesWithUser = new ArrayList<>();

    /**
     * Empty constructor.
     */
    public UserEntity() {
    }

    /**
     * Builds a new user entity.
     * @param idUser user unique id
     * @param fio user name
     * @param dateOfBirth user date of birth
     * @param libraryCardNumber user card in the library
     * @param issurancesWithUser list of issurances of user
     */
    public UserEntity(final UUID idUser,
                      final String fio,
                      final String dateOfBirth,
                      final UUID libraryCardNumber,
                      final List<IssuranceEntity> issurancesWithUser) {
        this.idUser = idUser;
        this.fio = fio;
        this.dateOfBirth = dateOfBirth;
        this.libraryCardNumber = libraryCardNumber;
        this.issurancesWithUser = issurancesWithUser;
    }

    /**
     * Builds a new user entity.
     * @param fio user name
     * @param dateOfBirth user date of birth
     * @param libraryCardNumber user card in the library
     * @param issurancesWithUser list of issurances of user
     */
    public UserEntity(final String fio,
                      final String dateOfBirth,
                      final UUID libraryCardNumber,
                      final List<IssuranceEntity> issurancesWithUser) {
        this.fio = fio;
        this.dateOfBirth = dateOfBirth;
        this.libraryCardNumber = libraryCardNumber;
        this.issurancesWithUser = issurancesWithUser;
    }

    /**
     * Returns the user's identifier.
     * @return user id
     */
    public UUID getIdUser() {
        return idUser;
    }

    /**
     * Sets a new identifier for the user.
     * @param idUser user id
     */
    public void setIdUser(final UUID idUser) {
        this.idUser = idUser;
    }

    /**
     * Returns the user's name.
     * @return user name
     */
    public String getFio() {
        return fio;
    }

    /**
     * Sets a new name for the user.
     * @param fio user name
     */
    public void setFio(final String fio) {
        this.fio = fio;
    }

    /**
     * Returns the user's date of birth.
     * @return user date of birth
     */
    public String getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * Sets a new date of birth for the user.
     * @param dateOfBirth user date of birth
     */
    public void setDateOfBirth(final String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    /**
     * Returns the user's library card number.
     * @return user library card number
     */
    public UUID getLibraryCardNumber() {
        return libraryCardNumber;
    }

    /**
     * Sets a new library card number for the user.
     * @param libraryCardNumber user library card number
     */
    public void setLibraryCardNumber(final UUID libraryCardNumber) {
        this.libraryCardNumber = libraryCardNumber;
    }

    /**
     * Returns the user's issurance list.
     * @return user issurances with user
     */
    public List<IssuranceEntity> getIssurancesWithUser() {
        return issurancesWithUser;
    }

    /**
     * Sets a new issurance list for the user.
     * @param issurancesWithUser user issurance list
     */
    public void setIssurancesWithUser(final List<IssuranceEntity> issurancesWithUser) {
        this.issurancesWithUser = issurancesWithUser;
    }

    /**
     * Returns a string representation of the user entity.
     */
    @Override
    public String toString() {
        return "UserEntity{"
                + "idUser="
                + idUser
                + ", fio='"
                + fio
                + '\''
                + ", dateOfBirth='"
                + dateOfBirth
                + '\''
                + ", libraryCardNumber="
                + libraryCardNumber
                + '\''
                + ", issurancesWithUser="
                + issurancesWithUser
                + '}';
    }
}
