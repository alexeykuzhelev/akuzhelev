package ru.job4j.exam;

import java.util.*;

/**
 * @author Alexey Kuzhelev (aleks2kv1977@gmail.com)
 * @version $Id$
 * @since 29.06.2020
 */

/**
 * Класс реализует алгоритм, выполняющий слияние пользователей по их email-ам.
 * Имеется n пользователей, каждому из них соответствует список email-ов
 * (всего у всех пользователей m email-ов).
 * Например:
 * user1 ->xxx@ya.ru,foo@gmail.com,lol@mail.ru
 * user2 ->foo@gmail.com,ups@pisem.net
 * user3 ->xyz@pisem.net,vasya@pupkin.com
 * user4 ->ups@pisem.net,aaa@bbb.ru
 * user5 ->xyz@pisem.net
 *
 * Считается, что если у двух пользователей есть общий email, значит это
 * один и тот же пользователь.
 * Требуется построить и реализовать алгоритм, выполняющий слияние пользователей.
 * На выходе должен быть список пользователей с их email-ами (такой же как на входе).
 * В качестве имени объединенного пользователя можно брать любое из исходных имен.
 * Список email-ов пользователя должен содержать только уникальные email-ы.
 * Параметры n и m произвольные, длина конкретного списка email-ов никак не ограничена.
 * Требуется, чтобы асимптотическое время работы полученного решения было
 * линейным, или близким к линейному.
 *
 * Возможный ответ на задачу в указанном примере:
 * user1 ->xxx@ya.ru,foo@gmail.com,lol@mail.ru,ups@pisem.net,aaa@bbb.ru
 * user3 ->xyz@pisem.net,vasya@pupkin.com
 */
public class Email {

    public static Map<String, Set<String>> merge(List<User> users) {

        Map<String, String> storeUniqueEmails = new HashMap<>();
        Map<String, Set<String>> mergedUsers = new HashMap<>();

        for (User u : users) {
            String name = u.name;
            for (String email : u.emails) {
                if (storeUniqueEmails.containsKey(email)) {
                    name = storeUniqueEmails.get(email);
                    break;
                }
            }
            for (String email : u.emails) {
                storeUniqueEmails.put(email, name);
            }
            if (mergedUsers.containsKey(name)) {
                mergedUsers.get(name).addAll(u.emails);
            } else {
                mergedUsers.put(name, new LinkedHashSet<>(u.emails));
            }
        }
        return mergedUsers;
    }

    public static class User {

        String name;
        List<String> emails;

        public User(String name, List<String> emails) {
            this.name = name;
            this.emails = emails;
        }
    }

    public static void main(String[] args) {
        List<Email.User> users = new ArrayList<>();
        users.add(new Email.User("user1", Arrays.asList("xxx@ya.ru", "foo@gmail.com", "lol@mail.ru")));
        users.add(new Email.User("user2", Arrays.asList("foo@gmail.com", "ups@pisem.net")));
        users.add(new Email.User("user3", Arrays.asList("xyz@pisem.net", "vasya@pupkin.com")));
        users.add(new Email.User("user4", Arrays.asList("ups@pisem.net", "aaa@bbb.ru")));
        users.add(new Email.User("user5", Arrays.asList("xyz@pisem.net")));
        Map<String, Set<String>> mergedUsers = merge(users);
        System.out.println("mergedUsers: " + mergedUsers);
    }
}
