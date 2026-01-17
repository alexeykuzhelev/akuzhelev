package ru.job4j.ood.srp.report;

import org.junit.jupiter.api.Test;
import ru.job4j.ood.srp.currency.Currency;
import ru.job4j.ood.srp.currency.CurrencyConverter;
import ru.job4j.ood.srp.currency.InMemoryCurrencyConverter;
import ru.job4j.ood.srp.formatter.DateTimeParser;
import ru.job4j.ood.srp.formatter.ReportDateTimeParser;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.MemoryStore;
import ru.job4j.ood.srp.store.Store;

import java.util.Calendar;

import static org.assertj.core.api.Assertions.assertThat;

public class AccountingReportTest {

    @Test
    public void whenAccountingReportGenerated() {
        Store store = new MemoryStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 1000);
        DateTimeParser<Calendar> parser = new ReportDateTimeParser();
        CurrencyConverter converter = new InMemoryCurrencyConverter();

        store.add(worker);

        Report engine = new AccountingReport(store, parser, converter, Currency.RUB, Currency.USD);
        String result = engine.generate(employee -> true);

        System.out.println("=== Accounting Report Test-1 ===");
        System.out.println(result);

        StringBuilder expected = new StringBuilder()
                .append("Name; Hired; Fired; Salary (USD);")
                .append(System.lineSeparator())
                .append(worker.getName()).append(" ")
                .append(parser.parse(worker.getHired())).append(" ")
                .append(parser.parse(worker.getFired())).append(" ")
                .append(converter.convert(Currency.RUB, worker.getSalary(), Currency.USD))
                .append(System.lineSeparator());

        assertThat(result).isEqualTo(expected.toString());
    }

    @Test
    public void whenAccountingReportWithEUR() {
        Store store = new MemoryStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Anna", now, now, 5000);
        DateTimeParser<Calendar> parser = new ReportDateTimeParser();
        CurrencyConverter converter = new InMemoryCurrencyConverter();

        store.add(worker);

        Report engine = new AccountingReport(store, parser, converter, Currency.RUB, Currency.EUR);
        String result = engine.generate(employee -> true);

        System.out.println("=== Accounting Report Test-2 ===");
        System.out.println(result);

        StringBuilder expected = new StringBuilder()
                .append("Name; Hired; Fired; Salary (EUR);")
                .append(System.lineSeparator())
                .append(worker.getName()).append(" ")
                .append(parser.parse(worker.getHired())).append(" ")
                .append(parser.parse(worker.getFired())).append(" ")
                .append(converter.convert(Currency.RUB, worker.getSalary(), Currency.EUR))
                .append(System.lineSeparator());

        assertThat(result).isEqualTo(expected.toString());
    }

    @Test
    public void whenAccountingReportForMultipleEmployeesWithUSD() {
        Store store = new MemoryStore();
        Calendar now = Calendar.getInstance();
        Employee worker1 = new Employee("Ivan", now, now, 1000);
        Employee worker2 = new Employee("Anna", now, now, 2000);
        DateTimeParser<Calendar> parser = new ReportDateTimeParser();
        CurrencyConverter converter = new InMemoryCurrencyConverter();

        store.add(worker1);
        store.add(worker2);

        Report engine = new AccountingReport(store, parser, converter, Currency.RUB, Currency.USD);
        String result = engine.generate(employee -> true);

        System.out.println("=== Accounting Report Test-3 ===");
        System.out.println(result);

        StringBuilder expected = new StringBuilder()
                .append("Name; Hired; Fired; Salary (USD);")
                .append(System.lineSeparator())
                .append(worker1.getName()).append(" ")
                .append(parser.parse(worker1.getHired())).append(" ")
                .append(parser.parse(worker1.getFired())).append(" ")
                .append(converter.convert(Currency.RUB, worker1.getSalary(), Currency.USD))
                .append(System.lineSeparator())
                .append(worker2.getName()).append(" ")
                .append(parser.parse(worker2.getHired())).append(" ")
                .append(parser.parse(worker2.getFired())).append(" ")
                .append(converter.convert(Currency.RUB, worker2.getSalary(), Currency.USD))
                .append(System.lineSeparator());

        assertThat(result).isEqualTo(expected.toString());
    }
}
