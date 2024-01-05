package Arrays;

import javax.management.ObjectName;
import java.util.ArrayList;

public class ArrayDS {

    private int length;
    private ArrayList<Object> data;

    public ArrayDS(){
        this.length = 0;
        this.data = new ArrayList<>();
    }

    public Object get(int index){
        try{
            return data.get(index);
        } catch (Exception e){
            return "undefined";
        }

    }

    public void push(Object item){
        data.add(item);
        length++;
    }

    public Object pop(){
        Object removedItem = data.remove(length-1);
        length--;
        return removedItem;
    }

    public Object delete(int index){
        try {
            Object deletedItem = data.remove(index);
            length --;
            return deletedItem;
        } catch (Exception e){
            return "undefined";
        }
    }

    public Object getLength(){
        return length;
    }

    public ArrayList<Object> getData(){
        return data;
    }

}

