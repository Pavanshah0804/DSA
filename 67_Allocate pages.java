import java.util.*;

class Solution {
    public static int splitArray(int[] nums, int k) {
        if (k > nums.length)
            return -1;
        int low = 0,high = 0,res = -1;
        for(int i=0;i<nums.length;i++){
            low = Math.max(low,nums[i]);
            high += nums[i];
        }

        while(low <= high){
            int mid = (low+high)/2;
            int students = countStudents(nums, mid);
            if(students > k){
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }
        return low;

    }

    public static int countStudents(int []nums,int barrier){
        int n = nums.length;
        int students = 1;
        long pagesStudent = 0;
        for(int i=0;i<n;i++){
            if(pagesStudent + nums[i] <= barrier){
                pagesStudent += nums[i]; // add pages to current student
            }
            else{
                students++;
                pagesStudent = nums[i]; // add pages to next student
            }
        }
        return students;
    }
    
    public static void main(String []args){
        int []arr={7,2,5,10,8};
        int k = 2;
        
        System.out.println("The ans is "+splitArray(arr,k));
    }
}