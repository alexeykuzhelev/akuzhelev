package ru.job4j.ood.ocp.correct;

/**
 * Новый уровень логирования - создаем новый класс, не трогая существующий код
 */
public class DebugLevel implements LogLevel {

    @Override
    public void log(String message) {
        System.out.println("[DEBUG] " + message);
    }
}
