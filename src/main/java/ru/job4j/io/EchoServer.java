package ru.job4j.io;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
    public static void main(String[] args) throws IOException {
        try (ServerSocket server = new ServerSocket(9000)) {
            while (!server.isClosed()) {
                Socket socket = server.accept();
                try (OutputStream out = socket.getOutputStream();
                     BufferedReader in = new BufferedReader(
                             new InputStreamReader(socket.getInputStream()))) {
                    String str;
                    String response = "";
                    while (!(str = in.readLine()).isEmpty()) {
                        if (str.contains("GET /?msg=Exit")) {
                            server.close();
                            out.write("Server closed successfully\r\n".getBytes());
                            return;
                        } else if (str.contains("GET /?msg=Hello")) {
                            response = "Hello";
                        } else if (str.contains("GET /?msg=")) {
                            response = "What";
                        }
                        System.out.println(str);
                    }
                    out.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                    out.write((response + "\r\n\r\n").getBytes());
                }
            }
        }
    }
}
