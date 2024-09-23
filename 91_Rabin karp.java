import java.util.*;

class Solution{
    public static ArrayList<Integer> search (String pattern, String text){
        ArrayList<Integer> res = new ArrayList<>();
        final int d = 256;
        int q = 101;// Prime Number used for hashing
        int m = pattern.length();
        int n = text.length();
        
        int p = 0, t=0,h = 1;
        //calculate h = d ^ (m-1) % q;
        for(int i=0;i<m-1;i++){
            h = (h * d)%q;
        }
        
        //calculate initial value for the pattern and first character of window of the text
        for(int i=0;i<m;i++){
            p = (d * p + pattern.charAt(i))%q;
            t = (d * t + pattern.charAt(i))%q;
        }
        
        //Slide the pattern over the next one character at a time.
        for(int i=0;i<=n-m;i++){
            if(p == t){
                if(text.substring(i,i+m).equals(pattern)){
                    res.add(i+1);
                }
            }
            
            //calculate the hash value for next window of text.
            if(i < n-m){
                t = (d * (t-text.charAt(i) * h) + text.charAt(i+m))%q; //updated hash value.
                if(t<0){
                    t += q; // make sure t is non-negative
                }
            }
        }
        return res;
        
    }

    public static void main(String []args){
        String s1 = "geek";
        String s2 = "geeksforgeeks";
        
        System.out.println(search(s1,s2));
    }
}