package Backtracking;

public class Main {

    public static void main(String[] args) {

        BacktrackingQues bq = new BacktrackingQues();
        bq.nDigitNumber(3);

        int[] arr = {10,2,7,6,1,5};

//        System.out.println(bq.countSumK(arr, 8));

        System.out.println(bq.allPermutation("aabc").size());

        String str = "aabc";
        int index = 1;

        str = str.substring(0,index) + str.substring(index+1);

        int[] nums = {1,2,3};

        System.out.println(bq.permute(nums));



    }
}


