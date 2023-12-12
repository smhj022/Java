package Heap;

import java.util.ArrayList;
import java.util.List;

public class Heap {

    private List<Integer> heap;

    public Heap(){
        this.heap = new ArrayList<>();
    }

    public List<Integer> getHeap(){
        return new ArrayList<>(heap);
    }

    public int leftChild(int index){
        return 2 * index + 1;
    }

    public int rightChild(int index){
        return 2 * index + 2;
    }

    public int parent(int index){
        return (index - 1) /2;
    }

    public void swap(int index1, int index2){
        int temp = heap.get(index1);
        heap.set(index1, heap.get(index2));
        heap.set(index2, temp);
    }

    public void insert(int value){

        heap.add(value);
        int current = heap.size() - 1;

        while(heap.get(parent(current)) < value && current > 0){
            swap(parent(current), current);
            current = parent(current);
        }
    }
}

