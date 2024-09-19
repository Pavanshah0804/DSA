import java.util.*;

class LFUCache {

    final int capacity;
    int curSize;
    int minFrequency;
    Map<Integer, DLLNode> cache;
    Map<Integer,DoubleLinkedList> frequencyMap;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.curSize = 0;
        this.minFrequency = 0;

        this.cache = new HashMap<>();
        this.frequencyMap = new HashMap<>();
    }
    
    public int get(int key) {
        DLLNode curNode = cache.get(key);
        if(curNode == null){
            return -1;
        }
        updateNode(curNode);
        return curNode.val;
    }
    
    public void put(int key, int value) {
        if(capacity == 0){
            return;
        }

        if(cache.containsKey(key)){
            DLLNode curNode = cache.get(key);
            curNode.val = value;
            updateNode(curNode);
        }
        else{
            curSize++;
            if(curSize > capacity){
                //get min freuqency list
                DoubleLinkedList minFreqList = frequencyMap.get(minFrequency);
                cache.remove(minFreqList.tail.prev.key);
                minFreqList.removeNode(minFreqList.tail.prev);
                curSize--;
            }
            minFrequency = 1;
            DLLNode newNode = new DLLNode(key,value);
            
            //get the list with freq 1 and then add new node into the list, as well as into the LFU cache.
            DoubleLinkedList curList = frequencyMap.getOrDefault(1,new DoubleLinkedList());
            curList.addNode(newNode);
            frequencyMap.put(1,curList);
            cache.put(key, newNode);
        }
    }

    public void updateNode(DLLNode curNode){
        int curFreq = curNode.frequency;
        DoubleLinkedList curList = frequencyMap.get(curFreq);
        curList.removeNode(curNode);

        if(curFreq == minFrequency && curList.listSize == 0){
            minFrequency++;
        }

        curNode.frequency++;
        DoubleLinkedList newList = frequencyMap.getOrDefault(curNode.frequency, new DoubleLinkedList());
        newList.addNode(curNode);
        frequencyMap.put(curNode.frequency, newList);
    }

    class DLLNode{
        int key;
        int val;
        int frequency;
        DLLNode prev;
        DLLNode next;

        public DLLNode(int key,int val){
            this.key = key;
            this.val = val;
            this.frequency = 1;
        }
    }

    class DoubleLinkedList{
        int listSize;
        DLLNode head;
        DLLNode tail;

        public DoubleLinkedList(){
            this.listSize = 0;
            this.head = new DLLNode(0,0);
            this.tail = new DLLNode(0,0);
            head.next = tail;
            tail.prev = head;
        }

        public void addNode(DLLNode curNode){
            DLLNode nextNode = head.next;
            curNode.next = nextNode;
            curNode.prev = head;
            head.next = curNode;
            nextNode.prev = curNode;
            listSize++;
        }

        public void removeNode(DLLNode curNode){
            DLLNode prevNode = curNode.prev;
            DLLNode nextNode = curNode.next;
            prevNode.next = nextNode;
            nextNode.prev = prevNode;
            listSize--;
        }
    }
}


class Solution {
    public static void main(String[] args) {
        // Create an LFU cache with a capacity of 3
        LFUCache cache = new LFUCache(3);

        // Perform cache operations
        cache.put(1, 10);  // cache = {1=10}
        cache.put(2, 20);  // cache = {1=10, 2=20}
        cache.put(3, 30);  // cache = {1=10, 2=20, 3=30}

        // Get the value for key 1
        System.out.println(cache.get(1));  // Outputs 10, cache = {1=10, 2=20, 3=30}, frequency of key 1 is increased

        // Add another key-value pair, this will evict the least frequently used key
        cache.put(4, 40);  // cache = {1=10, 3=30, 4=40}, key 2 is evicted because it's least frequently used

        // Get the value for key 2 (this key was evicted)
        System.out.println(cache.get(2));  // Outputs -1 (not found)

        // Get the value for key 3
        System.out.println(cache.get(3));  // Outputs 30, cache = {1=10, 3=30, 4=40}, frequency of key 3 is increased

        // Add another key-value pair, this will evict the least frequently used key
        cache.put(5, 50);  // cache = {3=30, 4=40, 5=50}, key 1 is evicted because it's least frequently used

        // Get the value for key 1 (this key was evicted)
        System.out.println(cache.get(1));  // Outputs -1 (not found)

        // Get the value for key 4
        System.out.println(cache.get(4));  // Outputs 40
    }
}
