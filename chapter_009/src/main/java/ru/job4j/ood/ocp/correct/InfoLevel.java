package ru.job4j.ood.ocp.correct;

public class InfoLevel implements LogLevel {

    @Override
    public void log(String message) {
        System.out.println("[INFO] " + message);
    }
}
