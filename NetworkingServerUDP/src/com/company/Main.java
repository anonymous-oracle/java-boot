package com.company;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class Main {

    public static byte[] intToByte(int i) {
        byte[] result = new byte[4];

        result[0] = (byte) (i >> 24);
        result[1] = (byte) (i >> 16);
        result[2] = (byte) (i >> 8);
        result[3] = (byte) i;

        return result;
    }

    private static int byteToInt(byte[] bytes) {
        int i = 0;
        i = i | ((bytes[0] << 24) & 0xff000000);
        i = i | ((bytes[1] << 16) & 0x00ff0000);
        i = i | ((bytes[2] << 8) & 0x0000ff00);
        i = i | ((bytes[3]) & 0x000000ff);


        return i;
    }

    public static void main(String[] args) {
        try {
            DatagramSocket datagramSocket = new DatagramSocket(5000);
            String strToClient;
            while (true) {
// first get to know the data size
                DatagramPacket packet = new DatagramPacket(new byte[4], 4);
                datagramSocket.receive(packet);
                int incomingDataLength = byteToInt(packet.getData());

                packet = new DatagramPacket(new byte[incomingDataLength],incomingDataLength); // not providing address here so that the received packet from client can set the address field to client's address
                datagramSocket.receive(packet);
                strToClient = new String(packet.getData()).substring(0, packet.getLength());
                System.out.println("CLIENT DATA: " + strToClient);
                byte[] buffer2 = ("SERVER ECHO: " + strToClient).getBytes();
                InetAddress address = packet.getAddress();
                int port = packet.getPort();

                byte[] outgoingDataLength = intToByte(buffer2.length);
                datagramSocket.send(new DatagramPacket(outgoingDataLength, outgoingDataLength.length, address, port));
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
