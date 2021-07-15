package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class Main {

    public static void main(String[] args) throws URISyntaxException, IOException {
        URL url = new URL("http://example.org");
        URI uri = url.toURI();

//        System.out.println("Scheme = " + uri.getScheme());
//        System.out.println("Scheme-specific part = " + uri.getSchemeSpecificPart());
//        System.out.println("Authority = " + uri.getAuthority());
//        System.out.println("User info = " + uri.getUserInfo());
//        System.out.println("Host = " + uri.getHost());
//        System.out.println("Port = " + uri.getPort());
//        System.out.println("Path = " + uri.getPath());
//        System.out.println("Query = " + uri.getQuery());
//        System.out.println("Fragment = " + uri.getFragment());

        BufferedReader inputStream = new BufferedReader(new InputStreamReader(url.openStream()));
        String line = "";
        while (true) {
            line = inputStream.readLine();
            if (line == null) {
                break;
            }
            System.out.println(line);
        }
        inputStream.close();
    }
}
