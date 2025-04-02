package ckollmeier.de.Player.Controller;

import ckollmeier.de.Exception.EndOfPlaylistException;
import ckollmeier.de.Player.Interface.PlayableInterface;
import ckollmeier.de.Player.Interface.SkippableInterface;

public final class MediaController implements PlayableInterface, SkippableInterface {
    /**
     * List of all media players.
     */
    private final PlayableInterface[] mediaPlayers;

    /**
     * current media player which is playing.
     */
    private int currentPosition = 0;

    public MediaController(final PlayableInterface[] mediaPlayers) {
        this.mediaPlayers = mediaPlayers;
    }

    /**
     * play on first media player.
     */
    @Override
    public void play() {
        currentPosition = 0;
        mediaPlayers[currentPosition].play();
    }

    /**
     * skip to next media in current player.
     * @throws EndOfPlaylistException when last media player played last media
     */
    @Override
    public void skip() throws EndOfPlaylistException {
        if (mediaPlayers[currentPosition] instanceof SkippableInterface) {
            try {
                ((SkippableInterface) mediaPlayers[currentPosition]).skip();
            } catch (EndOfPlaylistException e) {
                skipAll();
            }
        }
    }

    /**
     * skip to next player.
     * @throws EndOfPlaylistException when last media player played
     */
    @Override
    public void skipAll() throws EndOfPlaylistException {
        currentPosition++;
        if (currentPosition >= mediaPlayers.length) {
            currentPosition = 0;
            throw new EndOfPlaylistException("All media played");
        }
        mediaPlayers[currentPosition].play();
    }

    @Override
    public int getCurrentPosition() {
        return currentPosition;
    }
}
