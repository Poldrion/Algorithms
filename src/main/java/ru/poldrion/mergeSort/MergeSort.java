package ru.poldrion.mergeSort;

import static ru.poldrion.quickSort.QuickSort.quickSort;
import static ru.poldrion.utils.Utils.measureTime;

public class MergeSort {

    public static final int TEST_LEN = 10000000;

    public static void main(String[] args) {
        test1();
    }

    public static int[] mergeSort(int[] array) {
        int[] tmp;
        int[] currentSrc = array;
        int[] currentDest = new int[array.length];

        int size = 1;
        while (size < array.length) {
            for (int i = 0; i < array.length; i += 2 * size) {
                merge(currentSrc, i, currentSrc, i + size, currentDest, i, size);
            }

            tmp = currentSrc;
            currentSrc = currentDest;
            currentDest = tmp;
            size = size * 2;
        }
        return currentSrc;
    }

    private static void merge(int[] src1, int src1Start, int[] src2, int src2Start, int[] dest, int destStart, int size) {
        int index1 = src1Start;
        int index2 = src2Start;

        int src1End = Math.min(src1Start + size, src1.length);
        int src2End = Math.min(src2Start + size, src2.length);

        int iterationCount = src1End - src1Start + src2End - src2Start;

        for (int i = destStart; i < destStart + iterationCount; i++) {
            if (index1 < src1End && (index2 >= src2End || src1[index1] < src2[index2])) {
                dest[i] = src1[index1];
                index1++;
            } else {
                dest[i] = src2[index2];
                index2++;
            }
        }
    }

    private static void test1() {

        int[] arr1 = new int[TEST_LEN];
        int[] arr2 = new int[TEST_LEN];


        System.out.println("\n-----Случайный массив-----");

        for (int i = 0; i < TEST_LEN; i++) {
            arr2[i] = arr1[i] = (int) Math.round(Math.random() * 10000);
        }

        System.out.println("Быстрая сортировка:");
        measureTime(() -> quickSort(arr1, 0, TEST_LEN - 1, false));

        System.out.println("Сортировка слиянием:");
        measureTime(() -> mergeSort(arr2));

    }



}
