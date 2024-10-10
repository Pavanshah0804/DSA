import java.util.*;

class Solution {
    
    public static int findKthLargest(int []nums,int k){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i: nums){
            pq.add(i);
            if(pq.size() > k){
                pq.poll();
            }
        }
        return pq.poll();
    }
    
    public static int findKthSmallest(int[] nums, int k) {
        //Max-heap 
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a); // Collections.reverseOrder()
        
        for (int num : nums) {
            pq.add(num); // Add the current number to the heap
            if (pq.size() > k) {
                pq.poll(); // Remove the largest element if the size exceeds k
            }
        }
        return pq.poll(); // The top of the heap is the kth smallest element
    }

    public static void main(String[] args) {
        int[] nums = {7, 10, 4, 3, 20, 15};
        int k = 2;
        System.out.println("The " + k + "nd smallest element is: " + findKthSmallest(nums, k));

        System.out.println("The " + k + "nd largest element is: " + findKthLargest(nums, k));
    }
}
