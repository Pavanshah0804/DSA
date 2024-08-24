import java.util.Scanner;
class Solution {
    
    //Dutch national flag algorithm
    public static void sortColors(int[] nums) {
        int low =0;
        int mid =0;
        int high = nums.length-1;

        while (mid <= high) {
            if (nums[mid] == 0) {
                swap(nums,low,mid);
                low++;
                mid++;
            } else if(nums[mid] == 1){
                mid++;
            }else {
                swap(nums,mid,high);
                high--;
            } 
        }
    }
    public static void swap(int arr[],int a,int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b]= temp;
    }
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];
        System.out.println("Enter values of 0,1,2.");
        
        for(int i=0;i<n;i++){
            a[i]=sc.nextInt();
        }
        sortColors(a);
        for(int i=0;i<n;i++){
            System.out.print(a[i]+" ");
        }
    }
}