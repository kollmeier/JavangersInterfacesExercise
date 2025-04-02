package ckollmeier.de.Player.Controller;

import ckollmeier.de.Exception.EndOfPlaylistException;
import ckollmeier.de.Player.Controller.MediaController;
import ckollmeier.de.Player.Interface.PlayableInterface;
import ckollmeier.de.Player.Interface.SkippableInterface;
import ckollmeier.de.Player.MusicPlayer;
import ckollmeier.de.Player.VideoPlayer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MediaControllerTest {
    @Test
    void playShouldKeepCurrentPositionButSetCurrentPositionOfCurrentPlayerToZeroWhenCalled() {
        MusicPlayer musicPlayer = new MusicPlayer(new String[]{"Song 1", "Song 2", "Song 3"});
        VideoPlayer videoPlayer = new VideoPlayer(new String[]{"Video 1", "Video 2", "Video 3"});
        MediaController mediaController = new MediaController(new PlayableInterface[]{musicPlayer, videoPlayer});

        mediaController.play();

        assertEquals(0, mediaController.getCurrentPosition());

        PlayableInterface currentMediaPlayer = mediaController.getCurrentMediaPlayer();
        if (currentMediaPlayer instanceof SkippableInterface) {
            assertEquals(0, ((SkippableInterface) currentMediaPlayer).getCurrentPosition());
        }
    }

    @Test
    void playShouldKeepCurrentPositionButSetCurrentPositionOfCurrentPlayerToZeroWhenSkipIsCalledBeforePlay() {
        MusicPlayer musicPlayer = new MusicPlayer(new String[]{"Song 1", "Song 2", "Song 3"});
        VideoPlayer videoPlayer = new VideoPlayer(new String[]{"Video 1", "Video 2", "Video 3"});
        MediaController mediaController = new MediaController(new PlayableInterface[]{musicPlayer, videoPlayer});

        mediaController.skipAll();
        mediaController.skip();
        mediaController.play();

        assertEquals(1, mediaController.getCurrentPosition());

        PlayableInterface currentMediaPlayer = mediaController.getCurrentMediaPlayer();
        if (currentMediaPlayer instanceof SkippableInterface) {
            assertEquals(0, ((SkippableInterface) currentMediaPlayer).getCurrentPosition());
        }
    }

    @Test
    void skipShouldIncrementCurrentPositionOfCurrentPlayerWhenSkipIsCalled() {
        MusicPlayer musicPlayer = new MusicPlayer(new String[]{"Song 1", "Song 2", "Song 3"});
        VideoPlayer videoPlayer = new VideoPlayer(new String[]{"Video 1", "Video 2", "Video 3"});
        MediaController mediaController = new MediaController(new PlayableInterface[]{musicPlayer, videoPlayer});

        PlayableInterface currentMediaPlayer = mediaController.getCurrentMediaPlayer();
        mediaController.skip();

        assertEquals(0, mediaController.getCurrentPosition());
        if (currentMediaPlayer instanceof SkippableInterface) {
            assertEquals(1, ((SkippableInterface) currentMediaPlayer).getCurrentPosition());
            mediaController.skip();
            assertEquals(2, ((SkippableInterface) currentMediaPlayer).getCurrentPosition());
        }


    }

    @Test
    void skipShouldThrowEndOfPlaylistExceptionAndSetCurrentPositionToZeroWhenSkipIsCalledAndEndOfListIsReached() {
        MusicPlayer musicPlayer = new MusicPlayer(new String[]{"Song 1", "Song 2", "Song 3"});
        VideoPlayer videoPlayer = new VideoPlayer(new String[]{"Video 1", "Video 2", "Video 3"});
        MediaController mediaController = new MediaController(new PlayableInterface[]{musicPlayer, videoPlayer});
        mediaController.skip();
        mediaController.skip();
        mediaController.skip();
        mediaController.skip();
        mediaController.skip();


        assertThrows(EndOfPlaylistException.class, mediaController::skip);
        assertEquals(0, mediaController.getCurrentPosition());
    }

    @Test
    void skipAllShouldIncrementCurrentPositionWhenCalled() {
        MusicPlayer musicPlayer = new MusicPlayer(new String[]{"Song 1", "Song 2", "Song 3"});
        VideoPlayer videoPlayer = new VideoPlayer(new String[]{"Video 1", "Video 2", "Video 3"});
        MediaController mediaController = new MediaController(new PlayableInterface[]{musicPlayer, videoPlayer});

        mediaController.skipAll();
        assertEquals(1, mediaController.getCurrentPosition());
    }

    @Test
    void skipAllThrowEndOfPlaylistExceptionAndSetCurrentPositionToZeroWhenSkipAllIsCalledAndEndOfListIsReached() {
        MusicPlayer musicPlayer = new MusicPlayer(new String[]{"Song 1", "Song 2", "Song 3"});
        VideoPlayer videoPlayer = new VideoPlayer(new String[]{"Video 1", "Video 2", "Video 3"});
        MediaController mediaController = new MediaController(new PlayableInterface[]{musicPlayer, videoPlayer});

        mediaController.skipAll();

        assertThrows(EndOfPlaylistException.class, mediaController::skipAll);
        assertEquals(0, mediaController.getCurrentPosition());
    }
}