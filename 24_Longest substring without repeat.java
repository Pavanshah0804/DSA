import java.util.*;
class Solution{
    public static int solve(String s){
        HashMap<Character, Integer> mpp = new HashMap<Character, Integer>();
        
        int n = s.length();
        int left = 0, right = 0;
        int len = 0;
        
        while(right<n){
            if(mpp.containsKey(s.charAt(right)))
                left = Math.max(left, s.charAt(right)+1);
                
            mpp.put(s.charAt(right),right); // char and its index will be put.
            len = Math.max(len, right-left+1);
            right++;
        }
        return len;
    }
    
    public static void main(String []args){
        String str = "abcabcbb";
        int result = solve(str);
        System.out.println("The longest substring without repeating character is : " + result);
    }
}