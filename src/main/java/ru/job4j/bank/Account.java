package ru.job4j.bank;

import java.util.Objects;
/**
 * Класс описывает модель банковского счета
 */

public class Account {
    private String requisite;
    private double balance;
    /**
     * Поля хранящие основные данные
     * @param requisite реквизиты пользователя
     * @param balance балланс счета пользователя
     */

    public Account(String requisite, double balance) {
        this.requisite = requisite;
        this.balance = balance;
    }

    public String getRequisite() {
        return requisite;
    }

    public double getBalance() {
        return balance;
    }

    public void setRequisite(String requisite) {
        this.requisite = requisite;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public int hashCode() {
        return Objects.hash(requisite);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Account account = (Account) o;
        return Objects.equals(requisite, account.requisite);
    }
}
