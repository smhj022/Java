package Heap;

import java.util.*;

public class HeapQuestions {


    // Kth Largest Element in an Array
    public int findKthLargest(int[] nums, int k) {

        PriorityQueue<Integer> myQueue = new PriorityQueue<>(k);

        for (int num : nums) {
            myQueue.add(num);
            if (myQueue.size() > k) {
                myQueue.poll();
            }
        }

        if (myQueue.isEmpty()) return 0;

        return myQueue.peek();
    }

    // Find K largest element of an array
    public int[] KLargest(int[] nums, int k){

        if(nums.length < k) return nums;

        PriorityQueue<Integer> queue = new PriorityQueue<>();

        int[] res = new int[k];

        for (int num : nums) {
            queue.add(num);
            if (queue.size() > k) {
                queue.poll();
            }
        }



        for(int i = 0; i< k;i++){
            res[i] = queue.poll();
        }

        return res;
    }

    // sort K sorted array
    public void sortLKSorted(int[] nums, int k){

        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for(int i = 0; i <= k ; i++){
            queue.add(nums[i]);
        }

        int irr = 0;
        for(int j = k + 1; j < nums.length; j++){
            nums[irr++] = queue.poll();
            queue.add(nums[j]);
        }
        while (!queue.isEmpty()){
            nums[irr++] = queue.poll();
        }
        System.out.println(Arrays.toString(nums));
    }


    public List<Integer> kClosedValues(int[] nums, int x, int k){

        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for (int num : nums) {
            if (k > 0) {
                queue.add(num);
                k--;
            } else if (Math.abs(queue.peek() - x) > Math.abs(num - x)) {
                queue.poll();
                queue.add(num);
            }
        }

        List<Integer> result = new ArrayList<>();

        while (!queue.isEmpty()){
            result.add(queue.poll());
        }

        return result;
    }
}
