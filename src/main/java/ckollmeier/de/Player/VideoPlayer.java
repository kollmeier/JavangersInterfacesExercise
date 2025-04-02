package ckollmeier.de.Player;

import ckollmeier.de.Exception.EndOfPlaylistException;
import ckollmeier.de.Player.Interface.PlayableInterface;
import ckollmeier.de.Player.Interface.SkippableInterface;

public class VideoPlayer implements PlayableInterface, SkippableInterface {
    /**
     * video index to be played.
     */
    private int currentPosition = 0;
    /**
     * list of videos.
     */
    private final String[] videos;

    public VideoPlayer(final String[] videos) {
        this.videos = videos;
    }

    private void playActualVideo() {
        System.out.printf("(Playing video %2d/%2d): %s\n", currentPosition + 1, videos.length, videos[currentPosition]);
    }

    /**
     * play videos from beginning.
     */
    @Override
    public void play() {
        System.out.println("Playing video");
        currentPosition = 0;
        playActualVideo();
    }

    /**
     * skip to next video.
     * @throws EndOfPlaylistException when last video played.
     */
    @Override
    public void skip() throws EndOfPlaylistException {
        currentPosition++;
        if (currentPosition >= videos.length) {
            currentPosition = 0;
            throw new EndOfPlaylistException("End of playlist");
        }
        playActualVideo();
    }

    /**
     * @throws EndOfPlaylistException is always thrown.
     */
    @Override
    public void skipAll() throws EndOfPlaylistException {
        currentPosition = 0;
        throw new EndOfPlaylistException("Skipping all videos");
    }
}
