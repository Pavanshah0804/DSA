import java.util.*;

class Solution{
    public static int editDistance(String s1,String s2){
        int n = s1.length();
        int m = s2.length();
        
        int []prev = new int[m+1];
        int []cur = new int[n+1];
        
        //Initialize first row with their respective indices
        for(int i=0;i<=m;i++){
            prev[i] = i;
        }
        
        //Fill the current array using bottom-up approach
        for(int i=1;i<=n;i++){
            cur[0] = i;
            for(int j=1;j<=m;j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    cur[j] = prev[j-1]; //char match then take value from diagonal
                }
                else{
                    //If char doesn't match take min of 3 possibility.
                    //1 Replace char s1 with s2 (diagonal).
                    //2 Delete the char in s1.
                    //3 Insert char from s2 into s1.
                    cur[j] = 1 + Math.min(prev[j-1], Math.min(prev[j], cur[j-1]));
                }
            }
            int []temp = prev;
            prev = cur;
            cur = temp;
        }
        //return previous array's last value.
        return prev[m];
    }

    public static void main(String args[]) {
        String s1 = "horse";
        String s2 = "ros";

        System.out.println("The minimum number of operations required is: " +
                editDistance(s1, s2));
    }
}