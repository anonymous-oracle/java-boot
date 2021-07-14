package com.company;

import java.io.IOException;
import java.net.*;
import java.nio.charset.StandardCharsets;

public class Main {

    public static void main(String[] args) {
        try {
            DatagramSocket datagramSocket = new DatagramSocket(5000);
            String strToClient;
            while (true) {
                byte[] buffer = new byte[64];
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length); // not providing address here so that the received packet from client can set the address field to client's address
                datagramSocket.receive(packet);
                strToClient = new String(buffer).substring(0, packet.getLength());
                System.out.println("CLIENT DATA: "+ strToClient);
                byte[] buffer2 = ("SERVER ECHO: "+strToClient).getBytes();
                InetAddress address = packet.getAddress();
                int port = packet.getPort();
                packet = new DatagramPacket(buffer2, buffer2.length, address, port);
                datagramSocket.send(packet);
            }
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
