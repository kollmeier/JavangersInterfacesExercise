package ckollmeier.de.Exception;

public class EndOfPlaylistException extends RuntimeException {
    public EndOfPlaylistException(final String message) {
        super(message);
    }
}
