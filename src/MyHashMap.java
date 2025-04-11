import java.util.*;

public class MyHashMap<K,V> {
    private static int default_capacity = 16;
    private int capacity;
    private int size;
    private LinkedList<Node<K,V>>[] buckets;

    private static class Node<K,V>{
        K key;
        V value;
        public Node(K key,V value){
            this.key = key;
            this.value = value;
        }
    }
    @SuppressWarnings("unchecked")
    public MyHashMap(){
        this.capacity = default_capacity;
        this.buckets = new LinkedList[capacity];
        for(int i = 0; i < capacity;i++){
            buckets[i] = new LinkedList<>();
        }
        this.size = 0;
    }
    private int getBucketIndex(K key) {
        return Math.abs(key.hashCode()) % capacity;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public V get(K key) {
        int indexBucket = getBucketIndex(key);
        LinkedList<Node<K, V>> bucket = buckets[indexBucket];
         for(Node<K, V> node:bucket){
             if(node.key.equals(key)) {
                 return node.value;
             }
        }
         return null;

    }

    public void put(K key, V value) {
        int indexBucket = getBucketIndex(key);
        LinkedList<Node<K, V>> bucket = buckets[indexBucket];
        for(Node<K, V> node:bucket) {
            if (node.key.equals(key)) {
                node.value = value;
                return;
            }
        }
        bucket.add(new Node<>(key,value));
        size++;
    }

    public V remove(K key) {
        int indexBucket = getBucketIndex(key);
        LinkedList<Node<K, V>> bucket = buckets[indexBucket];
        for(Node<K, V> node:bucket) {
            if (node.key.equals(key)) {
                bucket.remove(node);
                size--;
                return node.value;
            }
        }
        return null;
    }

    public void clear(){
        for(int i = 0; i < capacity;i++){
            buckets[i] = new LinkedList<>();
        }
        size = 0;
    }
    public void display(){
        for (int i = 0; i < buckets.length;i++) {
            LinkedList<Node<K, V>> bucket = buckets[i];
            if (!bucket.isEmpty()) {
                System.out.print("Bucket " + i + ": ");
                for (Node<K, V> node : bucket) {
                    System.out.print("[" + node.key + " -> " + node.value + "] ");
                }
                System.out.println();
            } else {
                System.out.println("Bucket " + i + ": (empty)");
            }
        }
    }
    private void resize(){
        int newCapacity = capacity * 2;
        LinkedList<Node<K, V>>[] newBuckets = new LinkedList[newCapacity];

        for (int i = 0; i < newCapacity; i++) {
            newBuckets[i] = new LinkedList<>();
        }

        for (LinkedList<Node<K, V>> bucket : buckets) {
            for (Node<K, V> node : bucket) {
                int newBucketIndex = Math.abs(node.key.hashCode()) % newCapacity;
                newBuckets[newBucketIndex].add(node);
            }
        }

        buckets = newBuckets;
        capacity = newCapacity;
    }
}
