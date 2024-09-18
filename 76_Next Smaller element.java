import java.util.*;

class Solution{
    public static List<Integer> leftSmaller(int n, int []arr){
        List<Integer>nse = new ArrayList<>();
        Stack<Integer> st = new Stack<>();
        
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && st.peek() >= arr[i]){
                st.pop();
            }
            
            nse.add(st.isEmpty() ?-1 : st.peek());
            st.push(arr[i]);
        }
        return nse;
    }
    
    public static void main(String []args){
        int arr[] = {1,5,0,3,4,5};
        List<Integer> ans = new ArrayList<>();
        ans = leftSmaller(arr.length,arr);
        
        for(int i=0;i<arr.length;i++){
            System.out.print(ans.get(i)+" ");
        }
    }
}