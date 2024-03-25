package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс описывает модель для банковской системы, в ней возможно
 * 1. Регистрировать пользователя.
 * 2. Удалять пользователя из системы.
 * 3. Добавлять пользователю банковский счет. У пользователя системы могут быть несколько счетов.
 * 4. Переводить деньги с одного банковского счета на другой счет.
 */
public class BankService {
    /**
     * users Это поле содержит всех пользователей системы с привязанными к ним счетами
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * @param user добавление нового пользователя
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<Account>());
    }

    /**
     * @param passport удаление пользователя по данным паспорта
     */
    public void deleteUser(String passport) {
        users.remove(new User(passport, ""));
    }

    /**
     * Добавление аккаунта в случае если не существует, идет проверка по пасспорту и аккаунту
     * @param passport паспорт
     * @param account аккаунт
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        List<Account> userAccount = users.get(user);
        if (user != null) {
            if (!userAccount.contains(account)) {
                userAccount.add(account);
            }
        }
    }

    /**
     * поиск пользователя по паспорту
     * @param passport искомый паспорт
     * @return  возвращает пользователя
     */
    public User findByPassport(String passport) {
        User result = null;
        for (User names : users.keySet()) {
            if (names.getPassport().equals(passport)) {
                result = names;
                break;
            }
        }
        return result;
    }

    /**
     * поиск аккаунта по реквизитам
     * @param passport пасспорт поьзователя
     * @param requisite реквизиты аккаунта
     * @return возвращает аккаунт
     */
    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        Account result = null;
        if (user != null) {
            List<Account> userAccount = users.get(user);
            for (Account value : userAccount) {
                if (value.getRequisite().equals(requisite)) {
                    result = value;
                    break;
                }
            }
        }
        return result;
    }

    /**
     * Перемещает средства с одного аккаунта на другой, в случае если это возможно
     * @param sourcePassport паспорт пользователя от которого будут переведены средства
     * @param sourceRequisite реквизиты пользователя от которого будут переведены средства
     * @param destinationPassport паспорт пользователя которому будут переведены средства
     * @param destinationRequisite реквизиты пользователя которому будут переведены средства
     * @param amount сумма перевода
     * @return возвращает значение true сли средсва были переведены и false если нет.
     */
    public boolean transferMoney(String sourcePassport, String sourceRequisite,
                                 String destinationPassport, String destinationRequisite, double amount) {
        boolean result = false;
        Account from = findByRequisite(sourcePassport, sourceRequisite);
        Account destination = findByRequisite(destinationPassport, destinationRequisite);

        if (from != null && destination != null && from.getBalance() >= amount) {
            from.setBalance(from.getBalance() - amount);
            destination.setBalance(destination.getBalance() + amount);
            result = true;
        }
        return result;
    }

    /**
     * получение аккаунта из списка
     * @param user пользователь которого ищет
     * @return возвращает аккаунт пользователя
     */
    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}
