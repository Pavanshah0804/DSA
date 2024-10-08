import java.util.*;

class Solution{
    public static ArrayList<Integer> countDistinct(int A[], int k,int n){
        ArrayList<Integer> result = new ArrayList<>();
        
        HashMap<Integer,Integer> frequencyMap = new HashMap<>();
        
        //Initialize the frequency map with first k element.
        for(int i=0;i<k;i++){
            frequencyMap.put(A[i],frequencyMap.getOrDefault(A[i],0)+1);
        }
        
        //add the count of first sliding window.
        result.add(frequencyMap.size());
        
        // Slide the window
        for (int i = k; i < n; i++) {
            // Element going out of the window
            int outgoingElement = A[i - k];
            frequencyMap.put(outgoingElement, frequencyMap.get(outgoingElement) - 1);
            // If frequency becomes zero, remove it from the map
            if (frequencyMap.get(outgoingElement) == 0) {
                frequencyMap.remove(outgoingElement);
            }

            // Element coming into the window
            int incomingElement = A[i];
            frequencyMap.put(incomingElement, frequencyMap.getOrDefault(incomingElement, 0) + 1);

            // Add the count of distinct elements in the current window
            result.add(frequencyMap.size());
        }

        return result;
        
    }
    
    public static void main(String []args){
        int n = 7;
        int k = 4;
        int arr[] = {1, 2, 1, 3, 4, 2, 3};
        
        ArrayList<Integer> result = countDistinct(arr,k,n);
        System.out.print(result);
    }
}