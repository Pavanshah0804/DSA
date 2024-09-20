import java.util.*;

class Solution{

    public static int[] maxOfmin(int []arr,int n){
        int left[] = new int[n];
        int right[] = new int[n];
        
        Stack<Integer> st = new Stack<>();
        
        // Fill left array with nearest smaller elements to the left
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && arr[st.peek()] >= arr[i]){
                st.pop();
            }
            left[i] = st.isEmpty() ? -1: st.peek();
            st.push(i);
        }
        
        st.clear();
        
        // Fill right array with nearest smaller elements to the right
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && arr[st.peek()] >= arr[i]){
                st.pop();
            }
            right[i] = st.isEmpty()?n:st.peek();
            st.push(i);
        }
        //Array to store result for each window size.
        int result[] = new int[n+1];
        
        for(int i=0;i<n;i++){
            int len = right[i] - left[i] -1;
            
            //Update the result for window size
            result[len] = Math.max(arr[i],result[len]);
        }
        
        // Fill remaining entries for smaller window size.
        for(int i=n-1;i>=1;i--){
            result[i] = Math.max(result[i], result[i+1]);
        }
        
        int []output = new int[n+1];
        System.arraycopy(result,1,output,0,n);
        
        return output;
    }

    public static void main(String []args){
        int arr[] = {10,20,30,50,10,70,30};
        int n = arr.length;
        
        int []ans = maxOfmin(arr,n);
        for(int i=0;i<n-1;i++){
            System.out.print(ans[i]+" ");
        }
    }    
}

