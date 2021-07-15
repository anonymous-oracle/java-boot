package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

public class Main3 {

    public static void main(String[] args) throws URISyntaxException, IOException {
        URL url = new URL("http://example.org");
        URLConnection urlConnection = url.openConnection(); // returns a connection instance used to configure the connection
//        BY DEFAULT WE CAN ONLY READ FROM A CONNECTION, SO WE CAN SET THE CONNECTION TO WRITE TO THE STREAM AS WELL
        urlConnection.setDoOutput(true);
//        NOTE: ALL CONFIGURATIONS LIKE THE ABOVE SHOULD END BEFORE CALLING THE .connect() call
        urlConnection.connect(); // actually connects to the URL when .connect() is called
        BufferedReader inputStream = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));

        Map<String, List<String>> headerFields = urlConnection.getHeaderFields();

        headerFields.forEach((key, value) -> {
//            System.out.println("KEY: "+key);
            value.forEach((val) -> {
                System.out.println("KEY: " + key + " | VALUE: " + val);
            });
        });

//        String line = "";
//        while (true) {
//            line = inputStream.readLine();
//            if (line == null) {
//                break;
//            }
//            System.out.println(line);
//        }
//        inputStream.close();


    }
}
