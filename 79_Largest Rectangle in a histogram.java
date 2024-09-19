import java.util.*;

class Solution{
    
    public static int LargestRectangleArea(int []heights){
        int n = heights.length;
        Stack<Integer> st = new Stack<>();
        int max_area = 0;
        
        for(int i=0;i<=n;i++){
            while(!st.isEmpty() && (i==n || heights[st.peek()] >= heights[i])){
                int h = heights[st.pop()]; // heights of the bar at the top of stack.
                
                int w = st.isEmpty() ?  i :  i-st.peek()-1;
                
                max_area = Math.max(h*w,max_area);
            }
            st.push(i);
        }
        return max_area;
    }
    
    public static void main(String []args){
        int arr[] = {2,1,5,6,2,3};
        System.out.println("The largest area in the histogram is " + LargestRectangleArea(arr));
    }
}