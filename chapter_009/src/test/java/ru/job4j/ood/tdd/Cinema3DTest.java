package ru.job4j.ood.tdd;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

import java.util.Calendar;
import java.util.List;

@Disabled("Тесты отключены. Удалить аннотацию после реализации всех методов по заданию.")
public class Cinema3DTest {
    @Test
    public void whenBuyThenGetTicket() {
        Account account = new AccountCinema();
        Cinema cinema = new Cinema3D();
        Calendar date = Calendar.getInstance();
        Ticket ticket = cinema.buy(account, 1, 1, date);
        assertThat(ticket).isEqualTo(new Ticket3D());
    }

    @Test
    public void whenAddSessionThenItExistsBetweenAllSessions() {
        Cinema cinema = new Cinema3D();
        Session session = new Session3D();
        cinema.add(session);
        List<Session> sessions = cinema.find(data -> true);
        assertThat(sessions).contains(session);
    }

    @Test
    public void whenBuyOnInvalidRowThenGetException() {
        Account account = new AccountCinema();
        Cinema cinema = new Cinema3D();
        Calendar date = Calendar.getInstance();
        assertThatThrownBy(() -> cinema.buy(account, -1, 1, date))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void whenBuyOnInvalidSessionThenGetException() {
        Account account = new AccountCinema();
        Cinema cinema = new Cinema3D(); /* Сеансы не добавлены! */
        Calendar date = Calendar.getInstance();
        /* Пытаемся купить билет в пустом кинотеатре */
        assertThatThrownBy(() -> cinema.buy(account, 1, 2, date))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void whenBuyOnOccupiedSeatThenGetException() {
        Account account = new AccountCinema();
        Cinema cinema = new Cinema3D();
        Session session = new Session3D();
        cinema.add(session);
        Calendar date = Calendar.getInstance();
        /* Первая покупка — успешна */
        cinema.buy(account, 1, 1, date);
        /* Вторая покупка на то же место и дату — должна вызвать исключение */
        assertThatThrownBy(() -> cinema.buy(account, 1, 1, date))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void whenFindByPredicateThenFound() {
        Cinema cinema = new Cinema3D();
        Session session = new Session3D();
        cinema.add(session);
        /* Ищем добавленный сеанс (должен найтись) */
        List<Session> foundSessions = cinema.find(s -> true);
        assertThat(foundSessions).contains(session);
    }

    @Test
    public void whenFindByPredicateThenNotFound() {
        Cinema cinema = new Cinema3D();
        Session session = new Session3D();
        cinema.add(session);
        /* Ищем по такому предикату, что ничего не найдется - должен вернуться пустой список */
        List<Session> foundSessions = cinema.find(s -> false);
        assertThat(foundSessions).isEmpty();
    }

}
