package Heap;

import java.util.*;

public class HeapQuestions {

    class Pair1 implements Comparable<Pair1>{

        List<Integer> pair = new ArrayList<>();
        int sum;

        public Pair1(int num1, int num2){
            this.sum = num1 + num2;
            this.pair.add(num1);
            this.pair.add(num2);
        }

        public int compareTo(Pair1 obj){
            return obj.sum - this.sum;
        }
    }

    class Pair implements Comparable<Pair>{
        int num, count;
        public Pair(int num, int count) {
            this.num = num;
            this.count = count;
        }
        public int compareTo(Pair b){
            return - b.count + this.count;
        }
    }

    class Pair2 implements Comparable<Pair2>{

        List<Integer> cord = new ArrayList<>();
        double dist;

        public Pair2(List<Integer> cord){
            this.cord = cord;
            this.dist = Math.pow(cord.get(0),2) + Math.pow(cord.get(1),2);
        }

        public int compareTo(Pair2 obj){
            return (int)(obj.dist-this.dist);
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


    public int[] freqSort(int[] nums){

        HashMap<Integer, Integer> freqHM = new HashMap<>();
        for(int num: nums){
            freqHM.put(num, freqHM.getOrDefault(num, 0)+1);
        }

        int[] res = new int[nums.length];
        int irr = 0;

        PriorityQueue<Pair> maxHeap = new PriorityQueue<>();

        Set<Integer> keys = freqHM.keySet();
        for(int key: keys){
            maxHeap.add(new Pair(key, freqHM.get(key)));
        }

        while(!maxHeap.isEmpty()){
            Pair obj = maxHeap.poll();

            for(int i = 0; i<obj.count; i++){
                res[irr++] = obj.num;
            }
        }

        return res;


    }


    // find the k smallest pair in the arrays having minimum sum
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {

        PriorityQueue<Pair1> maxHeap = new PriorityQueue<>();

        for(int i=0; i < k && i < nums1.length; i++){
            for(int j=0; j<k && j < nums2.length; j++){

                if(maxHeap.size() < k){
                    maxHeap.add(new Pair1(nums1[i], nums2[j]));
                } else if(maxHeap.peek().sum > nums1[i] + nums2[j]){
                    maxHeap.poll();
                    maxHeap.add(new Pair1(nums1[i], nums2[j]));
                }
            }
        }

        List<List<Integer>> res = new ArrayList<>();

        while(!maxHeap.isEmpty()){
            res.add(maxHeap.poll().pair);
        }

        return res;
    }

    //find the smallest pair hair having minimum distance form the origin

    public List<List<Integer>> KSmallestDistFromOrigin(List<List<Integer>> cordPair, int k){

        PriorityQueue<Pair2> maxHeap = new PriorityQueue<>();

        for(int i=0; i< cordPair.size(); i++){

            List<Integer> cord = cordPair.get(i);

            if(maxHeap.size() < k){
                maxHeap.add(new Pair2(cord));
            } else if (maxHeap.peek().dist > Math.pow(cord.get(0),2) + Math.pow(cord.get(1),2)){
                maxHeap.poll();
                maxHeap.add(new Pair2(cord));
            }
        }

        List<List<Integer>> res = new ArrayList<>();

        while(!maxHeap.isEmpty()){
            res.add(maxHeap.poll().cord);
        }

        return res;
    };
}
