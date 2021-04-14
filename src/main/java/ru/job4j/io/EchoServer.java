package ru.job4j.io;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EchoServer {

    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(9000)) {
            while (!server.isClosed()) {
                Socket socket = server.accept();
                try (OutputStream out = socket.getOutputStream();
                     BufferedReader in = new BufferedReader(
                             new InputStreamReader(socket.getInputStream()))) {
                    String str;
                    String response = "";
                    out.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                    while (!(str = in.readLine()).isEmpty()) {
                        if (str.contains("GET /?msg=Exit")) {
                            out.write("Server closed successfully\r\n".getBytes());
                            server.close();
                            return;
                        } else if (str.contains("GET /?msg=Hello")) {
                            response = "Hello";
                        } else if (str.contains("GET /?msg=")) {
                            response = "What";
                        }
                        System.out.println(str);
                    }
                    out.write((response + "\r\n\r\n").getBytes());
                }
            }
        } catch (Exception e) {
            LOG.error("Exception : ", e);
        }
    }
}
