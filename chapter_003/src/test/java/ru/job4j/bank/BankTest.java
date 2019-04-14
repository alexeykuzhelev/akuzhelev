package ru.job4j.bank;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Alexey Kuzhelev (aleks2kv1977@gmail.com)
 * @version $Id$
 * @since 14.04.2019
 */

/**
 * Тестирование класса Bank.
 */
public class BankTest {
    @Test
    public void whenTransferMoneyYes() {
        Bank bank = new Bank();
        bank.addUser(new User("Том  Смит", "000001"));
        bank.addAccountToUser("000001", new Account(1000, "00000001"));
        bank.addUser(new User("Джон  Доу", "000002"));
        bank.addAccountToUser("000002", new Account(2000, "00000002"));
        bank.transferMoney("000001", "00000001", "000002", "00000002", 100);
        double result = bank.findAccount(bank.getUserAccounts("000002"), "00000002").getValue();
        assertThat(result, is(2100.0));
    }

    @Test
    public void whenTransferMoneyNo() {
        Bank bank = new Bank();
        bank.addUser(new User("Том  Смит", "000001"));
        bank.addAccountToUser("000001", new Account(1000, "00000001"));
        bank.addUser(new User("Джон  Доу", "000002"));
        bank.addAccountToUser("000002", new Account(2000, "00000002"));
        boolean result = bank.transferMoney("000003", "00000001", "000002", "00000002", 100);
        assertThat(result, is(false));
    }
}
