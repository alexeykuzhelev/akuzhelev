package ru.job4j.io;

import java.io.*;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/*
  @author Alexey Kuzhelev (aleks2kv1977@gmail.com)
 * @version $Id$
 * @since 21.06.2021
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
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(
                     new OutputStreamWriter(
                             new FileOutputStream(path), Charset.forName("WINDOWS-1251")))
        ) {
            String inputLine = "";
            String answerBot;
            StringBuilder dialogText;
            boolean botAnswerMessage = true;
            while (!(OUT.equals(inputLine))) {
                inputLine = br.readLine();
                dialogText = new StringBuilder(
                        String.format("User: %s%s", inputLine, System.lineSeparator())
                );
                if (STOP.equals(inputLine)) {
                    botAnswerMessage = false;
                }
                if (OUT.equals(inputLine) || CONTINUE.equals(inputLine)) {
                    botAnswerMessage = true;
                } else if (botAnswerMessage) {
                    answerBot = String.format("Bot: %s%s", getAnswerBot(), System.lineSeparator());
                    dialogText.append(answerBot);
                    System.out.println(answerBot);
                }
                bw.write(dialogText.toString());
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    /**
     * Метод берет случайную фразу из текстового файла и выводит в ответ.
     */
    public String getAnswerBot() {
        List<String> list;
        String answer = "";
        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(botAnswers), Charset.forName("WINDOWS-1251")))
        ) {
            list = br.lines().collect(Collectors.toList());
            int i = new Random().nextInt(list.size());
            answer = list.get(i);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return answer;
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
