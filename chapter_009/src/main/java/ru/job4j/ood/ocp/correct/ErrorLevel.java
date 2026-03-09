package ru.job4j.ood.ocp.correct;

public class ErrorLevel implements LogLevel {

    @Override
    public void log(String message) {
        System.out.println("[ERROR] " + message);
    }
}
