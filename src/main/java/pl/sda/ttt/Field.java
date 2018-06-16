package pl.sda.ttt;

import java.util.Random;

public enum Field {
    X,O;

    private static Random random = new Random();

    static Field randomField() {
        int index = random.nextInt(values().length);
        return values()[index];
    }

    static Field otherThan(Field original) {
        return original == X ? O : X;
    }
}
