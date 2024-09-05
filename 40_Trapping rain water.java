import java.util.Scanner;

class Solution{
    public int trap(int []height){
        int n = height.length;
        int left=0,res=0;
        int right = n-1;
        int maxleft = 0;
        int maxright = 0;
        
        while(left<=right){
            if(height[left]<=height[right]){
                if(height[left] >= maxleft) maxleft = height[left];
                else res += maxleft - height[left];
                left++;
            }else{
                if(height[right] >= maxright) maxright = height[right];
                else res += maxright - height[right];
                right++;
            }
        }
        return res;
    }   
    public static void main(String []args){
        Solution sol = new Solution();
        int arr[] = {4,2,0,3,2,5};
        
        System.out.println(sol.trap(arr));
    }
}