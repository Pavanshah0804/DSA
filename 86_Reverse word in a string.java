import java.util.*;

class Solution {
    public static String reverseWords(String str) {
        // split array by period of the character
        String[] words = str.split("\\.");
        StringBuilder sb  = new StringBuilder();
        
        for(int i=words.length-1;i>=0;i--){
            sb.append(words[i]);
            if(i!=0)
                sb.append(".");
        }
        return sb.toString().trim();
    }
    
    public static void main(String[] args) {
        String input = "much.very.program.this.like.i";
        String result = reverseWords(input);
        
        System.out.print(result);
    }
}
