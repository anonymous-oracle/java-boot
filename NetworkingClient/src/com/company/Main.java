package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try (Socket socket = new Socket("127.0.0.1", 5000)) {
            BufferedReader readFromServer = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
            PrintWriter writeToServer = new PrintWriter(socket.getOutputStream(), true);

            Scanner scanner = new Scanner(System.in);
            String strToServer;
            String responseFromServer;

            do {
                System.out.println("ENTER STRING TO BE ECHOED: ");
                strToServer = scanner.nextLine();

                writeToServer.println(strToServer); // if strToServer is "exit" then the server will close the connection
                if (!strToServer.equals("exit")) { // exits the echoing till 'exit' is typed
                    responseFromServer = readFromServer.readLine();
                    System.out.println(responseFromServer);
                }

            } while (!strToServer.equals("exit"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
