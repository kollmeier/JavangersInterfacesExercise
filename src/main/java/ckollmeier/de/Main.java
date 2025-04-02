package ckollmeier.de;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Noisy[] noisyObjects = {new Dog(), new Radio(), new Cow()};

        for (Noisy noisy : noisyObjects) {
            noisy.makeNoise();
        }

        MusicPlayer cdPlayer = new MusicPlayer(new String[]{"Waterloo", "Die Welt kann mich nicht mehr verstehn", "Song 2", "7 Nation Army"});
        VideoPlayer diskPlayer = new VideoPlayer(new String[]{"Die Hard", "Aschenblödel", "Bad Boys"});

        MediaController mediaController = new MediaController(new Playable[]{cdPlayer, diskPlayer});

        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to music player");
        while (true) {
            System.out.println("p to play, s to skip, a to skip all, q to quit");
            String action = scanner.nextLine();
            try {
                switch (action) {
                    case "p":
                        mediaController.play();
                        break;
                    case "s":
                        mediaController.skip();
                        break;
                    case "a":
                        mediaController.skipAll();
                        break;
                    case "q":
                        System.exit(0);
                        break;
                }
            } catch (EndOfPlaylistException e) {
                System.out.println("All media played");
            }
        }
    }
}