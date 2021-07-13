package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class EchoingServer extends Thread {
    private Socket socket;

    public EchoingServer(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            System.out.println("CLIENT THREAD ID: " + Thread.currentThread().getName() + " is connected. Listening...");
            BufferedReader readFromClient = new BufferedReader(
                    new InputStreamReader(this.socket.getInputStream()));
            PrintWriter writeToClient = new PrintWriter(this.socket.getOutputStream(), true);

            while (true) {
                String strFromClient = readFromClient.readLine();
                System.out.println("CLIENT INPUT: " + strFromClient);
                if (strFromClient.equals("exit")) {
                    break;
                }
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    System.out.println(currentThread().getName() + " INTERRUPTED");
                    e.printStackTrace();
                }
                writeToClient.println("SERVER ECHO: " + strFromClient);
            }
        } catch (IOException e) {
            System.out.println("Well that's unexpected: " + e.getMessage());
        } finally {
            try {
                this.socket.close();
            } catch (Exception e) {
//  nothing to do here
            }
        }
    }
}
