package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(5000)) { // port number is 5000
            while (true) { // comment when testing with single client
                Socket socket = serverSocket.accept(); // this socket is used to communicate with the client socket over the same port
//            THE accept() METHOD BLOCKS UNTIL A CLIENT CONNECTS TO THE SERVER
            System.out.println("Client Connected");

            BufferedReader readFromClient = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
            PrintWriter writeToClient = new PrintWriter(socket.getOutputStream(), true); //

            System.out.println("LISTENING...");
//            while (true) { // uncomment for testing with single client
                String strFromClient = readFromClient.readLine();
                if (strFromClient.equals("exit")) {
                    break;
                }
                writeToClient.println("Echo from server: " + strFromClient);
            }
            System.out.println("FINISHED");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
