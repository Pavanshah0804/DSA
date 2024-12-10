import java.util.*;

class Solution {
    public static int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int n = nums.length;       
        int leftProduct = 1;        
        int rightProduct = 1;       
        int ans = nums[0];          

        // Loop through the array
        for (int i = 0; i < n; i++) {
            // Reset left and right products to 1 if they become 0
            leftProduct = leftProduct == 0 ? 1 : leftProduct;
            rightProduct = rightProduct == 0 ? 1 : rightProduct;

            // prefix product
            leftProduct *= nums[i];
	    
	    //suffix product
            rightProduct *= nums[n - i - 1];

            ans = Math.max(ans, Math.max(leftProduct, rightProduct));
        }

        return ans; 
    }

    public static void main(String[] args) {
        int[] nums1 = {2, 3, -2, 4};
        System.out.println("Max Product: " + maxProduct(nums1)); 
    }
}
