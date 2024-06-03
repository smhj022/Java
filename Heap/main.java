package Heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

class Pair {
    int sum;
    public Pair(int v1, int v2){
        this.sum = v1 + v2;
    }
}

class Cord implements Comparable<Cord>{

    int i;
    int j;
    int val;

    public Cord(int i, int j, int val){
        this.i = i;
        this.j = j;
        this.val = val;
    }

    public int compareTo(Cord obj){
        return -obj.val + this.val;
    }
}

public class main {

    public static void main(String[] args) {

//        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> a.sum-b.sum);
//
//        pq.add(new Pair(1,1));
//        pq.add(new Pair(2,4));
//        pq.add(new Pair(3,5));
//        pq.add(new Pair(4,6));


        int[][] matrix = {
                {1, 5, 9},
                {5, 6, 10},
                {6, 7, 12}
        };

        PriorityQueue<Cord> minHeap = new PriorityQueue<>();

        int row = matrix.length;
        int column = matrix[0].length;

        int k = 8;

        for(int i = 0; i < column ; i++){
            minHeap.add(new Cord(i,0,matrix[i][0]));
        }

//        while (!minHeap.isEmpty()){
//            System.out.println(minHeap.poll().val);
//        }

        ArrayList<Integer> result = new ArrayList<>();

        while(!minHeap.isEmpty() && k > 0){

            Cord temp = minHeap.poll();

            int temp_j = temp.j;

            if(temp_j < column-1){
                minHeap.add(new Cord(temp.i, temp_j + 1, matrix[temp.i][temp_j+1]));
            }

            result.add(temp.val);
            k--;
        }

        System.out.println(result);


        ArrayList<ArrayList<Integer>> A = new ArrayList<>();

        A.add(new ArrayList<>(Arrays.asList(5, 9, 11)));

        // Initialize and add the second row (for example purposes)
        A.add(new ArrayList<>(Arrays.asList(6, 10, 12)));

        // Initialize and add the third row (for example purposes)
//        A.add(new ArrayList<>(Arrays.asList(7, 13, 14)));

        row = 2;

        for(int i = 0; i < row ; i++){
            System.out.println(A.get(i).get(0));
        }
    }
}
