package com.company;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketTimeoutException;
import java.util.Scanner;

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

////                CHECKING IF INT TO BYTE CONVERSION AND REVERSE IS CORRECT
//                int i = 0xAABBCCDD;
//                if (i == byteToInt(intToByte(i))) {
//                    System.out.println("success");
//                }

//                send the data length first
                byte[] int_length = intToByte(buffer.length);
                DatagramPacket packet = new DatagramPacket(int_length, int_length.length, address, 5000);
                socket.send(packet);
//  now send the data
                packet = new DatagramPacket(buffer, buffer.length, address, 5000);
                socket.send(packet);


//                first get to know the return data size
                int_length = new byte[4];
                packet = new DatagramPacket(int_length, int_length.length);
                socket.receive(packet);
                int data_length = byteToInt(packet.getData());

//                create a packet for the appropriate data size
                packet = new DatagramPacket(new byte[data_length], data_length);
                socket.receive(packet);
                System.out.println(new String(packet.getData()).substring(0, packet.getLength()));
            } while (!strToServer.equals("exit"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
