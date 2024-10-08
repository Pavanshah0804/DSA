import java.util.Collections;
import java.util.PriorityQueue;

class Solution {

    // Min heap to store the larger half of the numbers
    static PriorityQueue<Integer> minheap = new PriorityQueue<>();

    // Max heap to store the smaller half of the numbers
    static PriorityQueue<Integer> maxheap = new PriorityQueue<>(Collections.reverseOrder());

    // Method to add a number to the data structure
    public static void addNum(int num) {
        if (maxheap.isEmpty() || maxheap.peek() >= num) {
            maxheap.add(num);
        } else {
            minheap.add(num);
        }

        // Balance the heaps if needed
        if (maxheap.size() > minheap.size() + 1) {
            minheap.add(maxheap.poll());
        } else if (minheap.size() > maxheap.size()) {
            maxheap.add(minheap.poll());
        }
    }

    // Method to find the median of the numbers added so far
    public static double findMedian() {
        if (minheap.size() == maxheap.size()) {
            return (minheap.peek() + maxheap.peek()) / 2.0;
        }
        return maxheap.peek() / 1.0;
    }

    public static void main(String[] args) {
        
        addNum(10);
        addNum(20);
        addNum(30);

        System.out.println("Median is: " + findMedian());

        // Add more numbers
        addNum(25);

        // Find and print the new median
        System.out.println("New Median is: " + findMedian());
    }
}
