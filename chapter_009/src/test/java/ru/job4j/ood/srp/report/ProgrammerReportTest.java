package ru.job4j.ood.srp.report;

import org.junit.jupiter.api.Test;
import ru.job4j.ood.srp.formatter.DateTimeParser;
import ru.job4j.ood.srp.formatter.ReportDateTimeParser;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.MemoryStore;
import ru.job4j.ood.srp.store.Store;

import java.util.Calendar;

import static org.assertj.core.api.Assertions.assertThat;

public class ProgrammerReportTest {

    @Test
    public void whenProgrammerReportGenerated() {
        Store store = new MemoryStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        DateTimeParser<Calendar> parser = new ReportDateTimeParser();

        store.add(worker);

        Report engine = new ProgrammerReport(store, parser);
        String result = engine.generate(employee -> true);

        System.out.println("=== Programmer Report Test-1 ===");
        System.out.println(result);

        StringBuilder expected = new StringBuilder()
                .append("Name,Hired,Fired,Salary")
                .append(System.lineSeparator())
                .append(worker.getName()).append(",")
                .append(parser.parse(worker.getHired())).append(",")
                .append(parser.parse(worker.getFired())).append(",")
                .append(worker.getSalary())
                .append(System.lineSeparator());

        assertThat(result).isEqualTo(expected.toString());
    }

    @Test
    public void whenProgrammerReportForMultipleEmployees() {
        Store store = new MemoryStore();
        Calendar now = Calendar.getInstance();
        Employee worker1 = new Employee("Ivan", now, now, 100);
        Employee worker2 = new Employee("Anna", now, now, 200);
        DateTimeParser<Calendar> parser = new ReportDateTimeParser();

        store.add(worker1);
        store.add(worker2);

        Report engine = new ProgrammerReport(store, parser);
        String result = engine.generate(employee -> true);

        System.out.println("=== Programmer Report Test-2 ===");
        System.out.println(result);

        StringBuilder expected = new StringBuilder()
                .append("Name,Hired,Fired,Salary")
                .append(System.lineSeparator())
                .append(worker1.getName()).append(",")
                .append(parser.parse(worker1.getHired())).append(",")
                .append(parser.parse(worker1.getFired())).append(",")
                .append(worker1.getSalary())
                .append(System.lineSeparator())
                .append(worker2.getName()).append(",")
                .append(parser.parse(worker2.getHired())).append(",")
                .append(parser.parse(worker2.getFired())).append(",")
                .append(worker2.getSalary())
                .append(System.lineSeparator());

        assertThat(result).isEqualTo(expected.toString());
    }

    @Test
    public void whenProgrammerReportWithFilter() {
        Store store = new MemoryStore();
        Calendar now = Calendar.getInstance();
        Employee worker1 = new Employee("Ivan", now, now, 100);
        Employee worker2 = new Employee("Anna", now, now, 200);
        DateTimeParser<Calendar> parser = new ReportDateTimeParser();

        store.add(worker1);
        store.add(worker2);

        Report engine = new ProgrammerReport(store, parser);
        String result = engine.generate(employee -> employee.getSalary() > 150);

        System.out.println("=== Programmer Report Test-3 ===");
        System.out.println(result);

        /* Только сотрудники с зарплатой > 150 */
        StringBuilder expected = new StringBuilder()
                .append("Name,Hired,Fired,Salary")
                .append(System.lineSeparator())
                .append(worker2.getName()).append(",")
                .append(parser.parse(worker2.getHired())).append(",")
                .append(parser.parse(worker2.getFired())).append(",")
                .append(worker2.getSalary())
                .append(System.lineSeparator());

        assertThat(result).isEqualTo(expected.toString());
    }

    @Test
    public void whenProgrammerReportWithEmptyStore() {
        Store store = new MemoryStore();
        DateTimeParser<Calendar> parser = new ReportDateTimeParser();

        Report engine = new ProgrammerReport(store, parser);
        String result = engine.generate(employee -> true);

        System.out.println("=== Programmer Report Test-4 ===");
        System.out.println(result);

        StringBuilder expected = new StringBuilder()
                .append("Name,Hired,Fired,Salary")
                .append(System.lineSeparator());

        assertThat(result).isEqualTo(expected.toString());
    }
}
