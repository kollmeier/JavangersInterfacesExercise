package ckollmeier.de;

public class Radio implements Noisy {
    @Override
    public void makeNoise() {
        System.out.println("\"Is this the reaaaal world? Is this just fantasy?=\"");
    }
}
