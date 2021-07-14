package com.company;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketTimeoutException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws SocketTimeoutException {
        try {
            InetAddress address = InetAddress.getLocalHost(); // destination host
            DatagramSocket socket = new DatagramSocket();

//            socket.setSoTimeout(3000);
            Scanner scanner = new Scanner(System.in);
            String strToServer;
            do {
                System.out.println("Enter data to be sent to server: ");
                strToServer = scanner.nextLine();
                byte[] buffer = strToServer.getBytes();
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length, address, 5000);
                socket.send(packet);
                byte[] buffer2 = new byte[64];
                packet = new DatagramPacket(buffer2, buffer2.length);
                socket.receive(packet);
//                while (packet.getLength() >= buffer2.length) {
//                    System.out.print(new String(buffer2));
//                    socket.receive(packet);
//                }
                System.out.println(new String(buffer2).substring(0, packet.getLength()));
            } while (!strToServer.equals("exit"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
