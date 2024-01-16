package Sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

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
                } else{
                    break;
                }
            }
        }
        return arr;
    }

    // Merge sort
    public static int[] mergeSort(int [] arr){


        if(arr.length == 1){
            return arr;
        }

        int midIndex = arr.length/2;
        int[] left = mergeSort(Arrays.copyOfRange(arr, 0, midIndex));
        int[] right = mergeSort(Arrays.copyOfRange(arr, midIndex, arr.length));

        return merge(left, right);
    }

    public static int[] merge(int[] arr1, int[] arr2){

        int arr1Len = arr1.length;
        int arr2Len = arr2.length;

        int index = 0;
        int i = 0;
        int j = 0;


        int[] combinedArr = new int[arr1Len + arr2Len];

        while(arr1Len != 0 && arr2Len != 0){
            if(arr1[i] < arr2[j]){
                combinedArr[index++] = arr1[i++];
                arr1Len--;
            }
            else {
                combinedArr[index++] = arr2[j++];
                arr2Len--;
            }
        }

        while(arr1Len != 0 ){
            combinedArr[index++] = arr1[i++];
            arr1Len--;
        }

        while(arr2Len != 0){
            combinedArr[index++] = arr2[j++];
            arr2Len--;
        }

        return combinedArr;
    }

    public static void swap(int[] arr, int firstIndex, int secondIndex){
        int temp = arr[firstIndex];
        arr[firstIndex] = arr[secondIndex];
        arr[secondIndex] = temp;
    }


    public static int pivot(int[] arr, int pivotIndex, int endIndex){

        int swapIndex = pivotIndex;

        for(int i = pivotIndex+1; i <= endIndex; i++){

            if(arr[i] < arr[pivotIndex]){
                swapIndex++;
                swap(arr, i, swapIndex);
            }
        }
        swap(arr, swapIndex, pivotIndex);

        return swapIndex;
    }

    public static void quickSort(int arr[], int left, int right){

        if(left < right) {
            int pivotIndex = pivot(arr, left, right);
            quickSort(arr, left, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, right);
        }
    }
}
