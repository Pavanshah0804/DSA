import java.util.*;

class Solution{
    
    public static int search(int []nums,int target){
        int low = 0, high = nums.length-1;
        while(low<=high){
            int mid = (low+high)>>1;
            if(nums[mid] == target)
                return mid;
            
            //left side is sorted
            if(nums[low]<=nums[mid]){
                if(nums[low] <= target && target<=nums[mid]){
                    high = mid - 1;
                }
                else{
                    low = mid+1;
                }
            }
            
            //right side is sorted
            else{
                if(nums[mid]<=target && target<=nums[high]){
                    low = mid+1;
                }
                else{
                    high = mid - 1;
                }
            }
        }
        return -1;
    }
    
    public static void main(String []args){
        int arr[] = {4,5,6,7,0,1,2};
        int target = 0;
        int ans = search(arr,target);
        if(ans == -1){
            System.out.println("Can't find element.");
        }
        else{
            System.out.println("Element is at index "+ans);
        }
    }
}