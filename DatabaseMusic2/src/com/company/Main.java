package com.company;

import com.company.model.Artist;
import com.company.model.Datasource;
import com.company.model.SongArtist;

import java.sql.SQLException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws SQLException {
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
        List<String> albumsForAtrists = datasource.queryAlbumsForArtist("Pink Floyd", Datasource.ORDER_BY_ASC);
        for (String album : albumsForAtrists) {
            System.out.println("Album: " + album);
        }

        List<SongArtist> songArtists = datasource.queryArtistsForSong("Heartless", Datasource.ORDER_BY_ASC);
        if (songArtists == null) {
            System.out.println("Could not find the artist for the song");
            return;
        }
        for (SongArtist artist : songArtists) {
            System.out.println("Artist name = " + artist.getArtistName() +
                    " Album name = " + artist.getAlbumName() +
                    " Track = " + artist.getTrack());
        }
        System.out.println("***************************");
        datasource.querySongsMetaData();
        datasource.close();
    }
}
