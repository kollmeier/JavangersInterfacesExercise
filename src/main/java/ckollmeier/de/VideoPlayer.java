package ckollmeier.de;

public class VideoPlayer implements Playable, Skippable {
    private int currentPosition = 0;
    private final String[] videos;

    public VideoPlayer(String[] videos) {
        this.videos = videos;
    }

    private void playActualVideo() {
        System.out.printf("(Playing video %2d/%2d): %s\n",currentPosition+1, videos.length, videos[currentPosition]);
    }

    @Override
    public void play() {
        System.out.println("Playing video");
        currentPosition = 0;
        playActualVideo();
    }

    @Override
    public void skip() throws EndOfPlaylistException {
        currentPosition++;
        if (currentPosition >= videos.length) {
            currentPosition = 0;
            throw new EndOfPlaylistException("End of playlist");
        }
        playActualVideo();
    }

    @Override
    public void skipAll() throws EndOfPlaylistException {
        currentPosition = 0;
        throw new EndOfPlaylistException("Skipping all videos");
    }
}
