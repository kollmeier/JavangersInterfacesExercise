package ckollmeier.de.Player.Controller;

import ckollmeier.de.Exception.EndOfPlaylistException;
import ckollmeier.de.Player.Interface.PlayableInterface;
import ckollmeier.de.Player.Interface.SkippableInterface;

public class MediaController implements PlayableInterface, SkippableInterface {
    private final PlayableInterface[] mediaPlayers;

    private int currentPosition = 0;

    public MediaController(PlayableInterface[] mediaPlayers) {
        this.mediaPlayers = mediaPlayers;
    }

    @Override
    public void play() {
        currentPosition = 0;
        mediaPlayers[currentPosition].play();
    }

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

    @Override
    public void skipAll() throws EndOfPlaylistException {
        currentPosition++;
        if (currentPosition >= mediaPlayers.length) {
            currentPosition = 0;
            throw new EndOfPlaylistException("All media played");
        }
        mediaPlayers[currentPosition].play();
    }
}
