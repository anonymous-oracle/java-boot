import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class MusicPlayer {
    private ArrayList<Album> albums;
    private LinkedList<String> playlist;

    public MusicPlayer() {
        this.albums = new ArrayList<Album>();
        this.playlist = new LinkedList<String>();
    }

    public ArrayList<Album> getAlbums() {
        return this.albums;
    }

    private Album getAlbum(String albumName) {
        for (int i = 0; i < this.albums.size(); i++) {
            if (this.albums.get(i).getName().equals(albumName)) {
                return this.albums.get(i);
            }
        }
        return null;
    }

    private boolean hasAlbum(String albumName) {
        for (int i = 0; i < this.albums.size(); i++) {
            if (this.albums.get(i).getName().equals(albumName)) {
                return true;
            }
        }
        return false;
    }

    public boolean addSongToAlbum(String albumName, String songName) {
        Album album = this.getAlbum(albumName);
        if (album != null) {
            if (!album.hasSong(songName)) {
                album.addSong(songName);
                return true;
            }
        }
        return false;
    }

    public boolean addAlbum(String albumName) {
        if (!this.hasAlbum(albumName)) {
            this.albums.add(new Album(albumName));
            return true;
        }
        return false;
    }

    public boolean removeSongFromPlaylist(String songName) {
        for (int i = 0; i < this.playlist.size(); i++) {
            if (this.playlist.get(i).equals(songName)) {
                this.playlist.remove(i);
                return true;
            }
        }
        return false;
    }

    private boolean playlistHasSong(String songName) {
        for (int i = 0; i < this.playlist.size(); i++) {
            if (this.playlist.get(i).equals(songName)) {
                return true;
            }
        }
        return false;
    }

    public boolean addSongToPlaylist(String songName) {
        Album album;
        for (int i = 0; i < this.albums.size(); i++) {
            album = this.albums.get(i);
            if (album.hasSong(songName)) {
                if (!this.playlistHasSong(songName)) {
                    this.playlist.add(songName);
                    return true;
                }
            }
        }
        return false;
    }

    public void printActions() {
        System.out.println("Available options:\npress\n" + "0 - list options\n" + "1 - play next song\n"
                + "2 - play previous song\n" + "3 - replay current song\n" + "4 - quit music player\n"
                + "5 - repeat playlist\n");
    }

    public void playFromPlaylist() {
        int action;
        String song;
        boolean quit = false;
        boolean movingForward = true;
        Scanner scanner = new Scanner(System.in);
        ListIterator<String> iter = this.playlist.listIterator();
        this.printActions();
        if (this.playlist.isEmpty()) {
            System.out.println("No songs added to playlist");
            return;
        } else {
            song = iter.next();
            System.out.println("Playing now: " + song);
        }
        while (!quit) {

            action = scanner.nextInt();
            scanner.nextLine();
            switch (action) {
            case 0:
                this.printActions();
                break;
            case 1:
                if ((!movingForward) && iter.hasNext()) {
                    movingForward = true;
                    iter.next();
                }
                if (iter.hasNext()) {
                    song = iter.next();
                    System.out.println("Playing now: " + song);
                } else if (!iter.hasNext()) {
                    System.out.println("Playlist ended. Press 5 to restart");
                }
                break;
            case 2:
                if (movingForward && iter.hasPrevious()) {
                    movingForward = false;
                    iter.previous();
                }
                if (iter.hasPrevious()) {
                    song = iter.previous();
                    System.out.println("Playing now: " + song);
                } else if (!iter.hasPrevious()) {
                    System.out.println("Playlist ended. Press 5 to restart");
                }
                break;
            case 3:
                if (iter.hasPrevious()) {
                    iter.previous();
                    song = iter.next();
                }
                System.out.println("Playing now: " + song);
                break;
            case 4:
                quit = true;
                break;
            case 5:
                iter = this.playlist.listIterator();
                System.out.println("Playlist restarted. Playing now: " + this.playlist.get(iter.nextIndex()));
                break;
            }
        }
    }
}
