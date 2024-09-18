import java.util.*;

class Solution{
    public static Stack<Integer> sort(Stack<Integer> st){
        if(!st.empty()){
            int top = st.pop();
            sort(st);
            insertSorted(st,top);
        }
        return st;
    }
    
    private static void insertSorted(Stack<Integer> stack, int element){
        if(stack.empty() || element >= stack.peek()){
            stack.push(element);
        }
        else{
            int top = stack.pop();
            insertSorted(stack,element);
            stack.push(top);
        }
    }
    
    public static void main(String[] args) {
        
        Stack<Integer> stack = new Stack<>();
        stack.push(30);
        stack.push(10);
        stack.push(50);
        stack.push(20);
        stack.push(40);

        Stack<Integer> sortedStack = sort(stack);

        System.out.println("Sorted stack:");
        while (!sortedStack.empty()) {
            System.out.print(sortedStack.pop()+" ");
        }
    }
}


