package ru.poldrion.quickSort;

import java.util.Arrays;

import static ru.poldrion.bubbleSort.BubbleSort.bubbleSort;
import static ru.poldrion.mergeSort.MergeSort.mergeSort;
import static ru.poldrion.utils.Utils.*;

public class QuickSort {
    private static final int TEST_LEN = 10000;


    public static void main(String[] args) {
        test1();
        test2();
    }

    public static void quickSort(int[] arr, int from, int to, boolean printStep) {
        if (from < to) {
            int divideIndex = partition(arr, from, to);
            if (printStep) {
                printSortStep(arr, from, to, divideIndex);
                quickSort(arr, from, divideIndex - 1, true);
                quickSort(arr, divideIndex, to, true);
            } else {
                quickSort(arr, from, divideIndex - 1, false);
                quickSort(arr, divideIndex, to, false);
            }
        }
    }

    private static int partition(int[] arr, int from, int to) {
        int rightIndex = to;
        int leftIndex = from;

        int pivot = arr[from + (to - from) / 2];
        while (leftIndex <= rightIndex) {
            while (arr[leftIndex] < pivot) {
                leftIndex++;
            }
            while (arr[rightIndex] > pivot) {
                rightIndex--;
            }
            if (leftIndex <= rightIndex) {
                swap(arr, rightIndex, leftIndex);
                leftIndex++;
                rightIndex--;
            }
        }
        return leftIndex;
    }


    private static void test1() {
        int[] arr1 = new int[TEST_LEN];
        int[] arr2 = new int[TEST_LEN];
        int[] arr3 = new int[TEST_LEN];

        System.out.println("\n-----Случайный массив-----");

        for (int i = 0; i < TEST_LEN; i++) {
            arr3[i] = arr2[i] = arr1[i] = (int) Math.round(Math.random() * 10000);
        }

        System.out.println("Быстрая сортировка:");
        measureTime(() -> quickSort(arr1, 0, TEST_LEN - 1, false));

        System.out.println("Сортировка слиянием:");
        measureTime(() -> mergeSort(arr2));

        System.out.println("Сортировка пузырьком:");
        measureTime(() -> bubbleSort(arr3));
    }

    private static void test2() {
        int[] arr1 = new int[TEST_LEN];
        int[] arr2 = new int[TEST_LEN];
        int[] arr3 = new int[TEST_LEN];

        System.out.println("\n-----Отсорстированный массив-----");

        for (int i = 0; i < TEST_LEN; i++) {
            arr3[i] = arr2[i] = arr1[i] = i;
        }

        System.out.println("Быстрая сортировка:");
        measureTime(() -> quickSort(arr1, 0, TEST_LEN - 1, false));

        System.out.println("Сортировка сдиянием:");
        measureTime(() -> mergeSort(arr2));

        System.out.println("Сортировка пузырьком:");
        measureTime(() -> bubbleSort(arr3));
    }

    private static void printSortStep(int[] arr, int from, int to, int partitionIndex) {
        System.out.print(arrayToString(arr));
        System.out.print("\npartition at index: " + partitionIndex);
        System.out.print(", left: " + arrayToString(Arrays.copyOfRange(arr, from, partitionIndex)));
        System.out.println(", right: " + arrayToString(Arrays.copyOfRange(arr, partitionIndex, to + 1)) + "\n");
    }
}
