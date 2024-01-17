package Sorting;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        int[] arr = {4,6,1,7,3,2,5};
        SortingAlgos.quickSort(arr, 0, 6);

        System.out.println(Arrays.toString(arr));
    }
}
