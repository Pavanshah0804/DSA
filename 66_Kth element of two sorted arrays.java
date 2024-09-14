import java.util.*;

class Solution {
    public static long kthElement(int k, int arr1[], int arr2[]) {

        int n = arr1.length;
        int m = arr2.length;
        
        if(n > m){
            return kthElement(k,arr2,arr1);
        }
        
        int low = Math.max(0,k-m);
        int high = Math.min(k,n);
        
        while(low <= high){
            int mid1 = (low+high)/2;
            int mid2 = k - mid1;
            
            long l1 = mid1 == 0 ? Integer.MIN_VALUE : arr1[mid1-1];
            long l2 = mid2 == 0 ? Integer.MIN_VALUE : arr2[mid2-1];
            long r1 = mid1 == n ? Integer.MAX_VALUE : arr1[mid1];
            long r2 = mid2 == m ? Integer.MAX_VALUE : arr2[mid2];
            
            if(l1<=r2 && l2<=r1){
                return Math.max(l1,l2);
            }
            else if(l1>r2)
                high = mid1-1;
            else
                low = mid1+1;
        }
        return 1;
    }
    
    public static void main(String []args){
        int k = 5;
        int arr1[] = {2,3,6,7,9};
        int arr2[] = {1,4,8,10};
        System.out.println("The kthElement of two sorted array is "+kthElement(k,arr1,arr2));
        
    }
}