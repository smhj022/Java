package Heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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


        List<List<Integer>> cordPair = new ArrayList<>();

        cordPair.add(Arrays.asList(1,2));
        cordPair.add(Arrays.asList(1,1));
        cordPair.add(Arrays.asList(-1,4));
        cordPair.add(Arrays.asList(4,6));
        cordPair.add(Arrays.asList(0,0));
        cordPair.add(Arrays.asList(0,-1));

        System.out.println(heapQue.KSmallestDistFromOrigin(cordPair, 2));
    }
}
