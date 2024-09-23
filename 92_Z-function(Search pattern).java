import java.util.ArrayList;

class Solution {
    public static ArrayList<Integer> search(String pat, String S) {
        
        ArrayList<Integer> result = new ArrayList<>();
        int n = S.length();
        int m = pat.length();
        
        for(int i = 0; i <= n - m; i++) {
            //String pat from index i to i+m is substring of S?
            if (S.substring(i, i + m).equals(pat)) {
                result.add(i + 1);
            }
        }
        if(result.isEmpty()){
            result.add(-1);
        }
        
        return result;
    }
    
    public static void main(String []args){
        String s1 = "bat";
        String s2 = "batmanandrobinarebat";
        
        System.out.println(search(s1,s2));
    }
}
