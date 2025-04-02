package ckollmeier.de;

public class Dog implements Noisy, Runnable {
    @Override
    public void makeNoise() {
        System.out.println("\"Woof! Woof! RRRRRRrrrrrrr....\"");
    }

    @Override
    public void run() {
        System.out.println("Dog runs.");
    }
}
