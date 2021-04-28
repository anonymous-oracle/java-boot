import java.util.ArrayList;

public class Album {
    private String name;
    private SongList songList;

    public Album(String name) {
        this.name = name;
        this.songList = new SongList();
    }

    public String getName() {
        return this.name;
    }

    public boolean addSong(String songName) {
        return this.songList.addSong(songName);
    }

    public String getSong(String songName) {
        return this.songList.getSong(songName);
    }

    private class SongList {
        private ArrayList<String> songs;

        private SongList() {
            this.songs = new ArrayList<String>();
        }

        private String getSong(String songName) {
            String searchSong;
            for (int i = 0; i < this.songs.size(); i++) {
                searchSong = this.songs.get(i);
                if (searchSong.equals(songName)) {
                    return this.songs.get(i);
                }
            }
            return null;
        }

        public boolean addSong(String songName) {
            if (this.getSong(songName) == null) {
                this.songs.add(songName);
                return true;
            }
            return false;
        }
    }
}
