package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс описывает простешую модель банковской системы
 * @author STEPAN BOGDANOV
 */
public class BankService {
    private Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Метод добавляет новый банковский счет пользователю,
     * если такого счета у пользователя нет.
     * Поиск пользователя произвдится с помощью метода findByPassport.
     * @param passport номер паспорта пользователя
     * @param account банковский счет
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = users.get(user);
            if (!accounts.contains(account)) {
                accounts.add(account);
            }
        }
    }

    /**
     * Метод осуществляет поиск пользователя по номеру паспорта
     * @param passport номер паспорта пользователя
     * @return возвращает пользователя или null, если пользователь не найден
     */
    public User findByPassport(String passport) {
        User rsl = null;
        for (User user : users.keySet()) {
            if (user.getPassport().equals(passport)) {
                rsl = user;
                break;
            }
        }
        return rsl;
    }

    /**
     * Метод осуществляет поиск банковского счета по реквизитам счета
     * и номеру паспорта пользователя
     * @param passport номер паспорта пользователя
     * @param requisite реквизиты банкоского счета
     * @return банковский счет или null, если счет не найден
     */
    public Account findByRequisite(String passport, String requisite) {
        Account rsl = null;
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = users.get(user);
            for (Account account : accounts) {
                if (account.getRequisite().equals(requisite)) {
                    rsl = account;
                    break;
                }
            }
        }
        return rsl;
    }

    /**
     * Метод для перечисления денег с одного счета на другой.
     * Метод производит поиск счетов по номерам паспорта и ревизитам,
     * и осуществляет перевод если счета существуют и на счете пользователя,
     * осущетсвляющего перевод, достаточно средств.
     * @param srcPassport номер паспорта пользователя, осуществляющего перевод
     * @param srcRequisite реквизиты счета пользователя пользователя, осуществляющего перевод
     * @param destPassport номер счета пользователя пользователя, принимающего перевод
     * @param destRequisite реквизиты счета пользователя пользователя, принимающего перевод
     * @param amount сумма перевода
     * @return true если перевод прошел успешно, либо false если нет
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Account srcAccount = findByRequisite(srcPassport, srcRequisite);
        Account destAccount = findByRequisite(destPassport, destRequisite);
        if (srcAccount != null && destAccount != null && srcAccount.getBalance() >= amount) {
            srcAccount.setBalance(srcAccount.getBalance() - amount);
            destAccount.setBalance(destAccount.getBalance() + amount);
            rsl = true;
        }
        return rsl;
    }
}
