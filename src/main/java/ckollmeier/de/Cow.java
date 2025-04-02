package ckollmeier.de;

public class Cow implements Noisy, Runnable {
    @Override
    public void makeNoise() {
        System.out.println("\"Moooooooooooooooo!\"");
    }

    @Override
    public void run() {
        System.out.println("Cow runs.");
    }
}
