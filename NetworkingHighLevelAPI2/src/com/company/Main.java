package com.company;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class Main {

    public static void main(String[] args) throws URISyntaxException, MalformedURLException {
//        URI uri = new URI("db://username:password@myserver.com:5000/catalogue/phones?os=android#samsung"); // will give out a malformed url
//        URI baseUri = new URI("http://username:password@myserver.com:5000");
        URI baseUri = new URI("http://username:password@my_newserver.com:5000"); // just changing the base URI is enough to reflect upon resolved URI's
        URI uri1 = new URI("/catalogue/phones?os=android#samsung");
        URI uri2 = new URI("/catalogue/tvs?manufacturer=samsung");
        URI uri3 = new URI("/stores/location?zip=12345");

        URI resolvedUri1 = baseUri.resolve(uri1);
        URI resolvedUri2 = baseUri.resolve(uri2);
        URI resolvedUri3 = baseUri.resolve(uri3);

        URL url1 = resolvedUri1.toURL();
        System.out.println("URL 1 = " + url1);
        URL url2 = resolvedUri2.toURL();
        System.out.println("URL 2 = " + url2);
        URL url3 = resolvedUri3.toURL();
        System.out.println("URL 3 = " + url3);


        System.out.println("Relativised URI = " + baseUri.relativize(resolvedUri3));
    }
}
