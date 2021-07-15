package com.company;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;

public class Server {

    public static void main(String[] args) throws URISyntaxException, MalformedURLException {
//        URI uri = new URI("db://username:password@myserver.com:5000/catalogue/phones?os=android#samsung"); // will give out a malformed url
        URI uri = new URI("http://username:password@myserver.com:5000/catalogue/phones?os=android#samsung");
        URI baseURI = new URI("http://username:password@myserver.com:5000");
        URI relativeURI = new URI("/catalogue/phones?os=android#samsung");
        URI resolvedURI = baseURI.resolve(relativeURI);

        System.out.println("Scheme = " + uri.getScheme());
        System.out.println("Scheme-specific part = " + uri.getSchemeSpecificPart());
        System.out.println("Authority = " + uri.getAuthority());
        System.out.println("User info = " + uri.getUserInfo());
        System.out.println("Host = " + uri.getHost());
        System.out.println("Port = " + uri.getPort());
        System.out.println("Path = " + uri.getPath());
        System.out.println("Query = " + uri.getQuery());
        System.out.println("Fragment = " + uri.getFragment());
// URI's CAN BE RELATIVE BUT URL's HAVE TO BE ABSOLUTE
        System.out.println("URL = " + uri.toURL());
        System.out.println("Resolved URI = " + resolvedURI.toURL());
    }
}
