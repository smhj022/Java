package Sorting;

import java.util.ArrayList;
import java.util.Arrays;

public class SortingAlgos {
    public static int[] bubbleSort(int[] arr){

        // Time Complexity -> O(N2)
        // Space Complexity -> O(1)

        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr.length - i -1; j++){
                if(arr[j] > arr[j + 1]){
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return arr;
    }

    public static int[] selectionSort(int[] arr){

        for (int i = 0; i < arr.length; i++){
            int minIndex = i;
            for(int j = i; j< arr.length; j++) {
                if (arr[minIndex] > arr[j]) {
                    minIndex = j;
                }
            }
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
            System.out.println(Arrays.toString(arr));
        }
        return arr;
    }

    // Insertion sort
    public static int[] insertionSort(int[] arr){

        for (int i = 1; i < arr.length; i++){ // i = 1
            for(int j = i; j >= 1; j--){ // j = 1
                if (arr[j] < arr[j-1]) {
                    int temp = arr[j];
                    arr[j] = arr[j -1];
                    arr[j-1] = temp;
                }
            }
        }
        return arr;
    }
}
