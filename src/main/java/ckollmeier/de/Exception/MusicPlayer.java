package ckollmeier.de.Exception;

import ckollmeier.de.Player.Interface.PlayableInterface;
import ckollmeier.de.Player.Interface.SkippableInterface;

public class MusicPlayer implements PlayableInterface, SkippableInterface {
    private int currentPosition = 0;
    private final String[] songs;

    public MusicPlayer(String[] songs) {
        this.songs = songs;
    }

    private void playActualSong() {
        System.out.printf("(Playing song %2d/%2d): %s\n",currentPosition+1, songs.length, songs[currentPosition]);
    }

    @Override
    public void play() {
        System.out.println("Playing music");
        currentPosition = 0;
        playActualSong();
    }

    @Override
    public void skip() throws EndOfPlaylistException {
        currentPosition++;
        if (currentPosition >= songs.length) {
            currentPosition = 0;
            throw new EndOfPlaylistException("End of playlist");
        }
        playActualSong();
    }

    @Override
    public void skipAll() throws EndOfPlaylistException {
        currentPosition = 0;
        throw new EndOfPlaylistException("Skipping all music");
    }
}
