import java.util.*;

class Solution{
    
    
    public static int[] calculateSpan(int []price,int n){
        int []span = new int[n];
        Stack<Integer> st = new Stack<>();
        
        for(int i=0;i<n;i++){
            // Pop elements while the current price is >= the price at the stack's top index
            while(!st.isEmpty() && price[st.peek()] <= price[i]){
                st.pop();
            }    
            span[i] = st.isEmpty() ? (i+1) : (i-st.peek());
            st.push(i);
        }
        return span;
    }
    
    public static void main(String []args){
        int []price = {100, 80, 60, 70, 60, 75, 85};
        int n = price.length;
        int []span = calculateSpan(price,n);
        
        for(int i: span){
            System.out.print(i+ " ");
        }
    }
}