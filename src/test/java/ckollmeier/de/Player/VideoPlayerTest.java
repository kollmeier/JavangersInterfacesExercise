package ckollmeier.de.Player;

import ckollmeier.de.Exception.EndOfPlaylistException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VideoPlayerTest {
    @Test
    void playShouldSetCurrentPositionToZeroWhenCalled() {
        VideoPlayer videoPlayer = new VideoPlayer(new String[]{"Video 1", "Video 2", "Video 3"});

        videoPlayer.play();

        assertEquals(0, videoPlayer.getCurrentPosition());
    }

    @Test
    void playShouldSetCurrentPositionToZeroWhenSkipIsCalledBeforePlay() {
        VideoPlayer videoPlayer = new VideoPlayer(new String[]{"Video 1", "Video 2", "Video 3"});

        videoPlayer.skip();
        videoPlayer.play();

        assertEquals(0, videoPlayer.getCurrentPosition());
    }

    @Test
    void skipShouldIncrementCurrentPositionWhenSkipIsCalled() {
        VideoPlayer videoPlayer = new VideoPlayer(new String[]{"Video 1", "Video 2", "Video 3"});

        videoPlayer.skip();

        assertEquals(1, videoPlayer.getCurrentPosition());

        videoPlayer.skip();

        assertEquals(2, videoPlayer.getCurrentPosition());
    }

    @Test
    void skipShouldThrowEndOfPlaylistExceptionAndSetCurrentPositionToZeroWhenSkipIsCalledAndEndOfListIsReached() {
        VideoPlayer videoPlayer = new VideoPlayer(new String[]{"Video 1", "Video 2", "Video 3"});
        videoPlayer.skip();
        videoPlayer.skip();

        assertThrows(EndOfPlaylistException.class, videoPlayer::skip);
        assertEquals(0, videoPlayer.getCurrentPosition());
    }

    @Test
    void skipAllShouldThrowEndOfPlaylistExceptionAndSetCurrentPositionToZeroWhenCalled() {
        VideoPlayer videoPlayer = new VideoPlayer(new String[]{"Video 1", "Video 2", "Video 3"});

        assertThrows(EndOfPlaylistException.class, videoPlayer::skipAll);
        assertEquals(0, videoPlayer.getCurrentPosition());
    }

}