package com.company;

import com.company.model.Artist;
import com.company.model.Datasource;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        Datasource datasource = new Datasource();
        if (!datasource.open()) {
            System.out.println("Cannot open datasource");
            return;
        }
        List<Artist> artists = datasource.queryArtists();
        if (artists == null) {
            System.out.println("No artists!");
            return;
        }
        for (Artist artist : artists) {
            System.out.println("ID = " + artist.getId() + ", Name = " + artist.getName());
        }

        System.out.println("***********************************");
        List<String> albumsForAtrists = datasource.queryAlbumsForArtist("Iron Maiden", Datasource.ORDER_BY_ASC);
        for (String album : albumsForAtrists) {
            System.out.println("Album: " + album);
        }

        datasource.close();
    }
}
