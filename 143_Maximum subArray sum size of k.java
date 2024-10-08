import java.util.*;

class Solution{
    
    public static long maximumSubArraySum(int []nums, int k){
        int n = nums.length;
        
        long maxSum = 0;
        long windowSum = 0;
        
        if(k>n) return 0;
        
        HashMap<Integer,Integer> elementCount = new HashMap<>();
        for(int i=0;i<k;i++){
            windowSum += nums[i];
            elementCount.put(nums[i],elementCount.getOrDefault(nums[i],0)+1);
        }
        
        // Check if the first window is valid (all distinct)
        if (elementCount.size() == k) {
            maxSum = windowSum; // Set maxSum if valid
        }

        // Slide the window through the rest of the array
        for (int i = k; i < n; i++) {
            // Remove the element going out of the window
            int outgoingElement = nums[i - k];
            windowSum -= outgoingElement;
            elementCount.put(outgoingElement, elementCount.get(outgoingElement) - 1);
            if (elementCount.get(outgoingElement) == 0) {
                elementCount.remove(outgoingElement);
            }

            // Add the new element entering the window
            int incomingElement = nums[i];
            windowSum += incomingElement;
            elementCount.put(incomingElement, elementCount.getOrDefault(incomingElement, 0) + 1);

            // Check if the current window is valid (all distinct)
            if (elementCount.size() == k) {
                maxSum = Math.max(maxSum, windowSum); // Update maxSum if valid
            }
        }

        return maxSum;
    }
    
    public static void main(String []args){
        int k = 3;
        int arr[] = {1,5,4,2,9,9,9};
        
        long ans = maximumSubArraySum(arr,k);
        System.out.println(ans);
    }
}