import java.util.*;

class Solution {
    public static String longestCommonPrefix(String[] strs) {
        if(strs.length == 0)
            return "";
        Arrays.sort(strs);
        StringBuilder result = new StringBuilder();
        char []first = strs[0].toCharArray();
        char []last = strs[strs.length-1].toCharArray();

        for(int i=0;i<first.length;i++){
            if(first[i] != last[i])
                break;
            result.append(first[i]);
        }

        return (result.length() == 0) ? "-1" : result.toString();
    }
    
    public static void main(String []args){
        String arr[] = {"geeksforgeeks", "geeks", "geek", "geezer"};
        System.out.println("Longest Common prefix is : "+longestCommonPrefix(arr));
    }
}
