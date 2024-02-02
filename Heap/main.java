package Heap;

import java.util.Arrays;

public class main {

    public static void main(String[] args) {

//        Heap myHeap = new Heap();
//
//
//        myHeap.insert(95);
//        myHeap.insert(75);
//        myHeap.insert(80);
//        myHeap.insert(55);
//        myHeap.insert(60);
//        myHeap.insert(50);
//        myHeap.insert(65);
//
//        System.out.println(myHeap.getHeap());
//
//        myHeap.remove();
//        System.out.println(myHeap.getHeap());
//        myHeap.remove();
//        System.out.println(myHeap.getHeap());


        HeapQuestions heapQue = new HeapQuestions();

        int[] nums = {1,1,1,2,2,2,2,3,3,3,3,3,4,4,5,5,5,5,5,5,5,5,5,5};

        System.out.println(Arrays.toString(heapQue.topKFrequentNumber(nums, 2)));

    }
}
