package ru.hpclab.bd.module1.model;

import org.springframework.lang.NonNull;
import java.util.UUID;

/**
 * User model.
 */
public class User {
    @NonNull
    private UUID idUser;
    @NonNull
    private String fio;

    @NonNull
    private String dateOfBirth;

    @NonNull
    private UUID libraryCardNumber;

    /**
     * Builds a new user.
     * @param idUser user unique id
     * @param fio user name
     * @param dateOfBirth user date of birth
     * @param libraryCardNumber user card in the library
     */
    public User(@NonNull final UUID idUser,
                @NonNull final String fio,
                @NonNull final String dateOfBirth,
                @NonNull final UUID libraryCardNumber) {
        this.idUser = idUser;
        this.fio = fio;
        this.dateOfBirth = dateOfBirth;
        this.libraryCardNumber = libraryCardNumber;
    }

    /**
     * Empty constructor.
     */
    public User() {
    }

    /**
     * Returns the user's identifier.
     * @return user id
     */
    @NonNull
    public UUID getIdUser() {
        return idUser;
    }

    /**
     * Sets a new identifier for the user.
     * @param idUser user id
     */
    public void setIdUser(@NonNull final UUID idUser) {
        this.idUser = idUser;
    }

    /**
     * Returns the user's name.
     * @return user name
     */
    @NonNull
    public String getFio() {
        return fio;
    }

    /**
     * Sets a new name for the user.
     * @param fio user name
     */
    public void setFio(@NonNull final String fio) {
        this.fio = fio;
    }

    /**
     * Returns the user's date of birth.
     * @return user date of birth
     */
    @NonNull
    public String getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * Sets a new date of birth for the user.
     * @param dateOfBirth user date of birth
     */
    public void setDateOfBirth(@NonNull final String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    /**
     * Returns the user's library card number.
     * @return user library card number
     */
    @NonNull
    public UUID getLibraryCardNumber() {
        return libraryCardNumber;
    }

    /**
     * Sets a new library card number for the user.
     * @param libraryCardNumber user library card number
     */
    public void setLibraryCardNumber(@NonNull final UUID libraryCardNumber) {
        this.libraryCardNumber = libraryCardNumber;
    }

    /**
     * Returns a string representation of the user.
     */
    @Override
    public String toString() {
        return "User{"
                + "id="
                + idUser
                + ", fio='"
                + fio
                + '\''
                + ", dateOfBirth='"
                + dateOfBirth
                + '\''
                + ", libraryCardNumber="
                + libraryCardNumber
                + '}';
    }
}
