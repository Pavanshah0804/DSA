import java.util.*;

class Solution {
    public static boolean wordBreak(String s, List<String> wordDict) {
        boolean []table = new boolean[s.length()+1];
        table[0] = true;

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (table[j] && wordDict.contains(s.substring(j, i))) {
                    table[i] = true;
                    break;
                }
            }
        }
        return table[s.length()];
    }
    public static void main(String []args){
        String s = "ilikesamsung";
        List<String> dictionary = new ArrayList<>();
        dictionary.add("i");
        dictionary.add("like");
        dictionary.add("sam");
        dictionary.add("sung");
        dictionary.add("samsung");
        dictionary.add("mobile");
        
        System.out.println(wordBreak(s,dictionary));
    }
    
}

