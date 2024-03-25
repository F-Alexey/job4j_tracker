package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс описывает модель пользователя
 */

public class User {
    private String passport;
    private String username;
    /**
     * Хранение данных о пользователе в полях:
     * @param passport пасспорт
     * @param username имя
     */

    public User(String passport, String username) {
        this.passport = passport;
        this.username = username;
    }

    public String getPassport() {
        return passport;
    }

    public String getUsername() {
        return username;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Переопределение метода equals
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(passport, user.passport);
    }

    @Override
    public int hashCode() {
        return Objects.hash(passport);
    }
}
