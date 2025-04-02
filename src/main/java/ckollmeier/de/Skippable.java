package ckollmeier.de;

public interface Skippable {
    void skip() throws EndOfPlaylistException;

    void skipAll() throws EndOfPlaylistException;
}
