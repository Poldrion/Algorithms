package ru.poldrion.searchElementInArray;

import static ru.poldrion.bubbleSort.BubbleSort.bubbleSort;
import static ru.poldrion.utils.Utils.arrayToString;

public class SearchElementInArray {
    public static void main(String[] args) {
        int[] array = new int[]{64, 42, 73, 41, 31, 53, 16, 24, 57, 42, 74, 55, 36};
        bubbleSort(array);
        System.out.println(arrayToString(array));

        System.out.println(searchLinear(array, 57));
        System.out.println(searchBinaryRecursive(array, 0, array.length - 1, 57));
        System.out.println(searchBinary(array,57));
    }

    public static int searchLinear(int[] array, int elementToFind) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == elementToFind) {
                return i;
            }
        }
        return -1;
    }

    public static int searchBinaryRecursive(int[] array, int startIndex, int endIndex, int elementToFind) {
        if (endIndex >= startIndex) {
            int middleIndex = startIndex + (endIndex - startIndex) / 2;

            if (array[middleIndex] == elementToFind) {
                return middleIndex;
            }

            if (array[middleIndex] > elementToFind) {
                return searchBinaryRecursive(array, startIndex, middleIndex - 1, elementToFind);
            } else {
                return searchBinaryRecursive(array, middleIndex + 1, endIndex, elementToFind);
            }
        }
        return -1;
    }

    public static int searchBinary(int[] array, int elementToFind) {
        int startIndex = 0;
        int endIndex = array.length - 1;
        int middleIndex;
        while (startIndex <= endIndex) {
            middleIndex = startIndex + (endIndex - startIndex) / 2;
            if (array[middleIndex] == elementToFind) {
                return middleIndex;
            }

            if (array[middleIndex] > elementToFind) {
                endIndex = middleIndex - 1;
            } else {
                startIndex = middleIndex + 1;
            }
        }
        return -1;
    }

}
