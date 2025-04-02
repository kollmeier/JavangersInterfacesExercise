package ckollmeier.de.Player.Interface;

import ckollmeier.de.Exception.EndOfPlaylistException;

public interface SkippableInterface {
    /**
     * skip to next media item.
     * @throws EndOfPlaylistException no more items in list
     */
    void skip() throws EndOfPlaylistException;

    /**
     * skip after last media item.
     * @throws EndOfPlaylistException is always thrown
     */
    void skipAll() throws EndOfPlaylistException;
}
