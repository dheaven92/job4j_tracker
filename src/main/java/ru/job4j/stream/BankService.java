package ru.job4j.stream;

import ru.job4j.collection.bank.Account;
import ru.job4j.collection.bank.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс описывает работу банковского приложения,
 * которое позволяет работать с данными пользователями и осуществлять переводы средств
 * @author Daria V
 * @version 1.0
 */
public class BankService {

    /**
     * Хранение ползователей осуществляется в коллекции типа HashMap
     */
    private Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод добавляет пользователя в коллекцию, если его еще там нет.
     * Для добавляемого пользователя создается пустой список аккаунтов.
     * @param user пользователь, который добавляется в список
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Метод добавляет аккаунт пользователя, который предварительно находится по паспартным данным.
     * Если пользователь не находится, то аккаунт не добавляется.
     * @param passport номер и серия паспорта, по которым осуществляется поиск пользователя
     * @param account аккаунт, который добавляется пользователю
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> userAccounts = users.get(user);
            if (!userAccounts.contains(account)) {
                userAccounts.add(account);
            }
        }
    }

    /**
     * Метод осуществляет поиск пользователяв коллекции по паспортным данным (номер и серия)
     * @param passport паспортные данные, по которым осуществляется поиск
     * @return возвращает либо найденного пользователя, либо null
     */
    public User findByPassport(String passport) {
        return users.keySet().stream()
                .filter(u -> u.getPassport().equals(passport))
                .findFirst()
                .orElse(null);
    }

    /**
     * Метод осуществляет поиск акаунта по паспортным данным пользователя и реквизитам
     * @param passport паспортные данные (номер и серия), по которым осуществляется поиск
     * @param requisite реквизиты, по которым осуществляется поиск
     * @return возвращает либо найденный аккаунт, либо null
     */
    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user != null) {
            return users.get(user).stream()
                    .filter(a -> a.getRequisite().equals(requisite))
                    .findFirst()
                    .orElse(null);
        }
        return null;
    }

    /**
     * Метод производит перевод средств с одного аккаунта на другой.
     * Предварительно осущетсвляется поиск аккаунта, с которого будут сниматься средства и аккаунта,
     * на который будет осщетсвлять перевод.
     * А также происходит валидация денежных средств на достаточность для перевода.
     * @param srcPassport паспортные данные пользователя, с аккаунта которого будут снимать средства
     * @param srcRequisite реквизиты аккаунта, с которого будут снимать средства
     * @param destPassport паспортные данные пользователя, на аккаунт которого будут
     *                     перечислены средства
     * @param destRequisite реквизиты аккаунта, на который будут начислены средства
     * @param amount количество денег для перевода
     * @return возвращает true в случае успешного перевода, иначе - false
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Account srcAccount = findByRequisite(srcPassport, srcRequisite);
        if (srcAccount != null && srcAccount.getBalance() >= amount) {
            Account destAccount = findByRequisite(destPassport, destRequisite);
            if (destAccount != null) {
                srcAccount.setBalance(srcAccount.getBalance() - amount);
                destAccount.setBalance(destAccount.getBalance() + amount);
                rsl = true;
            }
        }
        return rsl;
    }
}
