import java.util.*;

class Solution{
    
    public static int[] nextLargerElement(int []arr, int n){
        int []nge = new int[n];
        Stack<Integer> st = new Stack<>();
        
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && st.peek() <= arr[i]){
                st.pop();
            }
            
            if(st.isEmpty()) nge[i] = -1;
            else nge[i] = st.peek();

            st.push(arr[i]);
        }
        return nge;
    }
    
    public static void main(String []args){
        int arr[] = {4,12,5,3,1,2,5,3,1,2,4,6};
        
        int ans[] = nextLargerElement(arr,arr.length);
        
        for(int i: ans){
            System.out.print(i+" ");
        }
    }
}