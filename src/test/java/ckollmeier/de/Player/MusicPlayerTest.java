package ckollmeier.de.Player;

import ckollmeier.de.Exception.EndOfPlaylistException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MusicPlayerTest {

    @Test
    void playShouldSetCurrentPositionToZeroWhenCalled() {
        MusicPlayer musicPlayer = new MusicPlayer(new String[]{"Song 1", "Song 2", "Song 3"});

        musicPlayer.play();

        assertEquals(0, musicPlayer.getCurrentPosition());
    }

    @Test
    void playShouldSetCurrentPositionToZeroWhenSkipIsCalledBeforePlay() {
        MusicPlayer musicPlayer = new MusicPlayer(new String[]{"Song 1", "Song 2", "Song 3"});

        musicPlayer.skip();
        musicPlayer.play();

        assertEquals(0, musicPlayer.getCurrentPosition());
    }

    @Test
    void skipShouldIncrementCurrentPositionWhenSkipIsCalled() {
        MusicPlayer musicPlayer = new MusicPlayer(new String[]{"Song 1", "Song 2", "Song 3"});

        musicPlayer.skip();

        assertEquals(1, musicPlayer.getCurrentPosition());

        musicPlayer.skip();

        assertEquals(2, musicPlayer.getCurrentPosition());
    }

    @Test
    void skipShouldThrowEndOfPlaylistExceptionAndSetCurrentPositionToZeroWhenSkipIsCalledAndEndOfListIsReached() {
        MusicPlayer musicPlayer = new MusicPlayer(new String[]{"Song 1", "Song 2", "Song 3"});
        musicPlayer.skip();
        musicPlayer.skip();

        assertThrows(EndOfPlaylistException.class, musicPlayer::skip);
        assertEquals(0, musicPlayer.getCurrentPosition());
    }

    @Test
    void skipAllShouldThrowEndOfPlaylistExceptionAndSetCurrentPositionToZeroWhenCalled() {
        MusicPlayer musicPlayer = new MusicPlayer(new String[]{"Song 1", "Song 2", "Song 3"});

        assertThrows(EndOfPlaylistException.class, musicPlayer::skipAll);
        assertEquals(0, musicPlayer.getCurrentPosition());
    }
}