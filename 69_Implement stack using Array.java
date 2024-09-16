import java.util.*;

class MyStack{
    private int []arr;
    private int top;
    
    public MyStack(){
        arr = new int[1000];
        top = -1;
    }
    
    public void push(int x){
        if(top<=1000){
            arr[++top]=x;
        }
        else{
            System.out.println("Stack is full");
        }
    }
    public int pop(){
        if(top!=-1){
            return arr[top--];
        }
        return -1;
    }
}


class Solution{
    public static void main(String []args){
        MyStack stack = new MyStack();
        
        stack.push(10);
        stack.push(20);
        stack.push(30);
        
        System.out.println(stack.pop());  
        System.out.println(stack.pop());  
        System.out.println(stack.pop());  
        System.out.println(stack.pop());  
    }
}