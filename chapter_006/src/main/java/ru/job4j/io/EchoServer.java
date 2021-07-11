package ru.job4j.io;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/*
  @author Alexey Kuzhelev (aleks2kv1977@gmail.com)
 * @version $Id$
 * @since 11.07.2021
 */

/**
 * Класс реализует обмен сообщениями через класс Socket.
 * В качестве клиента используется программа cURL.
 * Класс ServerSocket создает сервер.
 * Если клиент отправляет запрос с параметром msg=Bye, нужно завершить работу сервера.
 */
public class EchoServer {
    public static void main(String[] args) throws IOException {
        try (ServerSocket server = new ServerSocket(9000)) {
            while (!server.isClosed()) {
                Socket socket = server.accept();
                try (OutputStream out = socket.getOutputStream();
                     BufferedReader in = new BufferedReader(
                             new InputStreamReader(socket.getInputStream()))) {
                    System.out.println();
                    for (String str = in.readLine(); str != null && !str.isEmpty(); str = in.readLine()) {
                        String[] strings = str.replaceAll("=", " ").split(" ");
                        if (str.contains("msg") && str.contains("Bye")) {
                            socket.close();
                            System.out.println("Сокет закрыт");
                            System.out.println();
                        } else if (str.contains("msg") && !str.contains("Bye")) {
                            out.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                            out.write((strings[2] + "\r\n\r\n").getBytes());
                        }
                        System.out.println(str);
                        out.flush();
                    }
                }
            }
        }
    }
}
