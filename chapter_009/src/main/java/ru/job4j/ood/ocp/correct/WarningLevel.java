package ru.job4j.ood.ocp.correct;

public class WarningLevel implements LogLevel {

    @Override
    public void log(String message) {
        System.out.println("[WARNING] " + message);
    }
}
