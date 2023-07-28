package ru.poldrion.fractalNoise;

public class Noise {

    int scale;
    Random random;

    public Noise(int scale, Random random) {
        this.scale = scale;
        this.random = random;
    }

    public float getValue(int x, int y) {
        // номера узлов сетки
        int xGrid = x / scale;
        int yGrid = y / scale;
        int xGridNext = xGrid + 1;
        int yGridNext = yGrid + 1;

        // координаты узлов сетки
        int xStart = xGrid * scale;
        int xEnd = xGridNext * scale;
        int yStart = yGrid * scale;
        int yEnd = yGridNext * scale;

        float value12 = random.getRandomNumber(xGrid, yGrid);
        float value22 = random.getRandomNumber(xGridNext, yGrid);
        float value21 = random.getRandomNumber(xGridNext, yGridNext);
        float value11 = random.getRandomNumber(xGrid, yGridNext);

        /*
            w11 = (x2 - x) * (y2 - y) / (x2 - x1) * (y2 - y1)
            w12 = (x2 - x) * (y - y1) / (x2 - x1) * (y2 - y1)
            w21 = (x - x1) * (y2 - y) / (x2 - x1) * (y2 - y1)
            w22 = (x - x1) * (y - y1) / (x2 - x1) * (y2 - y1)
         */

        // расчет коэффициентов
        float w11 = ((float) (xEnd - x) * (y - yStart) / ((xEnd - xStart) * (yEnd - yStart)));
        float w12 = ((float) (xEnd - x) * (yEnd - y) / ((xEnd - xStart) * (yEnd - yStart)));
        float w21 = ((float) (x - xStart) * (y - yStart) / ((xEnd - xStart) * (yEnd - yStart)));
        float w22 = ((float) (x - xStart) * (yEnd - y) / ((xEnd - xStart) * (yEnd - yStart)));

        // билинейная интерполяция
        float value = value11 * w11 + value12 * w12 + value21 * w21 + value22 * w22;

        return value;
    }
}
