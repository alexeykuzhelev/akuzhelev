package ru.job4j.io;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*
  @author Alexey Kuzhelev (aleks2kv1977@gmail.com)
 * @version $Id$
 * @since 03.10.2021
 */

/**
 * Класс реализует обмен сообщениями через класс Socket.
 * В качестве клиента используется Браузер.
 * Класс ServerSocket создает сервер.
 * Если клиент отправляет запрос с параметром msg=Exit, нужно завершить работу сервера.
 * Если клиент отправляет запрос с параметром msg=Hello, ответ будет: Hello, dear friend.
 * Если клиент отправляет запрос с любым другим параметром msg, в ответ отправлять текст запроса.
 * Добавлена обработка исключения через catch c выводом в логгер.
 */
public class EchoServer {
    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(9000)) {
            while (!server.isClosed()) {
                Socket socket = server.accept();
                try (OutputStream out = socket.getOutputStream();
                     BufferedReader in = new BufferedReader(
                         new InputStreamReader(socket.getInputStream()))) {
                    System.out.println();
                    out.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                    for (String str = in.readLine(); str != null && !str.isEmpty(); str = in.readLine()) {
                        String[] strings = str.replaceAll("=", " ").split(" ");
                        if (str.contains("msg") && str.contains("Exit")) {
                            socket.close();
                            System.out.println("Сокет закрыт");
                            System.out.println();
                        } else if (str.contains("msg") && str.contains("Hello")) {
                            out.write("Hello, dear friend.".getBytes());
                        } else if (str.contains("msg") && !str.contains("Exit") && !str.contains("Hello")) {
                            out.write((strings[2] + "\r\n\r\n").getBytes());
                        }
                        System.out.println(str);
                        out.flush();
                    }
                }
            }
        } catch (Exception e) {
            LOG.error("Exception in log example", e);
        }
    }
}
