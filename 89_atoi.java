import java.util.*;

class Solution {
    public static int atoi(String s) {
        if (s.length() == 0) {
            return -1;  // Return -1 for empty input
        }
        
        long num = 0;
        char[] chars = s.toCharArray();
        int sign = 1;  // Default sign is positive
        int i = 0;
        
        // Skip leading whitespace
        while (i < chars.length && chars[i] == ' ') {
            i++;
        }
        
        // Check for sign
        if (i < chars.length) {
            if (chars[i] == '+') {
                i++;
            } else if (chars[i] == '-') {
                sign = -1;
                i++;
            }
        }
        
        // Convert characters to integer
        while (i < chars.length) {
            char current = chars[i];
            if (current < '0' || current > '9') {
                return -1;  // Return -1 for invalid input
            }
            num = num * 10 + (current - '0');
            
            // Check for overflow and underflow
            if (sign == 1 && num > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
            if (sign == -1 && -num < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
            i++;
        }
        
        return (int)(sign * num);
    }
    
    public static void main(String []args){
        String str = "-123";
        System.out.println(atoi(str));
    }
}

