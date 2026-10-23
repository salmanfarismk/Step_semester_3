package encapsulation.assigment_problems;

import java.util.Arrays;

/**
 * Problem 2: The Playlist
 * Scenario: Music App Secure Playlist
 * 
 * Demonstrates defensive copying in encapsulation: returns a cloned copy of the
 * internal array so that external callers cannot tamper with or mutate the
 * actual stored playlist.
 * 
 * Concepts: Defensive copying, array encapsulation, data protection, immutability of returned data.
 */
public class Playlist {

    private final String[] songs;
    private int songCount;

    /**
     * Initializes the playlist with a fixed maximum capacity.
     *
     * @param maxCapacity Maximum number of songs the playlist can hold
     */
    public Playlist(int maxCapacity) {
        if (maxCapacity <= 0) {
            throw new IllegalArgumentException("Capacity must be positive.");
        }
        this.songs = new String[maxCapacity];
        this.songCount = 0;
    }

    /**
     * Adds a song title to the playlist if capacity permits.
     *
     * @param song Title of the song to add
     */
    public void addSong(String song) {
        if (song == null || song.trim().isEmpty()) {
            return;
        }

        if (songCount < songs.length) {
            songs[songCount] = song;
            songCount++;
        } else {
            System.out.println("Playlist is full. Cannot add: " + song);
        }
    }

    /**
     * Returns a safe defensive copy of all songs added so far.
     * Modifying the returned array has no impact on the playlist's internal state.
     *
     * @return A new array containing copies of the song titles
     */
    public String[] getSongs() {
        return Arrays.copyOf(songs, songCount);
    }

    /**
     * Returns the number of songs currently in the playlist.
     *
     * @return Number of added songs
     */
    public int getSongCount() {
        return songCount;
    }

    public static void main(String[] args) {
        System.out.println("=== Problem 2: The Playlist ===");

        Playlist p = new Playlist(10);
        p.addSong("Song A");
        p.addSong("Song B");

        System.out.println("Song count: " + p.getSongCount());
        System.out.println("Original playlist songs: " + Arrays.toString(p.getSongs()));

        // Test defensive copy protection
        String[] copy = p.getSongs();
        copy[0] = "Hacked";

        System.out.println("Modified copy[0] to: " + copy[0]);
        System.out.println("Actual internal playlist[0] is still: " + p.getSongs()[0]);
    }
}
