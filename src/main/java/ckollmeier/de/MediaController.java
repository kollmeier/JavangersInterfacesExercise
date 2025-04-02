package ckollmeier.de;

public class MediaController implements Playable, Skippable {
    private final Playable[] mediaPlayers;

    private int currentPosition = 0;

    public MediaController(Playable[] mediaPlayers) {
        this.mediaPlayers = mediaPlayers;
    }

    @Override
    public void play() {
        currentPosition = 0;
        mediaPlayers[currentPosition].play();
    }

    @Override
    public void skip() throws EndOfPlaylistException {
        if (mediaPlayers[currentPosition] instanceof Skippable) {
            try {
                ((Skippable) mediaPlayers[currentPosition]).skip();
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
