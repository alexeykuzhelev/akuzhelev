package ru.job4j.io;

import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/*
  @author Alexey Kuzhelev (aleks2kv1977@gmail.com)
 * @version $Id$
 * @since 23.06.2021
 */

/**
 * Класс реализует 'Консольный чат'.
 * Указывается, какую кодировку использовать для чтения и записи файла.
 * Пользователь вводит слово-фразу, программа берет случайную фразу
 * из текстового файла и выводит в ответ.
 * Программа замолкает если пользователь вводит слово «стоп»,
 * при этом он может продолжать отправлять сообщения в чат.
 * Если пользователь вводит слово «продолжить», программа снова начинает отвечать.
 * При вводе слова «закончить» программа прекращает работу.
 * Запись диалога, включая слова-команды стоп/продолжить/закончить пишуться в текстовый лог.
 */
public class ConsoleChat {
    private final String path;
    private final String botAnswers;
    private static final String OUT = "закончить";
    private static final String STOP = "стоп";
    private static final String CONTINUE = "продолжить";

    public ConsoleChat(String path, String botAnswers) {
        this.path = path;
        this.botAnswers = botAnswers;
    }

    /**
     * Метод реализует логику работы консольного чата.
     */
    public void run() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String inputLine = "";
            String answerBot;
            StringBuilder dialogText = new StringBuilder();
            boolean botAnswerMessage = true;
            List<String> answersList = getAnswersList();
            while (!(OUT.equals(inputLine))) {
                inputLine = br.readLine();
                dialogText.append(
                        String.format("User: %s%s", inputLine, System.lineSeparator())
                );
                if (STOP.equals(inputLine)) {
                    botAnswerMessage = false;
                }
                if (OUT.equals(inputLine) || CONTINUE.equals(inputLine)) {
                    botAnswerMessage = true;
                } else if (botAnswerMessage) {
                    int i = new Random().nextInt(answersList.size());
                    answerBot = String.format(
                            "Bot: %s%s", answersList.get(i), System.lineSeparator()
                    );
                    dialogText.append(answerBot);
                    System.out.println(answerBot);
                }
            }
            writeDataInFile(dialogText.toString());
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    /**
     * Метод читает файл с фразами в список.
     */
    public List<String> getAnswersList() {
        List<String> list = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(botAnswers), Charset.forName("WINDOWS-1251")))
        ) {
            br.lines().forEach(list::add);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return list;
    }

    /**
     * Метод записывает диалог между ботом и пользователем в файд.
     */
    private void writeDataInFile(String dialogText) {
        try (BufferedWriter bw = new BufferedWriter(
                new OutputStreamWriter(
                        new FileOutputStream(path), Charset.forName("WINDOWS-1251")))
        ) {
            bw.write(dialogText);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public static void main(String[] args) {
        System.out.println(String.format("Возможны следующие дейтсвия:\n"
                + "1. Бот перестанет отвечать, введите: %s |\n"
                + "2. Бот возобновит работу, введите: %s |\n"
                + "3. Закончить работу с чатом, введите: %s |\n", STOP, CONTINUE, OUT));
        ConsoleChat cc = new ConsoleChat(
                "chapter_006/src/data/botDialog.txt",
                "chapter_006/src/data/botAnswers.txt"
        );
        cc.run();
    }
}
