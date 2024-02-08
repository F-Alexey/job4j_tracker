package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankService {
    private final Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<Account>());
    }

    public void deleteUser(String passport) {
        users.remove(findByPassport(passport));
    }

    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            if (!users.get(user).contains(account)) {
                users.get(user).add(account);
            }
        }
    }

    public User findByPassport(String passport) {
        User result = null;
        for (User names : users.keySet()) {
            if (names.getPassport().equals(passport)) {
                result = names;
                break;
            }
        }
        if (result == null) {
            System.out.println("Пользователь с таким паспортом не найден в базе");
        }
        return result;
    }

    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        List<Account> account = getAccounts(user);
        Account result = null;
        if (account != null) {
            for (Account value : account) {
                if (value.getRequisite().equals(requisite)) {
                    result = value;
                }
            }
        }
        return result;
    }

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

    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}
