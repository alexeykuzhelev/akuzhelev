package ru.job4j.bank;

import java.util.*;
import java.util.stream.Stream;

/**
 * @author Alexey Kuzhelev (aleks2kv1977@gmail.com)
 * @version $Id$
 * @since 08.08.2019
 */

/**
 * Класс Банк - реализует банковские переводы.
 */

public class Bank {
    /**
     * Коллекция пользователей со списками банковских счетов.
     */
    private HashMap<User, List<Account>> accounts = new HashMap<>();

    /**
     * Метод для добавления пользователя.
     * @param user - пользователь.
     */
    public void addUser(User user) {
        this.accounts.putIfAbsent(user, new ArrayList<Account>());
    }

    /**
     * Метод для удаления пользователя.
     * @param user - пользователь.
     */
    public void deleteUser(User user) {
        this.accounts.remove(user);
    }

    /**
     * Метод добавляет счет пользователю.
     * @param passport - паспортные данные.
     * @param account  - банковский счет.
     * user.isPresent() - проверка, что пользователь есть.
     * accountOpt.isPresent() - проверка, что аккаунт есть.
     */
    public void addAccountToUser(String passport, Account account) {
        List<Account> list = this.getUserAccounts(passport);
        Optional<User> user = findUserByPassport(passport);
        Optional<Account> accountOpt = Optional.of(account);
        if (user.isPresent() && accountOpt.isPresent() && list.indexOf(account) < 0) {
            list.add(account);
        }
    }

    /**
     * Метод удаляет один счет пользователя.
     * @param passport - паспортные данные.
     * @param account - банковский счет.
     * user.isPresent() - проверка, что пользователь есть.
     * accountOpt.isPresent() - проверка, что аккаунт есть.
     */
    public void deleteAccountFromUser(String passport, Account account) {
        Optional<User> user = findUserByPassport(passport);
        Optional<Account> accountOpt = Optional.of(account);
        if (user.isPresent() && accountOpt.isPresent()) {
            this.getUserAccounts(passport).remove(account);
        }
    }

    /**
     * Метод получает список счетов для пользователя.
     * @param passport - паспортные данные.
     * user.isPresent() - проверка, что пользователь есть.
     * @return - список счетов.
     */
    public List<Account> getUserAccounts(String passport) {
        List<Account> result = new ArrayList<>();
        Optional<User> user = findUserByPassport(passport);
        if (user.isPresent()) {
            result = accounts.get(user.get());
        }
        return result;
    }

    /**
     * Метод находит клиента по паспортным данным.
     * @param passport - паспортные данные.
     * @return Optional<User>.
     */
    public Optional<User> findUserByPassport(String passport) {
        return accounts.entrySet().stream().map(Map.Entry::getKey)
                .filter(us -> us.getPassport().equals(passport)).findFirst();
    }

    /**
     * Метод для перечисления денег с одного счёта на другой счёт:
     * srcAccount - счет, с которого переводят деньги.
     * dstAccount - счет, на который переводят деньги.
     * @param srcPassport - паспорт того, кто переводит деньги.
     * @param srcRequisite - реквизиты счета, с которого переводят деньги.
     * @param dstPassport - паспорт того, кому переводят деньги.
     * @param dstRequisite - реквизиты счета, куда переводят деньги.
     * @param amount - переводимая сумма денег.
     * @return - true, если перевод выполнен, false - если счет не найден или не хватает денег на счете.
     */
    public boolean transferMoney(String srcPassport, String srcRequisite, String dstPassport, String dstRequisite, double amount) {
        boolean result = true;
        Optional<Account> srcAccount = this.findAccount(this.getUserAccounts(srcPassport), srcRequisite);
        Optional<Account> dstAccount = this.findAccount(this.getUserAccounts(dstPassport), dstRequisite);
        if (!srcAccount.isPresent() || !dstAccount.isPresent() || (srcAccount.get().getValue() - amount) < 0) {
            result = false;
        } else {
            srcAccount.get().setValue(srcAccount.get().getValue() - amount);
            dstAccount.get().setValue(dstAccount.get().getValue() + amount);
        }
        return result;
    }

    /**
     * Метод находит банковский счет пользователя по его реквизитам.
     * @param list - список банковских счетов пользователя.
     * @param requisite - реквизиты банковского счета.
     * @return Optional<Account>.
     */
    public Optional<Account> findAccount(List<Account> list, String requisite) {
        Optional<Account> account = Optional.empty();
        if (!list.isEmpty()) {
            account = list.stream().filter(ac -> ac.getRequisites().equals(requisite)).findFirst();
        }
        return account;
    }
}
