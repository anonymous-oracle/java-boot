package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;
import java.util.Map;

public class Main4 {

    public static void main(String[] args) throws URISyntaxException, IOException {
        URL url = new URL("http://example.org");
//        URL url = new URL("http://example2.org"); // fake page to check if the response code was got
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection(); // returns a connection instance used to configure the connection
        urlConnection.setRequestMethod("GET"); // HttpURLConnection method can only be used once for a request
        urlConnection.setRequestProperty("User-Agent", "Mozilla");

//        THE .connect() WAS NOT CALLED, BUT FOR THE .getResponseCode() FUNCTION THE .connect() WOULD BE CALLED UNDER THE HOOD
        int responseCode = urlConnection.getResponseCode();
        System.out.println("Response code: " + responseCode);
        urlConnection.setReadTimeout(5000); // time out if the request was not processed in time
        if (responseCode != 200) {
            System.out.println("Error reading the web page");
            return;
        }



        BufferedReader inputStream = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));

        String line = "";
        while ((line = inputStream.readLine()) != null) {
            System.out.println(line);
        }






        inputStream.close();


    }
}
