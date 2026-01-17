package ru.job4j.ood.srp.report;

import org.junit.jupiter.api.Test;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.MemoryStore;
import ru.job4j.ood.srp.store.Store;

import java.util.Calendar;

import static org.assertj.core.api.Assertions.assertThat;

public class HrReportTest {

    @Test
    public void whenHrReportGenerated() {
        Store store = new MemoryStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);

        Report engine = new HrReport(store);
        String result = engine.generate(employee -> true);

        System.out.println("=== HR Report Test-1 ===");
        System.out.println(result);

        StringBuilder expected = new StringBuilder()
                .append("Name; Salary;")
                .append(System.lineSeparator())
                .append(worker.getName()).append(" ")
                .append(worker.getSalary())
                .append(System.lineSeparator());

        assertThat(result).isEqualTo(expected.toString());
    }

    @Test
    public void whenHrReportWithSortedBySalaryDesc() {
        Store store = new MemoryStore();
        Calendar now = Calendar.getInstance();
        Employee worker1 = new Employee("Ivan", now, now, 100);
        Employee worker2 = new Employee("Anna", now, now, 300);
        Employee worker3 = new Employee("Petr", now, now, 200);
        store.add(worker1);
        store.add(worker2);
        store.add(worker3);

        Report engine = new HrReport(store);
        String result = engine.generate(employee -> true);

        System.out.println("=== HR Report Test-2 ===");
        System.out.println(result);

        /* Ожидаем сортировку по убыванию зарплаты */
        StringBuilder expected = new StringBuilder()
                .append("Name; Salary;")
                .append(System.lineSeparator())
                .append(worker2.getName()).append(" ")   /* Anna с зарплатой 300 */
                .append(worker2.getSalary())
                .append(System.lineSeparator())
                .append(worker3.getName()).append(" ")   /* Petr с зарплатой 200 */
                .append(worker3.getSalary())
                .append(System.lineSeparator())
                .append(worker1.getName()).append(" ")   /* Ivan с зарплатой 100 */
                .append(worker1.getSalary())
                .append(System.lineSeparator());

        assertThat(result).isEqualTo(expected.toString());
    }

    @Test
    public void whenHrReportWithFilter() {
        Store store = new MemoryStore();
        Calendar now = Calendar.getInstance();
        Employee worker1 = new Employee("Ivan", now, now, 100);
        Employee worker2 = new Employee("Anna", now, now, 200);

        store.add(worker1);
        store.add(worker2);

        Report engine = new HrReport(store);
        String result = engine.generate(employee -> employee.getSalary() >= 150);

        System.out.println("=== HR Report Test-3 ===");
        System.out.println(result);

        /* Только сотрудники с зарплатой >= 150 */
        StringBuilder expected = new StringBuilder()
                .append("Name; Salary;")
                .append(System.lineSeparator())
                .append(worker2.getName()).append(" ")   /* Anna с зарплатой 200 */
                .append(worker2.getSalary())
                .append(System.lineSeparator());

        assertThat(result).isEqualTo(expected.toString());
    }

    @Test
    public void whenHrReportGeneratedForMultipleEmployeesWithEqualSalaries() {
        Store store = new MemoryStore();
        Calendar now = Calendar.getInstance();
        Employee worker1 = new Employee("Ivan", now, now, 100);
        Employee worker2 = new Employee("Anna", now, now, 100);

        store.add(worker1);
        store.add(worker2);

        Report engine = new HrReport(store);
        String result = engine.generate(employee -> true);

        System.out.println("=== HR Report Test-4 ===");
        System.out.println(result);

        /* При одинаковых зарплатах сохраняется порядок добавления */
        StringBuilder expected = new StringBuilder()
                .append("Name; Salary;")
                .append(System.lineSeparator())
                .append(worker1.getName()).append(" ")
                .append(worker1.getSalary())
                .append(System.lineSeparator())
                .append(worker2.getName()).append(" ")
                .append(worker2.getSalary())
                .append(System.lineSeparator());

        assertThat(result).isEqualTo(expected.toString());
    }
}
