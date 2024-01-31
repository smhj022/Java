package Heap;

import java.util.PriorityQueue;

public class HeapQuestions {


    // Kth Largest Element in an Array
    public int findKthLargest(int[] nums, int k) {

        PriorityQueue<Integer> myQueue = new PriorityQueue<>(k);

        for(int i=0; i < k; i++){
            myQueue.add(nums[i]);
        }

        for(int j=k; j<nums.length; j++){
            if(myQueue.peek() < nums[j]){
                myQueue.poll();
                myQueue.add(nums[j]);
            }
        }

        return myQueue.peek();
    }



}
