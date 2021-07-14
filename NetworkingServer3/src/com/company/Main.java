package com.company;

import java.io.IOException;
import java.net.ServerSocket;

public class Main {

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(5000)) { // port number is 5000

            while (true) {
//                Socket socket = serverSocket.accept();
//                EchoingServer echoingServer = new EchoingServer(socket);
//                echoingServer.start();
                new EchoingServer(serverSocket.accept()).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
