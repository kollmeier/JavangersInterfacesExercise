package ckollmeier.de.Player.Interface;

import ckollmeier.de.Exception.EndOfPlaylistException;

public interface SkippableInterface {
    void skip() throws EndOfPlaylistException;

    void skipAll() throws EndOfPlaylistException;
}
