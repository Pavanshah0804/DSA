import java.util.*;

class Solution {
    public static boolean isAnagram(String a, String b) {

        if(a.length() != b.length())
            return false;
        char []arr1 = a.toCharArray();
        char []arr2 = b.toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        
        return Arrays.equals(arr1,arr2);
    }
    
    public static void main(String []args){
        String s1 = "nagaram";
        String s2 = "anagram";
        
        System.out.print("Given two strings are anagram ? "+isAnagram(s1,s2));
        
    }
}