package LRUcache;

public class Main {

    public static void main(String[] args) {

        LRUCache lru = new LRUCache(2);

        lru.put(2,1);
        System.out.println(lru.head.key + " " + lru.tail.key );
        lru.put(1,1);
        System.out.println(lru.head.key + " " + lru.tail.key );
        lru.put(2,3);
        System.out.println(lru.head.key + " " + lru.tail.key );
        lru.put(4,1);
        System.out.println(lru.head.key + " " + lru.tail.key );

        System.out.println(lru.get(1));
        System.out.println(lru.get(2));



//        System.out.println(lru.get(3));

//        lru.put(5,5);




    }


}
