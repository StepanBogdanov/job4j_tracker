package ru.job4j.bank;

import java.util.*;

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
        Optional<User> user = findByPassport(passport);
        if (user.isPresent()) {
            List<Account> accounts = users.get(user.get());
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
    public Optional<User> findByPassport(String passport) {
        return users.keySet().stream()
                .filter(u -> u.getPassport().equals(passport))
                .findFirst();
    }

    /**
     * Метод осуществляет поиск банковского счета по реквизитам счета
     * и номеру паспорта пользователя
     * @param passport номер паспорта пользователя
     * @param requisite реквизиты банкоского счета
     * @return банковский счет или null, если счет не найден
     */
    public Optional<Account> findByRequisite(String passport, String requisite) {
        Optional<User> user = findByPassport(passport);
        if (user.isPresent()) {
            return users.get(user.get()).stream()
                    .filter(ac -> ac.getRequisite().equals(requisite))
                    .findFirst();
        }
        return Optional.empty();
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
        Optional<Account> srcAccount = findByRequisite(srcPassport, srcRequisite);
        Optional<Account> destAccount = findByRequisite(destPassport, destRequisite);
        if (srcAccount.isPresent() && destAccount.isPresent()
                && srcAccount.get().getBalance() >= amount) {
            srcAccount.get().setBalance(srcAccount.get().getBalance() - amount);
            destAccount.get().setBalance(destAccount.get().getBalance() + amount);
            rsl = true;
        }
        return rsl;
    }
}
