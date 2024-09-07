import java.util.*;

class Solution {
    public static int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int j=0,ans = 0;
        for(int i:g){
            while(j<s.length && s[j]<i){
                j++;
            }
            if(j==s.length) return ans;
            else{
                j++;
                ans++;
            }
        }
        return ans;
    }
    public static void main(String []args){
        int a[] = {1,2};
        int b[] = {1,2,3};
        
        int ans = findContentChildren(a,b);
        System.out.print("Minimum no. of cookies are: "+ans);
        
    }
}
