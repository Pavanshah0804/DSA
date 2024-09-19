import java.util.*;

class Solution{
    public static int[] maxSlidingWindow(int []arr, int k){
        int n = arr.length;
        int ans[] = new int[n-k+1];
        int index = 0;//store the index
        
        Deque<Integer>  q = new ArrayDeque<>();
        
        for(int i=0;i<n;i++){
            //removes number out of range k
            if(!q.isEmpty() && q.peek() == i-k){
                q.poll();
            }
            //remove smaller numbers in range k as they are useless.
            while(!q.isEmpty() && arr[q.peekLast()] < arr[i]){
                q.pollLast();
            }
            
            q.offer(i);
            if(i>=k-1){
                ans[index++] = arr[q.peek()];
            }
        }
        return ans;
        
    }
    
    public static void main(String []args){
        int arr[]={4,0,-1,3,5,3,6,8};
        int k = 3;
        int ans[] = maxSlidingWindow(arr, k);
        System.out.println("Maximum element in every " + k + " window ");
        for(int i=0;i<ans.length;i++){
            System.out.print(ans[i]+" ");
        }
    }
}