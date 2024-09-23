import java.util.*;

class Solution {

    public static String longestPalindrome(String str) {
        if (str.length() <= 1) {
            return str;
        }

        String LPS = "";
        
        for (int i = 0; i < str.length(); i++) {
            // Check for both odd and even length palindromes
            String oddPalindrome = expandAroundCenter(str, i, i);
            String evenPalindrome = expandAroundCenter(str, i, i + 1);
            
            // Update LPS if found a longer palindrome
            LPS = (oddPalindrome.length() >= LPS.length()) ? oddPalindrome : LPS;
            LPS = (evenPalindrome.length() > LPS.length()) ? evenPalindrome : LPS;
        }

        // If no longer palindrome was found, return the first character
        return LPS.length() < 2 ? String.valueOf(str.charAt(0)) : LPS;
    }

    private static String expandAroundCenter(String str, int low, int high) {
        // Expand outwards while characters are equal
        while (low >= 0 && high < str.length() && str.charAt(low) == str.charAt(high)) {
            low--;
            high++;
        }
        
        return str.substring(low + 1, high);
    }

    public static void main(String[] args) {
        String s = "aaaabbaa";
        System.out.println("Longest Palindromic Substring: " + longestPalindrome(s));
    }
}
