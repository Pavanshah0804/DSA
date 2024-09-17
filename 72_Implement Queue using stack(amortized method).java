import java.util.*;

class MyQueue{
    Stack <Integer> st1 = new Stack<>();
    Stack <Integer> st2 = new Stack<>();
    
    public void push(int x){
        while(st1.empty() == false){
            st2.push(st1.peek());
            st1.pop();
        }
        st1.push(x);        
        while(st2.empty() == false){
            st1.push(st2.peek());
            st2.pop();
        }
    }
    
    public int pop(){
        if(!st1.empty()){
            int val= st1.peek();
            st1.pop();
            return val;
        }
        return 0;
    }
    
    public int peek(){
        return st1.peek();
    }
    
    public int size() {
        return st1.size();
    }
}


class Solution {
    public static void main(String args[]) {
        MyQueue q = new MyQueue();
        q.push(3);
        q.push(4);
        System.out.println("The element poped is " + q.pop());
        q.push(5);
        System.out.println("The top element is " + q.peek());
        System.out.println("The size of the queue is " + q.size());

    }
}