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
            System.out.println(i + " " +Arrays.toString(arr));
        }
        return arr;
    }
}
