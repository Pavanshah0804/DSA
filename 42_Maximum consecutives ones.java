import java.util.Scanner;

class Solution {
    public static int findMaxConsecutiveOnes(int[] nums) {
        int count = 0;
        int ans = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i] == 1){
                count++;
                ans = Math.max(count, ans);
            }
            else{
                count = 0;
            }
        }
        return ans;
    }
    
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        
        int ans = findMaxConsecutiveOnes(arr);
        System.out.println(ans);
    }
}
