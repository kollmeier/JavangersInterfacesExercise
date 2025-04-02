package ckollmeier.de.Player;

import ckollmeier.de.Exception.EndOfPlaylistException;
import ckollmeier.de.Player.Interface.PlayableInterface;
import ckollmeier.de.Player.Interface.SkippableInterface;

public final class MusicPlayer implements PlayableInterface, SkippableInterface {
    /**
     * song index to be played.
     */
    private int currentPosition = 0;

    @Override
    public int getCurrentPosition() {
        return currentPosition;
    }

    /**
     * List of songs.
     */
    private final String[] songs;

    public MusicPlayer(final String[] songs) {
        this.songs = songs;
    }

    private void playActualSong() {
        System.out.printf("(Playing song %2d/%2d): %s\n", currentPosition + 1, songs.length, songs[currentPosition]);
    }

    /**
     * play list from beginning.
     */
    @Override
    public void play() {
        System.out.println("Playing music");
        currentPosition = 0;
        playActualSong();
    }

    /**
     * skip to next song.
     * @throws EndOfPlaylistException when no more songs in list
     */
    @Override
    public void skip() throws EndOfPlaylistException {
        currentPosition++;
        if (currentPosition >= songs.length) {
            currentPosition = 0;
            throw new EndOfPlaylistException("End of playlist");
        }
        playActualSong();
    }

    /**
     * skips all songs.
     * @throws EndOfPlaylistException always thrown
     */
    @Override
    public void skipAll() throws EndOfPlaylistException {
        currentPosition = 0;
        throw new EndOfPlaylistException("Skipping all music");
    }
}
