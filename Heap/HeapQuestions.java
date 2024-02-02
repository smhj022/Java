package Heap;

import java.util.*;

public class HeapQuestions {

    class Pair implements Comparable<Pair>{
        int num, count;
        public Pair(int num, int count) {
            this.num = num;
            this.count = count;
        }
        public int compareTo(Pair b){
            return this.count-b.count;
        }
    }


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

    // Find K no. largest element of an array
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

    public int[] topKFrequentNumber(int[] nums, int k){

        HashMap<Integer, Integer> freqHM = new HashMap<>();
        for(int num: nums){
            freqHM.put(num, freqHM.getOrDefault(num, 0)+1);
        }

        PriorityQueue<Pair> minheap = new PriorityQueue<>();
        Set<Integer> keys = freqHM.keySet();

        for(int key: keys){

            if(minheap.size() < k){
                minheap.add(new Pair(key, freqHM.get(key)));
            } else if (minheap.peek().count < freqHM.get(key)) {
                minheap.poll();
                minheap.add(new Pair(key, freqHM.get(key)));
            }
        }

        System.out.println(freqHM);

        int[] result = new int[k];
        int irr = k - 1;

        while(irr >= 0){
            result[irr--] = minheap.poll().num;
        }

        return result;
    }
}
