import java.util.*;

class MyQueue{
    int front, rear;
    int arr[] = new int[100005];
    int size = arr.length;
    
    MyQueue() {
        front = 0;
        rear = 0;
    }
    
    void push(int x){
        arr[rear] = x;
        rear = (rear+1) % size;
    }
    
    int pop(){
        if(front == rear)
            return -1;
        int ans = arr[front];
        front = (front+1)%size;
        
        
        if(front == rear){
            front = rear = 0;
        }
        
        return ans;
    }
}

class Solution{
    public static void main(String[] args) {
        MyQueue queue = new MyQueue();  

        queue.push(10);
        queue.push(20);
        queue.push(30);

        System.out.println("Popped: " + queue.pop());  
        System.out.println("Popped: " + queue.pop());  

        queue.push(40);

        System.out.println("Popped: " + queue.pop());  
        System.out.println("Popped: " + queue.pop());   
        
        System.out.println("Popped: " + queue.pop());  
    }
}