import java.util.*;

class Solution{
    
    public static int[] nextLargerElement(int []arr, int []arr2){
        
        if (arr.length == 0 || arr2.length == 0)
            return new int[0];
        
        Map<Integer,Integer> numberNGE = new HashMap<>();
        Stack<Integer> st = new Stack<>();
        
        for(int i=arr2.length-1;i>=0;i--){
            while(!st.isEmpty() && st.peek() <= arr2[i]){
                st.pop();
            }
            
            if(st.isEmpty()) numberNGE.put(arr2[i],-1);
            else numberNGE.put(arr2[i],st.peek()) ;
            st.push(arr2[i]);
        }
        
        for (int i = 0; i < arr.length; i++)
            arr[i] = numberNGE.get(arr[i]);

        return arr;
    }
    
    public static void main(String []args){
        int arr[] = {2,4};
        int arr1[] = {1,2,3,4};
        
        int ans[] = nextLargerElement(arr,arr1);
        
        for(int i: ans){
            System.out.print(i+" ");
        }
    }
}