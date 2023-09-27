package org.example.models;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class Person {

    private int id;

    @NotEmpty(message = "Имя не должно быть пустым")
    @Size(min = 3, max = 124, message = "Имя должно состоять от 3 до 124 символов")
    private String fullName;


    @Min(value = 1900, message = "Год рождения должен быть больше, чем 1900")
    private int birthdayYear;

    public Person() {}

    public Person(int id, String fullName, int birthdayYear) {
        this.id = id;
        this.fullName = fullName;
        this.birthdayYear = birthdayYear;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getBirthdayYear() {
        return birthdayYear;
    }

    public void setBirthdayYear(int birthdayYear) {
        this.birthdayYear = birthdayYear;
    }
}
