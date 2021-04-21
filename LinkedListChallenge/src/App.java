import java.util.LinkedList;

public class App {
    public static void main(String[] args) {
        MusicPlayer player = new MusicPlayer();
        player.addAlbum("Album 1");
        player.addAlbum("Album 2");
        player.addAlbum("Album 3");
        player.addAlbum("Album 4");
        player.addSongToAlbum("Album 1", "Album 1 - Song 1");
        player.addSongToAlbum("Album 1", "Album 1 - Song 2");

        player.addSongToAlbum("Album 2", "Album 2 - Song 1");
        player.addSongToAlbum("Album 2", "Album 2 - Song 2");

        player.addSongToAlbum("Album 3", "Album 3 - Song 1");
        player.addSongToAlbum("Album 3", "Album 3 - Song 2");

        player.addSongToAlbum("Album 4", "Album 4 - Song 1");
        player.addSongToAlbum("Album 4", "Album 4 - Song 2");

        player.addSongToPlaylist("Album 1 - Song 2");
        player.addSongToPlaylist("Album 2 - Song 1");
        player.addSongToPlaylist("Album 4 - Song 1");
        player.addSongToPlaylist("Album 3 - Song 2");

        player.playFromPlaylist();

    }
}
