package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Alexey Kuzhelev (aleks2kv1977@gmail.com)
 * @version $Id$
 * @since 14.04.2019
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
     */
    public void addAccountToUser(String passport, Account account) {
        List<Account> list = this.getUserAccounts(passport);
        if (list.indexOf(account) < 0) {
            list.add(account);
        }
    }

    /**
     * Метод удаляет один счет пользователя.
     * @param passport - паспортные данные.
     * @param account - банковский счет.
     */
    public void deleteAccountFromUser(String passport, Account account) {
        this.getUserAccounts(passport).remove(account);
    }

    /**
     * Метод получает список счетов для пользователя.
     * @param passport - паспортные данные.
     * @return - список счетов.
     */
    public List<Account> getUserAccounts(String passport) {
        List<Account> result = new ArrayList<>();
        for (Map.Entry<User, List<Account>> entry : this.accounts.entrySet()) {
            if (passport.equals(entry.getKey().getPassport())) {
                result = entry.getValue();
                break;
            }
        }
        return result;
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
        Account srcAccount = this.findAccount(this.getUserAccounts(srcPassport), srcRequisite);
        Account dstAccount = this.findAccount(this.getUserAccounts(dstPassport), dstRequisite);
        if (srcAccount == null || dstAccount == null || (srcAccount.getValue() - amount) < 0) {
            result = false;
        } else {
            srcAccount.setValue(srcAccount.getValue() - amount);
            dstAccount.setValue(dstAccount.getValue() + amount);
        }
        return result;
    }

    /**
     * Метод находит банковский счет пользователя по его реквизитам.
     * @param list - список банковских счетов пользователя.
     * @param requisite - реквизиты банковского счета.
     * @return - банковский счет пользователя.
     */
    public Account findAccount(List<Account> list, String requisite) {
        Account result = null;
        for (Account account : list) {
            if (requisite.equals(account.getRequisites())) {
                result = account;
                break;
            }
        }
        return result;
    }
}
