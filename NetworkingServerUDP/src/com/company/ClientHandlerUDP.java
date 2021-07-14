package com.company;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class ClientHandlerUDP extends Thread {
    private DatagramSocket socket;

    public ClientHandlerUDP(DatagramSocket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            byte[] buffer = new byte[64];
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
            String strFromClient;
            while (true) {
                this.socket.receive(packet);
                strFromClient = new String(packet.getData());
                if (strFromClient.equals("exit")) {
                    break;
                }
                System.out.println("CLIENT (" + currentThread().getName() + ") RESPONSE: " + strFromClient);
            }
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
