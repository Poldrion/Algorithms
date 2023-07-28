package ru.poldrion.utils;

import javax.swing.*;
import java.awt.*;

public class Utils {

    public static String arrayToString(int[] array) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < array.length; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            sb.append(array[i]);
        }
        sb.append("]");
        return sb.toString();
    }

    public static void measureTime(Runnable task) {
        long startTime = System.currentTimeMillis();
        task.run();
        long elapsed = System.currentTimeMillis() - startTime;
        System.out.println("Затрачено время: " + elapsed + " ms");
    }

    public static void swap(int[] arr, int rightIndex, int leftIndex) {
        int tmp = arr[rightIndex];
        arr[rightIndex] = arr[leftIndex];
        arr[leftIndex] = tmp;
    }

    public static void showImageWindow(Image image) {
        showImageWindow(image, 1024, 768);
    }

    public static void showImageWindow(Image image, int width, int height) {
        JFrame frame = new JFrame();
        frame.setSize(width, height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel picLabel = new JLabel(new ImageIcon(image));

        BorderLayout borderLayout = new BorderLayout();
        frame.getContentPane().setLayout(borderLayout);
        frame.getContentPane().add(picLabel, BorderLayout.CENTER);

        frame.setVisible(true);
    }
}
