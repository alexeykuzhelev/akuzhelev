package ru.job4j.ood.ocp.violation;

public class EventLogger {

    public void log(String eventType, String message) {

        switch (eventType) {
            case "INFO" -> logToConsole("[INFO] " + message);
            case "WARNING" -> logToConsole("[WARNING] " + message);
            case "ERROR" -> logToConsole("[ERROR] " + message);
            /* Добавление DEBUG, TRACE требует изменения кода, т.к. добавляется новый case */
            default -> throw new IllegalArgumentException("Unknown event type: " + eventType);
        }
    }

    private void logToConsole(String message) {
        System.out.println(message);
    }
}
