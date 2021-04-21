import java.util.ArrayList;

public class Album {
    private String name;
    private ArrayList<String> songs;

    public Album(String name) {
        this.name = name;
        this.songs = new ArrayList<String>();
    }

    
    public String getName() {
        return this.name;
    }

    public ArrayList<String> getSongs() {
        return this.songs;
    }

    protected boolean hasSong(String songName) {
        for (int i = 0; i < this.songs.size(); i++) {
            if (this.songs.get(i).equals(songName)) {
                return true;
            }
        }
        return false;
    }

    public void addSong(String songName) {
        this.songs.add(songName);
    }

    

    // public boolean addSong(String songName) {
    //     if (!this.hasSong(songName)) {
    //         this.songs.add(songName);
    //         return true;
    //     }
    //     return false;
    // }
}
