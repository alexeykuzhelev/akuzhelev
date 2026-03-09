package ru.job4j.ood.ocp.correct;

/**
 * Логгер не нужно менять при добавлении новых уровней логирования,
 * т.к. вызывается метод log в том классе, на который ссылается параметр level с интерфейсным типом
 */
public class EventLogger {

    public void log(LogLevel level, String message) {
        level.log(message);
    }
}
