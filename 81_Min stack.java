import java.util.*;

class Solution{
    Stack<Long> st;
    Long mini;
    
    // Constructor
    public Solution(){
        st = new Stack<>();
        mini = Long.valueOf(Integer.MAX_VALUE);
    }
    
    // Push method
    public void push(int value){
        Long val = Long.valueOf(value);
        if(st.isEmpty()){
            mini = val;
            st.push(val);
        }
        else{
            if(val < mini){
                st.push(2 * val - mini);
                mini = val;
            }else{
                st.push(val);
            }
        }
    }
    
    // Pop method
    public void pop(){
        if(st.isEmpty()) return;
        Long val = st.pop();
        if(val < mini){
            mini = 2 * mini - val;
        }
    }
    
    // Top method
    public int top(){
        Long val = st.peek();
        if (val < mini) {
            return mini.intValue();
        }
        return val.intValue();
    }
    
    // Get minimum element
    public int getMin() {
        return mini.intValue();
    }
}

public class Main {
    public static void main(String[] args) {
        Solution minStack = new Solution();
        
        minStack.push(5);
        System.out.println("Top: " + minStack.top()); // Top should be 5
        System.out.println("Min: " + minStack.getMin()); // Min should be 5
        
        minStack.push(3);
        System.out.println("Top: " + minStack.top()); // Top should be 3
        System.out.println("Min: " + minStack.getMin()); // Min should be 3
        
        minStack.push(7);
        System.out.println("Top: " + minStack.top()); // Top should be 7
        System.out.println("Min: " + minStack.getMin()); // Min should still be 3
        
        minStack.pop();
        System.out.println("Top: " + minStack.top()); // Top should be 3
        System.out.println("Min: " + minStack.getMin()); // Min should still be 3
        
        minStack.pop();
        System.out.println("Top: " + minStack.top()); // Top should be 5
        System.out.println("Min: " + minStack.getMin()); // Min should now be 5
    }
}
