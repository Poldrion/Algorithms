package ru.poldrion.selectionSort;

import static ru.poldrion.utils.Utils.arrayToString;

public class SelectionSort {

    public static void main(String[] args) {
        int[] array = new int[]{64, 42, 73, 41, 31, 53, 16, 24, 57, 42, 74, 55, 36};

        selectionSort(array);

        System.out.println(arrayToString(array));
        System.out.println("min value index: " + min(array, 0, array.length));

    }

    public static void selectionSort(int[] array) {
        for (int step = 0; step < array.length; step++) {
            System.out.println(arrayToString(array));
            int index = min(array, step, array.length);

            int temp = array[step];
            array[step] = array[index];
            array[index] = temp;
        }
    }

    private static int min(int[] array, int start, int end) {
        int minIndex = start;
        int minValue = array[start];
        for (int i = start + 1; i < end; i++) {
            if (array[i] < minValue) {
                minValue = array[i];
                minIndex = i;
            }
        }
        return minIndex;
    }


}
