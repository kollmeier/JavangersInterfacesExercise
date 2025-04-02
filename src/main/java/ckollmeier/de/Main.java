package ckollmeier.de;

import ckollmeier.de.Player.Controller.MediaController;
import ckollmeier.de.Exception.EndOfPlaylistException;
import ckollmeier.de.Player.MusicPlayer;
import ckollmeier.de.Player.Interface.PlayableInterface;
import ckollmeier.de.Player.VideoPlayer;

import java.util.Scanner;

public class Main {
    public static void main(final String[] args) {
        MusicPlayer cdPlayer = new MusicPlayer(new String[]{"Waterloo", "Die Welt kann mich nicht mehr verstehn", "Song 2", "7 Nation Army"});
        VideoPlayer diskPlayer = new VideoPlayer(new String[]{"Die Hard", "Aschenblödel", "Bad Boys"});

        MediaController mediaController = new MediaController(new PlayableInterface[]{cdPlayer, diskPlayer});

        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to media player");
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
                        scanner.close();
                        System.exit(0);
                        break;
                    default:
                        break;
                }
            } catch (EndOfPlaylistException e) {
                System.out.println("All media played");
            }
        }
    }
}