package ru.poldrion.fractalNoise;

public class Random {

    int[] table;
    int lineWidth;

    public Random(int lineWidth, int size) {
        table = new int[size];
        for (int i = 0; i < size; i++) {
            table[i] = Math.random() >= 0.5 ? 1 : 0;
        }
        this.lineWidth = lineWidth;
    }

    public int getRandomNumber(int x, int y) {
        return table[(x + y * lineWidth) % table.length];
    }
}
