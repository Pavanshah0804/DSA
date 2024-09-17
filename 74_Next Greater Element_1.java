import java.util.*;

class Solution {

  public static int[] nextGreaterElement(int[] nums1, int[] nums2) {

    if (nums2.length == 0 || nums1.length == 0)
      return new int[0];

    Map<Integer, Integer> numberNGE = new HashMap<>();
    Stack<Integer> numStack = new Stack<>();

    numStack.push(nums2[nums2.length - 1]);
    numberNGE.put(nums2[nums2.length - 1], -1);

    for (int i = nums2.length - 2; i >= 0; i--) {

      if (nums2[i] < numStack.peek()) {
        numberNGE.put(nums2[i], numStack.peek());
        numStack.push(nums2[i]);
        continue;
      }

      while (!numStack.isEmpty() && numStack.peek() < nums2[i])
        numStack.pop();

      if (numStack.isEmpty()) {
        numStack.push(nums2[i]);
        numberNGE.put(nums2[i], -1);
      } else {
        numberNGE.put(nums2[i], numStack.peek());
        numStack.push(nums2[i]);
      }
    }

    for (int i = 0; i < nums1.length; i++)
      nums1[i] = numberNGE.get(nums1[i]);

    return nums1;
  } 
    
    
    public static void main(String []args){
        int []nums1 = {2,4};
        int []nums2 = {1,2,3,4};
        
        int arr[] = nextGreaterElement(nums1,nums2);
        System.out.println("The next greater elements are ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

    }

}