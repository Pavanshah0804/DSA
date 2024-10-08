import java.util.*;


class Solution{
    public static int[] kthLargest(int k, int[] arr, int n) {
        int result[] = new int[n];
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        for(int i=0;i<n;i++){
            minHeap.add(arr[i]);
            
            if(minHeap.size() > k){
                minHeap.poll();
            }
            if(minHeap.size() < k){
                result[i] = -1;
            }
            else{
                result[i]= minHeap.peek();
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int k = 4;
        int n = 6;
        int[] arr = {1, 2, 3, 4, 5, 6};
        
        int[] output = kthLargest(k, arr, n);
        for (int value : output) {
            System.out.print(value + " ");
        }
    }
}
