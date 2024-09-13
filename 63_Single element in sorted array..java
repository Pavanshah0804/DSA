import java.util.*;

class Solution{
    
    public static int singleNonDuplicate(int []nums){
        if(nums.length == 1)
            return nums[0];
        int low = 0,high = nums.length-2;
        while(low<=high){
            int mid = (low+high)/2;
            if(nums[mid] == nums[mid^1])
                low = mid+1;
            else
                high = mid-1;
            
        }
        return nums[low];
    }
    
    public static void main(String []args){
        int arr[] = {1,1,2,3,3,4,4,8,8};
        System.out.println("The Unique element is : "+singleNonDuplicate(arr));
    }
}

//1st instance - even index
//2nd instance - odd index